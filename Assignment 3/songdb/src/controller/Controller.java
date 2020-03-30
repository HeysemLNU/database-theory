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
                case COUNTSONGSARTIST: {
                    showSongsByArtist();
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

                case ADDSONG: {
                    addSong();
                    break;
                }
                case REMOVESONG: {
                    removeSong();
                    break;
                }
                case SEARCHSONGNAME: {
                    searchSongByName();
                    break;
                }
                case SEARCHSONGLYRICS: {
                    searchSongByLyrics();
                    break;
                }
                case SEARCHARTISTBYNAME: {
                    searchArtistByName();
                    break;
                }
                case SEARCHALBUMBYNAME: {
                    searchAlbumByName();
                    break;
                }
                case INITDB: {
                    initialiseDB();
                    break;
                }
                case EXIT: {
                    keepRunning = false;
                    ev.clear();
                    break;
                }

                case DEFAULT: {
                    ev.error(EnglishView.Errors.INVALIDOPTION);
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
            try {

                databaseFunctions.addNewArtist(artist);
                ev.clear();
                ev.success();

            } catch (SQLException ex) {
                ev.error(EnglishView.Errors.DBERROR);
            }

            //call the database to add the new artist
        }

    }


    private void addAlbum() {
        Album album = ev.addNewAlbum();

        try {
            if (album == null) {
                ev.abort();
                return;
            } else if (album.getArtistID() == -1) {
                searchArtistByName();
                //after shown, we request for the input of the actual artist
                String input = ev.requestInput(EnglishView.InputRequests.ASKID);
                int artistID = Integer.parseInt(input);
                if (artistID < 1) {
                    throw new NumberFormatException();
                } else {
                    album.setArtistID(artistID);
                    if (ev.confirmAlbum(album, "addition")) {
                        databaseFunctions.addNewAlbum(album);
                        databaseFunctions.closeConnection();
                        ev.clear();
                        ev.success();
                    } else {
                        ev.abort();
                    }
                }
            } else {
                if (ev.confirmAlbum(album, "addition")) {
                    databaseFunctions.addNewAlbum(album);
                    databaseFunctions.closeConnection();

                    //wont trigger if catch
                    ev.success();
                }

            }
        } catch (NumberFormatException nf) {
            ev.error(EnglishView.Errors.INVALIDID);
            ev.abort();
        } catch (SQLException ex) {
            ev.error(EnglishView.Errors.DBERROR);
            ev.abort();
        }


    }

    private void showSongsByArtist() {
        try {
            int inputID = ev.countSongArtist();
            if (inputID == 0) {
                //if it returns 0
                ev.abort();
                return;
            }
            if (inputID == -1) {
                searchArtistByName();
                String input = ev.requestInput(EnglishView.InputRequests.ASKID);
                inputID = Integer.parseInt(input);
                if (inputID < 1) {
                    throw new NumberFormatException();
                }
            }
            ResultSet rs = databaseFunctions.artistSongCount(inputID);
            ev.printResultSet(rs);
        } catch (NumberFormatException fn) {
            ev.error(EnglishView.Errors.INVALIDID);
            ev.abort();
        } catch (SQLException fn) {
            ev.error(EnglishView.Errors.DBERROR);
            ev.abort();
        }

    }


    private void addSong() {
        Song song = ev.addNewSong();
        try {
            //need to use ifs rather than if elses for all the statements to execute!
            if (song == null) {
                ev.abort();
                return;
            }
            if (song.getAlbumID() == -1) {
                searchAlbumByName();
                String albumString = ev.requestInput(EnglishView.InputRequests.ASKID);
                int albumID = Integer.parseInt(albumString);
                if (albumID < 1) {
                    ev.error(EnglishView.Errors.INVALIDID);
                    ev.abort();
                }
                song.setAlbumID(albumID);
            }
            //this if then should be working as long as they have set the ID properly
            if (song.getAlbumID() > 0) {
                if (ev.confirmSong(song, "addition")) {
                    databaseFunctions.addNewSong(song);
                    databaseFunctions.closeConnection();
                    ev.clear();
                    ev.success();
                } else {
                    ev.abort();
                }

            }
        } catch (NumberFormatException nf) {
            ev.error(EnglishView.Errors.INVALIDID);
            ev.abort();
        } catch (SQLException ex) {
            ev.error(EnglishView.Errors.DBERROR);
            ev.abort();
        }
    }

    private void removeArtist() {
        searchArtistByName();
        String artistString = ev.requestInput(EnglishView.InputRequests.ASKID);
        try {
            int artistID = Integer.parseInt(artistString);
            if (artistID < 1) {
                throw new NumberFormatException();
            }
            Artist art = databaseFunctions.getArtistDB(artistID);
            if (ev.confirmArtist(art, "removal")) {
                databaseFunctions.deleteArtist(artistID);
                databaseFunctions.closeConnection();
                ev.success();
            } else {
                ev.abort();
            }
        } catch (NumberFormatException nf) {
            ev.error(EnglishView.Errors.INVALIDID);
            ev.abort();
        } catch (SQLException ex) {
            ev.error(EnglishView.Errors.DBERROR);
            ev.abort();
        }
    }

    private void removeSong() {
        searchSongByName();
        String albumString = ev.requestInput(EnglishView.InputRequests.ASKID);
        try {
            int songID = Integer.parseInt(albumString);
            if (songID < 1) {
                throw new NumberFormatException();
            }
            Song s = databaseFunctions.getSongDB(songID);
            if (ev.confirmSong(s, "removal")) {
                databaseFunctions.deleteSong(songID);
                databaseFunctions.closeConnection();
                ev.success();
            } else {
                ev.abort();
            }

        } catch (NumberFormatException nf) {
            ev.error(EnglishView.Errors.INVALIDID);
            ev.abort();
        } catch (SQLException ex) {
            ev.error(EnglishView.Errors.DBERROR);
            ev.abort();
        }
    }

    private void removeAlbum() {
        searchAlbumByName();
        String albumString = ev.requestInput(EnglishView.InputRequests.ASKID);
        try {
            int albumID = Integer.parseInt(albumString);
            if (albumID < 1) {
                throw new NumberFormatException();
            }
            Album a = databaseFunctions.getAlbumDB(albumID);
            if (ev.confirmAlbum(a, "removal")) {
                databaseFunctions.deleteAlbum(albumID);
                databaseFunctions.closeConnection();
                ev.success();
            } else {
                ev.abort();
            }

        } catch (NumberFormatException nf) {
            ev.error(EnglishView.Errors.INVALIDID);
            ev.abort();
        } catch (SQLException ex) {
            ev.error(EnglishView.Errors.DBERROR);
            ev.abort();
        }
    }

    private void searchArtistByName() {
        String artistName = ev.requestXname("artist");
        try {
            ResultSet searchResult = databaseFunctions.searchArtistsByName(artistName);
            //here I will continue by actually printing the result set in the view
            ev.printResultSet(searchResult);
            databaseFunctions.closeConnection();
        } catch (SQLException ex) {
            ev.error(EnglishView.Errors.DBERROR);
        }
    }

    private void searchAlbumByName() {
        String albumName = ev.requestXname("album");
        try {
            ResultSet searchResult = databaseFunctions.searchAlbumsByName(albumName);
            ev.printResultSet(searchResult);
            databaseFunctions.closeConnection();
        } catch (SQLException ex) {
            ev.error(EnglishView.Errors.DBERROR);
        }
    }

    private void searchSongByName() {
        String songName = ev.requestXname("song");
        try {
            ResultSet searchResult = databaseFunctions.searchSongsByName(songName);
            ev.printResultSet(searchResult);
            databaseFunctions.closeConnection();

        } catch (SQLException ex) {
            ev.error(EnglishView.Errors.DBERROR);
        }
    }

    private void searchSongByLyrics() {
        String songLyrics = ev.requestXname("lyrics");
        try {
            ResultSet lyricsSearchResult = databaseFunctions.searchSongByLyrics(songLyrics);
            ev.printResultSet(lyricsSearchResult);
            databaseFunctions.closeConnection();

        } catch (SQLException ex) {
            ev.error(EnglishView.Errors.DBERROR);
        }
    }

    private void initialiseDB() {
        try {
            databaseFunctions.initDB();
            databaseFunctions.closeConnection();
        } catch (SQLException ex) {
            ev.error(EnglishView.Errors.DBERROR);
        }

    }

}


