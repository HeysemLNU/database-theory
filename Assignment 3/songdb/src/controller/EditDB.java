package controller;

import model.ConnectionParams;
import model.dbElements.Album;
import model.dbElements.Artist;
import model.dbElements.Song;

import java.sql.*;

public class EditDB {
   // ConnectionParams params = null;
    public EditDB (){}

    public void  addNewArtist (Artist newArtist, ConnectionParams params) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement addArtist = con.createStatement();
        addArtist.executeUpdate("INSERT INTO Artists (Nationality, Name) VALUES ('"+newArtist.getNationality()+"', '"+newArtist.getName()+"')");
        con.close();
    }
    public void addNewSong (Song newSong, ConnectionParams params) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement addSong = con.createStatement();
        addSong.executeUpdate("INSERT INTO Songs (Length, Lyrics, Year, Name, Artist, Album) VALUES ('"+newSong.getLength()+"',  '"+newSong.getLyricks()+"','"+newSong.getYear()+"','"+newSong.getName()+"','"+newSong.getArtistID()+"','"+newSong.getAlbumID()+"')");
        con.close();
    }
    public void addNewAlbum (Album newAlbum, ConnectionParams params) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement addAlbum = con.createStatement();
        addAlbum.executeUpdate("INSERT  INTO Albums (Artist, Name, Year, RecordLabel) VALUES ('"+newAlbum.getArtistID()+"','"+newAlbum.getName()+"','"+newAlbum.getYear()+"','"+newAlbum.getRecordLabel()+"')");
        con.close();
    }
    public void deleteArtist (int artistID, ConnectionParams params) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement delete = con.createStatement();
        delete.executeUpdate("DELETE FROM Artists WHERE ArtistID = '"+artistID+"'");
        con.close();
    }
    public void deleteSong (int songID, ConnectionParams params) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement delete = con.createStatement();
        delete.executeUpdate("DELETE FROM Songs WHERE SongID = '"+songID+"'");
        con.close();
    }
    public void deleteAlbum (int albumID, ConnectionParams params) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement delete = con.createStatement();
        delete.executeUpdate("DELETE FROM Albums WHERE AlbumID = '"+albumID+"'");
        con.close();
    }
}
