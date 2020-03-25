import controller.*;
import model.ConnectionParams;



public class Main {

    public static void main(String[] args) {
        //the args that are going to be passed is basically just the host and the port, the rest will be hardcoded for the database dump
	// write your code here
        if(args.length != 5) {
            System.out.println("All the arguments are compulsory. Usage is as follows\n" +
                    "<host> <port> <username> <password> <databasename>");
            System.exit(1);
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);
        String username = args[2];
        String password =  args[3];
        String databasename = args[4];


        ConnectionParams cp = new ConnectionParams(host,port,username,password,
                databasename);

        Controller con = new Controller(cp);

        con.startView();


    }
}
