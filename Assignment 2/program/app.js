const mysql = require('mysql');
const Lblr = require('line-by-line');

// let importfiles = ['RC_2007-10.redditjson',
// 'RC_2011-07.redditjson', 'RC_2012-12.redditjson'];
const importfile = 'RC_2007-10.redditjson';
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
    insecureAuth: true,
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
  const comments = [];
  const posts = new Set([]);
  const subreddits = new Set([]);
  let readLines = 0;
  const maxReadLines = 500000;

  lineReader.on('line', (line) => {
    if (readLines < maxReadLines) {
      const lineObject = JSON.parse(line);
      const currentComments = [lineObject.id, lineObject.parent_id, lineObject.body,
        lineObject.score,
        lineObject.created_utc, lineObject.author, lineObject.link_id];
      const currentPosts = [lineObject.link_id, lineObject.subreddit_id];
      const currentSubreddits = [lineObject.subreddit_id, lineObject.subreddit];

      comments.push(currentComments);
      posts.add(currentPosts);
      subreddits.add(currentSubreddits);
      readLines++;
    }
  });
};


const start = () => {
  connection = getConnection();
  insertTables(insertData);
};

start();
