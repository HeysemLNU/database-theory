package controller;

import model.*;

import java.sql.*;

public class Controller {

    public Controller() {

    }

    public void initDB(ConnectionParams params) throws SQLException {
        Connection con = DriverManager.getConnection(
                params.getNoCreds(), params.getUsername(), params.getPassword());

        Statement st = con.createStatement();

        st.executeUpdate("DROP TABLE IF EXISTS Songs,Artists,Albums");

        st.executeUpdate("CREATE TABLE IF NOT EXISTS Artists " +
                "(ArtistID int NOT NULL AUTO_INCREMENT," +
                "Nationality varchar(50)," +
                "Name varchar(50)," +
                "PRIMARY KEY (ArtistID))");
        System.out.println("this is here now");
        //finish the ttable creation entry
        st.executeUpdate("CREATE TABLE IF NOT EXISTS Albums " +
                "(AlbumID int NOT NULL AUTO_INCREMENT," +
                "Artist int," +
                "Name varchar(100)," +
                "Year int," +
                "RecordLabel varchar(100)," +
                "FOREIGN KEY(Artist) REFERENCES Artists(ArtistID)," +
                "PRIMARY KEY (AlbumID))");
        System.out.println("this is here now again");
        st.executeUpdate("CREATE TABLE IF NOT EXISTS Songs " +
                "(SongID int NOT NULL AUTO_INCREMENT," +
                "Length int," +
                "Lyrics text," +
                "Year int," +
                "Name varchar (200)," +
                "Artist int," +
                "Album int," +
                "PRIMARY KEY (SongID)," +
                "FOREIGN KEY (Artist) REFERENCES Artists(ArtistID)," +
                "FOREIGN KEY (Album) REFERENCES Albums(AlbumID))");
        con.close();


    }


}
