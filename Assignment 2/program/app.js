const mysql = require('mysql');
const Lblr = require('line-by-line');


// let importfiles = ['RC_2007-10.redditjson',
// 'RC_2011-07.redditjson', 'RC_2012-12.redditjson'];
const importfile = 'RC_2011-07.redditjson';
let connection = '';
const constrained = true;


const constrainedTablesQueries = [`CREATE TABLE IF NOT EXISTS subreddits (
  id VARCHAR(15) PRIMARY KEY,
  name VARCHAR(255) NOT NULL
)`, `CREATE TABLE IF NOT EXISTS posts (
  id VARCHAR(15) PRIMARY KEY,
  subr_id VARCHAR(15), 
  CONSTRAINT FOREIGN KEY(subr_id) REFERENCES subreddits(id)
)`, `CREATE TABLE IF NOT EXISTS comments (
  id VARCHAR(15) PRIMARY KEY,
  parent_id VARCHAR(15) NOT NULL,
  body TEXT NOT NULL,
  score INT NOT NULL,
  created_time INT(11) NOT NULL,
  author VARCHAR(100) NOT NULL,
  post_id VARCHAR(15),
  CONSTRAINT FOREIGN KEY(post_id) REFERENCES posts(id)
)`];

const unconstrainedTablesQueries = [`CREATE TABLE IF NOT EXISTS subreddits (
  id VARCHAR(15),
  name VARCHAR(255)
)`, `CREATE TABLE IF NOT EXISTS posts (
  id VARCHAR(15),
  subr_id VARCHAR(15) 
)`, `CREATE TABLE IF NOT EXISTS comments (
  id VARCHAR(15),
  parent_id VARCHAR(15),
  body TEXT,
  score INT,
  created_time INT(11),
  author VARCHAR(100),
  post_id VARCHAR(15)
)`];


const getConnection = () => {
  const options = {
    host: 'localhost',
    user: 'albert',
    password: 'password1',
    insecureAuth: false,
  };

  if (constrained) {
    options.database = 'reddit2restricted';
  } else {
    options.database = 'reddit1';
  }
  return mysql.createConnection(options);
};

const insertTables = (callback) => {
  if (constrained) {
    connection.query(constrainedTablesQueries[0], () => {
      connection.query(constrainedTablesQueries[1], () => {
        connection.query(constrainedTablesQueries[2], () => {
          callback();
        });
      });
    });
  } else {
    connection.query(unconstrainedTablesQueries[0], () => {
      connection.query(unconstrainedTablesQueries[1], () => {
        connection.query(unconstrainedTablesQueries[2], () => {
          callback();
        });
      });
    });
  }
};

const insertData = () => {
  const lineReader = new Lblr(importfile);
  lineReader.setMaxListeners(0);
  let comments = [];
  let posts = [];
  let subreddits = [];
  const postsSet = new Set();
  const subredditsSet = new Set();

  let readLines = 0;
  const maxReadLines = 1000000;

  const doInsert = (callback) => {
    lineReader.pause();
    // inputing the information we have into the database with bulk
    const sql1 = `INSERT INTO subreddits(id, name) VALUES ?`;
    const sql2 = `INSERT INTO posts (id, subr_id) VALUES ?`;
    const sql3 = `INSERT INTO comments (id, parent_id, body, score
      ,created_time, author, post_id)
      VALUES ?`;


    connection.query(sql1, [subreddits], (err) => {
      if (err) {
        console.log('subreddits: ' + err.sqlMessage);
      }
      console.log('ADDED BULK ENTRY TO SUBREDDITS TABLE');
      connection.query(sql2, [posts], (err) => {
        if (err) {
          console.log('posts: ' +err.sqlMessage);
        }
        console.log('ADDED BULK ENTRY TO POSTS TABLE');
        connection.query(sql3, [comments], (err) => {
          if (err) {
            console.log('comments: ' +err.sqlMessage);
          }
          console.log('ADDED BULK ENTRY TO COMMENTS TABLE');
          console.log(comments.length);
          console.log(subreddits.length);
          console.log(posts.length);
          readLines = 0;
          comments = [];
          posts = [];
          subreddits = [];
          callback();
        });
      });
    });
  };
  const beforeMS = new Date().getTime();
  lineReader.on('line', (line) => {
    const lineObject = JSON.parse(line);
    const currentComments = [lineObject.id, lineObject.parent_id, lineObject.body,
      lineObject.score,
      lineObject.created_utc, lineObject.author, lineObject.link_id];
    const currentPosts = [lineObject.link_id, lineObject.subreddit_id];
    const currentSubreddits = [lineObject.subreddit_id, lineObject.subreddit];

    comments.push(currentComments);

    if (!postsSet.has(lineObject.link_id)) {
      postsSet.add(lineObject.link_id);
      posts.push(currentPosts);
    }

    if (!subredditsSet.has(lineObject.subreddit_id)) {
      subredditsSet.add(lineObject.subreddit_id);
      subreddits.push(currentSubreddits);
    }
    /* posts.add(currentPosts, lineObject.link_id);
      // subreddits.add(currentSubreddits);
      subreddits.add(lineObject.subreddit_id, lineObject.subreddit); */
    readLines++;
    if (readLines >= maxReadLines) {
      doInsert(() => {
        lineReader.resume();
      });
    }
  });
  lineReader.on('end', () => {
    doInsert(() => {
      connection.end();
      const totalTime = new Date().getTime() - beforeMS;
      console.log(`THE TOTAL TIME IT TOOK THIS WAS ${totalTime}`);
    });
  });
};


const start = () => {
  connection = getConnection();

  insertTables(insertData);
};

start();
