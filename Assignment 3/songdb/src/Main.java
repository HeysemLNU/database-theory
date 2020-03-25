import controller.*;
import model.ConnectionParams;
import model.CountryCode;
import model.dbElements.Album;
import model.dbElements.Artist;
import model.dbElements.Song;

import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
        Controller con = new Controller();
        ConnectionParams cp = new ConnectionParams("desktop.noxel.tk",42069,"database", "animewaifu","songs");
        //Trial
        CountryCode cc = CountryCode.AE;
        Artist newArtist = new Artist("Major", cc);
        Album newAlbum = new Album("Cool Abum",2003,2,"New Paramaount");
        Song newSong = new Song(420,"WorkIT",2005,2,1,"This is my Song Hooollllaaaa");
        EditDB editDB = new EditDB();
        editDB.addNewArtist(newArtist,cp);
        editDB.addNewAlbum(newAlbum,cp);
        editDB.addNewSong(newSong,cp);
        //editDB.deleteSong(1,cp);
        //editDB.deleteAlbum(2,cp);
        editDB.deleteArtist(1,cp);
        //

        try {
            con.startView();
        } catch (Exception e){
            System.out.println("error " + e.getMessage());
        }


    }
}
