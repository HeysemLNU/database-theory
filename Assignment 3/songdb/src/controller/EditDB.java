package controller;

import model.ConnectionParams;
import model.CountryCode;
import model.dbElements.Album;
import model.dbElements.Artist;
import model.dbElements.Song;

import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class EditDB {
    ConnectionParams params;

    public EditDB(ConnectionParams paramsDB) {
        params = paramsDB;
    }

    public void addNewArtist(Artist newArtist) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement addArtist = con.createStatement();
        addArtist.executeUpdate("INSERT INTO Artists (Nationality, Name) VALUES ('" + newArtist.getNationality() + "', '" + newArtist.getName() + "')");
        con.close();
    }

    public void addNewSong(Song newSong) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement addSong = con.createStatement();
        addSong.executeUpdate("INSERT INTO Songs (Length, Lyrics, Year, Name, Artist, Album) VALUES ('" + newSong.getLength() + "',  '" + newSong.getLyricks() + "','" + newSong.getYear() + "','" + newSong.getName() + "','" + newSong.getArtistID() + "','" + newSong.getAlbumID() + "')");
        con.close();
    }

    public void addNewAlbum(Album newAlbum) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement addAlbum = con.createStatement();
        addAlbum.executeUpdate("INSERT  INTO Albums (Artist, Name, Year, RecordLabel) VALUES ('" + newAlbum.getArtistID() + "','" + newAlbum.getName() + "','" + newAlbum.getYear() + "','" + newAlbum.getRecordLabel() + "')");
        con.close();
    }

    public void deleteArtist(int artistID) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement delete = con.createStatement();
        delete.executeUpdate("DELETE FROM Artists WHERE ArtistID = '" + artistID + "'");
        con.close();
    }

    public void deleteSong(int songID) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement delete = con.createStatement();
        delete.executeUpdate("DELETE FROM Songs WHERE SongID = '" + songID + "'");
        con.close();
    }

    public void deleteAlbum(int albumID) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement delete = con.createStatement();
        delete.executeUpdate("DELETE FROM Albums WHERE AlbumID = '" + albumID + "'");
        con.close();
    }

    public void editArtist(Artist editArtist) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement edit = con.createStatement();
        edit.executeUpdate("UPDATE Artists SET Nationality = '" + editArtist.getNationality() + "', Name = '" + editArtist.getName() + "' WHERE ArtistID = '" + editArtist.getId() + "'");
        con.close();
    }

    public void editAlbum(Album editAlbum) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement edit = con.createStatement();
        edit.executeUpdate("UPDATE Albums SET Artist ='" + editAlbum.getArtistID() + "', Name = '" + editAlbum.getName() + "', Year = '" + editAlbum.getYear() + "', RecordLabel = '" + editAlbum.getRecordLabel() + "' WHERE AlbumID = '" + editAlbum.getAlbumID() + "'");
        con.close();
    }

    public void editSong(Song editSong) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement edit = con.createStatement();
        edit.executeUpdate("UPDATE Songs SET Length = '" + editSong.getLength() + "', Lyrics = '" + editSong.getLyricks() + "', Year = '" + editSong.getYear() + "', Name = '" + editSong.getName() + "', Artist = '" + editSong.getArtistID() + "', Album = '" + editSong.getAlbumID() + "' WHERE  SongID = '" + editSong.getSongID() + "'");
        con.close();
    }

    public Artist getArtistDB(int id) throws SQLException {
        String name = null;
        String countryCode = null;
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement getDb = con.createStatement();
        ResultSet resultSet = getDb.executeQuery("SELECT * FROM Artists WHERE ArtistID = '" + id + "'");
        while (resultSet.next()) {
            name = resultSet.getString("Name");
            countryCode = resultSet.getString("Nationality");
        }
        con.close();
        Artist returnArtist = new Artist(name, CountryCode.valueOf(countryCode));
        returnArtist.setId(id);
        return returnArtist;
    }

    public Album getAlbumDB(int id) throws SQLException {
        int artistID = 0;
        String name = null;
        int year = 0;
        String recordLabel = null;
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement getDb = con.createStatement();
        ResultSet resultSet = getDb.executeQuery("SELECT * FROM Albums WHERE AlbumID = '" + id + "'");
        while (resultSet.next()) {
            artistID = resultSet.getInt("Artist");
            name = resultSet.getString("Name");
            year = resultSet.getInt("Year");
            recordLabel = resultSet.getString("RecordLabel");
        }
        con.close();
        Album returnAlbum = new Album(name, year, artistID, recordLabel);
        returnAlbum.setAlbumID(id);
        return returnAlbum;
    }

    public Song getSongDB(int id) throws SQLException {
        int albumID = 0;
        int artistID = 0;
        String name = null;
        int year = 0;
        int length = 0;
        String lyrics = null;
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement getDb = con.createStatement();
        ResultSet resultSet = getDb.executeQuery("SELECT * FROM Songs WHERE SongID = '" + id + "'");
        while (resultSet.next()) {
            artistID = resultSet.getInt("Artist");
            name = resultSet.getString("Name");
            year = resultSet.getInt("Year");
            albumID = resultSet.getInt("Album");
            length = resultSet.getInt("Length");
            lyrics = resultSet.getString("Lyrics");
        }
        con.close();
        Song returnSong = new Song(length, name, year, artistID, albumID, lyrics);
        returnSong.setSongID(id);
        return returnSong;
    }

    public ArrayList<Song> getAllSongDB(String typeInfo, String info) throws SQLException {
        int albumID = 0;
        int artistID = 0;
        String name = null;
        int year = 0;
        int length = 0;
        String lyrics = null;
        ArrayList<Song> allSongs = new ArrayList<>();
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement getDb = con.createStatement();
        String sqlComand = "SELECT * FROM Songs WHERE " + typeInfo + " = " + info;
        ResultSet resultSet = getDb.executeQuery(sqlComand);
        while (resultSet.next()) {
            artistID = resultSet.getInt("Artist");
            name = resultSet.getString("Name");
            year = resultSet.getInt("Year");
            albumID = resultSet.getInt("Album");
            length = resultSet.getInt("Length");
            lyrics = resultSet.getString("Lyrics");
            Song returnSong = new Song(length, name, year, artistID, albumID, lyrics);
            returnSong.setSongID(resultSet.getInt("SongID"));
            allSongs.add(returnSong);
        }
        con.close();
        return allSongs;
    }

    public ArrayList<Album> getAllAlbumDB(String typeInfo, String info) throws SQLException {
        int artistID = 0;
        String name = null;
        int year = 0;
        String recordLabel = null;
        ArrayList<Album> allAlbums = new ArrayList<>();
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement getDb = con.createStatement();
        String sqlComand = "SELECT * FROM Albums WHERE " + typeInfo + " = " + info;
        ResultSet resultSet = getDb.executeQuery(sqlComand);
        while (resultSet.next()) {
            artistID = resultSet.getInt("Artist");
            name = resultSet.getString("Name");
            year = resultSet.getInt("Year");
            recordLabel = resultSet.getString("RecordLabel");
            Album returnAlbum = new Album(name, year, artistID, recordLabel);
            returnAlbum.setAlbumID(resultSet.getInt("AlbumID"));
            allAlbums.add(returnAlbum);
        }
        con.close();
        return allAlbums;
    }

    public ArrayList<Artist> getAllArtistDB(String typeInfo, String info) throws SQLException {
        String name = null;
        String countryCode = null;
        ArrayList<Artist> allArtists = new ArrayList<>();
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement getDb = con.createStatement();
        String sqlComand = "SELECT * FROM Artists WHERE " + typeInfo + " = " + info;
        ResultSet resultSet = getDb.executeQuery(sqlComand);
        while (resultSet.next()) {
            name = resultSet.getString("Name");
            countryCode = resultSet.getString("Nationality");
            Artist returnArtist = new Artist(name, CountryCode.valueOf(countryCode));
            returnArtist.setId(resultSet.getInt("ArtistID"));
            allArtists.add(returnArtist);
        }
        con.close();
        return allArtists;
    }

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