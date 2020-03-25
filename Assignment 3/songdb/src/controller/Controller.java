package controller;

import model.*;
import model.dbElements.*;
import view.EnglishView;
import view.ViewTemplate;

import java.sql.*;

public class Controller {
    ConnectionParams params;
    EditDB databaseFunctions;
    EnglishView ev = new EnglishView();

    public Controller(ConnectionParams par) {
        this.params = par;
        databaseFunctions = new EditDB(params);
    }

    public void startView() {
        boolean keepRunning = true;
        ev.welcomeMessage();
        while (keepRunning) {
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
        Artist artist = ev.addNewArtist();
        if (artist == null) {
            ev.abort();
        } else {
            try{
                databaseFunctions.addNewArtist(artist);
            } catch (SQLException ex) {

            }

            //call the database to add the new artist
        }

    }

    private void removeArtist() {

    }

    private void editArtist() {
    }

    private void addAlbum() {
        Album al = ev.addNewAlbum();
    }

    private void removeAlbum() {
    }

    private void editAlbum() {
    }

    private void addSong() {
    }

    private void removeSong() {
    }

    private void editSong() {
    }


}


