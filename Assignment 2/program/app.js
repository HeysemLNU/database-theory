const mysql = require('mysql');
const fs = require('fs');
const readline = require('readline');
const stream = require('stream');

const restrictedMode = true;

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
//let importfiles = ['RC_2007-10.redditjson', 'RC_2011-07.redditjson', 'RC_2012-12.redditjson'];
let importfiles = ['RC_2011-07.redditjson'];
let bigassArray = [];


const getConnection = () => {
    let options = {
        host: 'localhost',
        user: 'albert',
        password: 'password1',
        insecureAuth: true
    }
    
    if(restrictedMode) {
        options.database = 'reddit2restricted';
    }
    return mysql.createConnection(options) 
}


const dataProcess = (importfile) => {

    
    let instream = fs.createReadStream(importfile);
    let rl = readline.createInterface(instream);

    connection = getConnection();

        connection.connect( () => {

            if(restrictedMode) {
                //it is important that the queries are done in this order
                //in constraint mode because of the foreign key usage.
                //if the table with the key we want to use as a foreign key doesnt exist
                //then when assigning a foreign key in another table it wont work
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
                console.log(`done`)
            } else {

            }

            rl.on('line', (line) => {
                //create tables first if they dont exist
                
                
            })
        })
        rl.on('close', () => {
            console.log(bigassArray.length);
        });
    }

    

    





const init = () => {
    /* if (process.argv.length < 6) {
            console.error('There are not enough arguments!\nargument order: <host> <user> <password> <database>')
        } else {
            host = process.argv[2];
            user = process.argv[3];
            password = process.argv[4];
            database = process.argv[5];
            
            
            //launch(host)
        } */
    launch()

}

const launch = () => {
    //opening the connection of the databse
    if(restrictedMode) {
        
        for(let counter = 0; counter < importfiles.length; counter++) {
            dataProcess(importfiles[counter]);
        }
        
            
        
    } else {
        connection.connect(() => {
            console.log('connection connected')
            for (let counter = 0; counter < importfiles.length; counter++) {
                dataProcess(importfiles[counter]);
            }
        });
    
    }



   

    /*  for(let counter = 0; counter < importfiles.length ; counter++) {
         dataProcess(importfiles[counter])
     } */
}
/* this.connection = mysql.createConnection({
    host: 
}) */
init()

