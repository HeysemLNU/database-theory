const mysql = require('mysql');
const fs = require('fs');
const readline = require('readline');
const stream = require('stream');

    let host;
    let user;
    let password;
    let database;
    let port = 3306;
    //let importfiles = ['RC_2007-10.redditjson', 'RC_2011-07.redditjson', 'RC_2012-12.redditjson'];
    let importfiles = ['RC_2011-07.redditjson'];
    let bigassArray = [];

    const standardiser = (importfile) => {

        let instream = fs.createReadStream(importfile);
        let rl = readline.createInterface(instream);

        rl.on('line', (line) => {
            let tempobj = JSON.parse(line)
            if(!tempobj.name.startsWith('t1')) {
                console.log(tempobj.name)
            }
            
        })

        rl.on('close', ()=> {
            console.log(bigassArray.length);
        });
        /* fs.readFile(importfile, (error, buffer) => {
            if(error) {
                console.error(error)
            } else {
                console.log(buffer.toString())
            }
        }) */
    }



    const init = () => {
        if (process.argv.length < 6) {
            console.error('There are not enough arguments!\nargument order: <host> <user> <password> <database>')
        } else {
            host = process.argv[2];
            user = process.argv[3];
            password = process.argv[4];
            database = process.argv[5];
            
            for(let counter = 0; counter < importfiles.length ; counter++) {
                standardiser(importfiles[counter])
            }

            //launch(host)
        }
    }
    
    const launch = (host, user, password, database, port) => {
        
    }
    /* this.connection = mysql.createConnection({
        host: 
    }) */
    init()

