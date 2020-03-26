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
                    ev.clear();
                    break;
                }

                case DEFAULT: {
                    ev.error(EnglishView.Errors.DBERROR);
                    break;
                }
            }
        }

    }


    private void addArtist() {
        Artist artist = ev.addNewArtist();
        if (artist == null) {
            ev.abort();
            ev.clear();
        } else {
            try{
                databaseFunctions.addNewArtist(artist);
                ev.clear();
                ev.success();

            } catch (SQLException ex) {
                ev.error(EnglishView.Errors.DBERROR);
            }

            //call the database to add the new artist
        }

    }

    private void removeArtist() {

    }

    private void editArtist() {
    }

    private void addAlbum() {
        Album album = ev.addNewAlbum();
        if (album.getArtistID() == -1) {
            String artistName = ev.searchArtistByName();
            try {
                databaseFunctions.searchArtistsByName(artistName);
                //here I will continue by actually printing the result set in the view
            } catch (SQLException ex) {
                ev.error(EnglishView.Errors.DBERROR);
            }

        }
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


