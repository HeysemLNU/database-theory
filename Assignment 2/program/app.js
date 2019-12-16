const mysql = require('mysql');
const fs = require('fs');
const readline = require('readline');
const constrained = false;

// the values will be hardcoded
let connection = '';

/* const connectionRestricted = mysql.createConnection({
    host: 'localhost',
    user: 'albert',
    password: 'password1',
    database: 'reddit2restricted',
    insecureAuth: true
})
 */
// let importfiles = ['RC_2007-10.redditjson', 'RC_2011-07.redditjson', 'RC_2012-12.redditjson'];
const importfiles = ['RC_2007-10.redditjson'];
const bigassArray = [];


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

const escapeQuotes = (string) => {
   return string.replace(/"/g, '\\"');
}

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
                    comment_id VARCHAR(10) PRIMARY KEY,
                    parent_id VARCHAR(15) NOT NULL,
                    body TEXT NOT NULL,
                    score INT NOT NULL,
                    created_time INT(11) NOT NULL,
                    author VARCHAR(100) NOT NULL,
                    post_id VARCHAR(15),
                    CONSTRAINT FOREIGN KEY(post_id) REFERENCES posts(id)
                )`);
      console.log(`done`);
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
                    comment_id VARCHAR(10),
                    parent_id VARCHAR(15),
                    body TEXT,
                    score INT,
                    created_time INT(11),
                    author VARCHAR(100),
                    post_id VARCHAR(15)
                )`);
    }

    rl.on('line', (line) => {
      // time to add data to the dbs, we will start with the subreddit db
      const parsedLine = JSON.parse(line);
      const escapedBody = escapeQuotes(parsedLine.body);
      connection.query(`INSERT INTO subreddits (id, name) 
      VALUES ("${parsedLine.subreddit_id}","${parsedLine.subreddit}")`);

      connection.query(`INSERT INTO posts (id, subr_id)
      VALUES ("${parsedLine.link_id}","${parsedLine.subreddit_id}")`);

      connection.query(`INSERT INTO comments (comment_id, parent_id, body, score
        ,created_time, author, post_id)
        VALUES ("${parsedLine.id}","${parsedLine.parent_id}","${escapedBody}"
          ,"${parsedLine.score}","${parsedLine.created_utc}","${parsedLine.author}"
          ,"${parsedLine.link_id}")`);
    });

    rl.on('close', () => {
      connection.end((err) => {
        console.error(err);
      });
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

