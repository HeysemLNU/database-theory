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

        st.executeUpdate("CREATE TABLE IF NOT EXISTS Artists " +
                "(ArtistID int NOT NULL AUTO_INCREMENT," +
                "Nationality varchar(50)," +
                "Name varchar(50)," +
                "PRIMARY KEY (ArtistID))");
        con.close();

        /*   ResultSet result = st.executeQuery("CREATE TABLE songs (" +
                    "SongID int NOT NULL AUTO_INCREMENT," +
                    "Length int," +
                    "Lyrics text," +
                    "Year int," +
                    "NAME varchar 200," +
                    "Artist int," +
                    "Album int," +
                    "PRIMARY KEY (SongsID)," +
                    "FOREIGN KEY (Artist) REFERENCES Artists(ArtistID)" +
                    "FOREIGN KEY (Album) REFERENCES Albums(AlbumID))");*/
    }


}
