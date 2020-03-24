import controller.*;
import model.ConnectionParams;



public class Main {

    public static void main(String[] args) {
	// write your code here
        Controller con = new Controller();
        ConnectionParams cp = new ConnectionParams("desktop.noxel.tk",42069,"database", "animewaifu","songs");
        try {
            con.startView();
        } catch (Exception e){
            System.out.println("error " + e.getMessage());
        }


    }
}