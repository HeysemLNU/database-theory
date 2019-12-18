const mysql = require('mysql');
const fs = require('fs');
const readline = require('readline');
const constrained = true;

// the values will be hardcoded
let connection = '';
let bigArray = [];

/* const connectionRestricted = mysql.createConnection({
    host: 'localhost',
    user: 'albert',
    password: 'password1',
    database: 'reddit2restricted',
    insecureAuth: true
})
 */
// let importfiles = ['RC_2007-10.redditjson', 'RC_2011-07.redditjson', 'RC_2012-12.redditjson'];
const importfiles = ['RC_2011-07.redditjson'];

const getConnection = () => {
  const options = {
    host: 'localhost',
    user: 'albert',
    password: 'password1',
    insecureAuth: true,
  };

  if (constrained) {
    options.database = 'reddit2restricted';
  } else {
    options.database = 'reddit1';
  }
  return mysql.createConnection(options);
};

const escaper = (string) => {
  // return string.replace(/"/g, '\\"').replace(/\\/g, '\\\\').replace(/\\n || \\r || \\r\\n/g, '\\\r\\\n');
  return string.replace(/"/g, '\\"').replace(/\\/g, '\\\\');
};

const dataProcess = (importfile) => {
  const instream = fs.createReadStream(importfile);
  const rl = readline.createInterface(instream);

  connection = getConnection();

  connection.connect(() => {
    // create tables first if they dont exist with and without constraints
    if (constrained) {
      // it is important that the queries are done in this order
      // in constraint mode because of the foreign key usage.
      // if the table with the key we want to use as a foreign key doesnt exist
      // then when assigning a foreign key in another table it wont work
      // so what is going to be done is load the whole file into memory
      // and THEN we can iterate on it 3 times (one for each of our tables)
      connection.query(`CREATE TABLE IF NOT EXISTS subreddits (
                    id VARCHAR(15) PRIMARY KEY,
                    name VARCHAR(255) NOT NULL
                )`);
      connection.query(`CREATE TABLE IF NOT EXISTS posts (
                    id VARCHAR(15) PRIMARY KEY,
                    subr_id VARCHAR(15), 
                    CONSTRAINT FOREIGN KEY(subr_id) REFERENCES subreddits(id)
                )`);
      connection.query(`CREATE TABLE IF NOT EXISTS comments (
                    id VARCHAR(15) PRIMARY KEY,
                    parent_id VARCHAR(15) NOT NULL,
                    body TEXT NOT NULL,
                    score INT NOT NULL,
                    created_time INT(11) NOT NULL,
                    author VARCHAR(100) NOT NULL,
                    post_id VARCHAR(15),
                    CONSTRAINT FOREIGN KEY(post_id) REFERENCES posts(id)
                )`);
    } else {
      // here it doesnt matter the order we create the tables
      connection.query(`CREATE TABLE IF NOT EXISTS subreddits (
                    id VARCHAR(15),
                    name VARCHAR(255)
                )`);
      connection.query(`CREATE TABLE IF NOT EXISTS posts (
                    id VARCHAR(15),
                    subr_id VARCHAR(15) 
                )`);
      connection.query(`CREATE TABLE IF NOT EXISTS comments (
                    id VARCHAR(15),
                    parent_id VARCHAR(15),
                    body TEXT,
                    score INT,
                    created_time INT(11),
                    author VARCHAR(100),
                    post_id VARCHAR(15)
                )`);
    }

    rl.on('line', (line) => {
      if (constrained) {
        // if the database is constrained i need to check if the field exists
        // first in the database already (the primary key of the table)
        // or whatever else is supposed to be unique.

        // also something that I have thought... they should
        // the tables that are a dependency to other tables
        // should be filled up first before the others can be filled
        // so here I will just load it all into memory and will act
        // upon the thing on the "close" event (e.g iterate through it)
        bigArray.push(line);
      } else {
        // time to add data to the dbs, we will start with the subreddit db
        const parsedLine = JSON.parse(line);
        connection.query(`INSERT INTO subreddits (id, name) 
      VALUES ("${parsedLine.subreddit_id}","${parsedLine.subreddit}")`);

        connection.query(`INSERT INTO posts (id, subr_id)
      VALUES ("${parsedLine.link_id}","${parsedLine.subreddit_id}")`);

        connection.query(`INSERT INTO comments (id, parent_id, body, score
        ,created_time, author, post_id)
        VALUES ("${parsedLine.id}","${parsedLine.parent_id}","${parsedLine.body}"
          ,"${parsedLine.score}","${parsedLine.created_utc}","${parsedLine.author}"
          ,"${parsedLine.link_id}")`);

      // FAT TODO, so apparenlty in the unconstrained db
      // we don't need to check for duplicate numbers, whereas
      // in the constrained db first we need to do a query to see
      // whether the entry exists already, or the query will
      // spit out an error when trying to send it in :)
      }
    });

    rl.on('close', () => {
      if (constrained) {
        // need to go through the whole file 3 times what a cpu and RAM
        // death for the constrained mode.. first will be the database
        for (let counter = 0; counter < bigArray.length; counter++) {
          const parsedLine = JSON.parse(bigArray[counter]);

          connection.query(`INSERT INTO subreddits(id, name) VALUES
          ("${parsedLine.subreddit_id}", "${parsedLine.subreddit}")
          ON DUPLICATE KEY UPDATE id = "${parsedLine.subreddit_id}"`, () => {
            console.log(`SENT QUERY FOR LINE ${counter} of table SUBREDDITS into DB`);
          });
          // what the above will do is just do nothing if the row already
          // exists in the database (it will update the key with the same value
          // so essentially it's like doing nothing)
        } // once the first table is done, then we do the next table

        for (let counter = 0; counter < bigArray.length; counter++) {
          const parsedLine = JSON.parse(bigArray[counter]);
          connection.query(`INSERT INTO posts (id, subr_id)
          VALUES ("${parsedLine.link_id}","${parsedLine.subreddit_id}")
          ON DUPLICATE KEY UPDATE id = "${parsedLine.link_id}"`, () => {
            console.log(`SENT QUERY FOR LINE ${counter} of table POSTS into DB`);
          });
        }

        for (let counter = 0; counter < bigArray.length; counter++) {
          const parsedLine = JSON.parse(bigArray[counter]);
          connection.query(`INSERT INTO comments (id, parent_id, body, score
            ,created_time, author, post_id)
            VALUES ("${parsedLine.id}","${parsedLine.parent_id}","${parsedLine.body}"
              ,"${parsedLine.score}","${parsedLine.created_utc}","${parsedLine.author}"
              ,"${parsedLine.link_id}")
              ON DUPLICATE KEY UPDATE id = "${parsedLine.id}"`, () => {
            console.log(`SENT QUERY FOR LINE ${counter} of table COMMENTS into DB`);
          });
        }
        console.log('DONE ADDING TO DATABASE');
        bigArray = null;
      } else {
        connection.end((err) => {
          if (err) {
            console.error(err);
          }
          console.log('ALL DONE ON CURRENT FILE CONNECTION TO ONE DB CLOSED');
        });
      }
    });
  });
};


const init = () => {
  /* if (process.argv.length < 6) {
        console.error('There are not enough arguments!\nargument order:
         <host> <user> <password> <database>')
        } else {
            host = process.argv[2];
            user = process.argv[3];
            password = process.argv[4];
            database = process.argv[5];


            //launch(host)
        } */
  launch();
};

const launch = () => {
  // opening the connection of the databse happens later
  for (let counter = 0; counter < importfiles.length; counter++) {
    dataProcess(importfiles[counter]);
  }
};


/*  for(let counter = 0; counter < importfiles.length ; counter++) {
         dataProcess(importfiles[counter])
     } */

/* this.connection = mysql.createConnection({
    host:
}) */
init();

