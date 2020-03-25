package controller;

import model.*;
import model.dbElements.*;
import view.EnglishView;

import java.sql.*;

public class Controller {
    ConnectionParams params = null;

    EnglishView ev = new EnglishView();

    public Controller(ConnectionParams par) {
        this.params = par;
    }

    public void startView () {
        boolean keepRunning = true;
        ev.welcomeMessage();
        while(keepRunning) {
            EnglishView.SelectedOption so = ev.mainMenu();
            switch (so) {
                case ADDARTIST: {
                    addArtist();
                    break;
                }
                case REMOVEARTIST: {
                    removeArtist();
                    break;
                }
                case EDITARTIST: {
                    editArtist();
                    break;
                }
                case ADDALBUM: {
                    addAlbum();
                    break;
                }
                case REMOVEALBUM: {
                    removeAlbum();
                    break;
                }
                case EDITALBUM: {
                    editAlbum();
                    break;
                }
                case ADDSONG: {
                    addSong();
                    break;
                }
                case REMOVESONG: {
                    removeSong();
                    break;
                }
                case EDITSONG: {
                    editSong();
                    break;
                }
                case EXIT: {
                    keepRunning = false;
                    break;
                }

                case DEFAULT: {
                    ev.invalidOption();
                    break;
                }
            }
        }

    }



    private void addArtist() {
        Artist a = ev.addNewArtist();
        if(a == null) {
            ev.abort();
        } else {
            //call the database to add the new artist
        }

    }

    private void removeArtist() {

    }

    private void editArtist() {}

    private void addAlbum() {
        Album al = ev.addNewAlbum();
    }

    private void removeAlbum() {}

    private void editAlbum() {}

    private void addSong() {}
    private void removeSong() {}
    private void editSong() {}





    public void initDB() throws SQLException {
        Connection con = DriverManager.getConnection(
                params.getNoCreds(), params.getUsername(), params.getPassword());

        Statement st = con.createStatement();

        st.executeUpdate("DROP TABLE IF EXISTS Songs,Artists,Albums");

        st.executeUpdate("CREATE TABLE IF NOT EXISTS Artists " +
                "(ArtistID int NOT NULL AUTO_INCREMENT," +
                "Nationality varchar(50)," +
                "Name varchar(50)," +
                "PRIMARY KEY (ArtistID))");

        st.executeUpdate("CREATE TABLE IF NOT EXISTS Albums " +
                "(AlbumID int NOT NULL AUTO_INCREMENT," +
                "Artist int," +
                "Name varchar(100)," +
                "Year int," +
                "RecordLabel varchar(100)," +
                "FOREIGN KEY(Artist) REFERENCES Artists(ArtistID)," +
                "PRIMARY KEY (AlbumID))");

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
