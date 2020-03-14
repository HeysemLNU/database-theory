import controller.*;
import model.ConnectionParams;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Controller con = new Controller();
        ConnectionParams cp = new ConnectionParams("desktop.noxel.tk",42069,"database", "animewaifu","songs");
        try {
            con.initDB(cp);
        } catch (SQLException e){
            System.out.println("error " + e.getMessage());
        }


    }
}
