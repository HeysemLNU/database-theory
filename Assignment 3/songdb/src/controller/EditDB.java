package controller;

import model.ConnectionParams;
import model.dbElements.Album;
import model.dbElements.Artist;
import model.dbElements.Song;

import java.sql.*;

public class EditDB {
    ConnectionParams params = null;
    public EditDB (){}

    public void  addNewArtist (Artist newArtist) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement addArtist = con.createStatement();
        addArtist.executeUpdate("INSERT INTO Artists (Nationality, Name) VALUES ('"+newArtist.getNationality()+"', '"+newArtist.getName()+"')");
        con.close();
    }
    public void addNewSong (Song newSong) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement addSong = con.createStatement();
        addSong.executeUpdate("INSERT INTO Songs (Length, Lyrics, Year, Name, Artist, Album) VALUES ('"+newSong.getLength()+"',  '"+newSong.getLyricks()+"','"+newSong.getYear()+"','"+newSong.getName()+"','"+newSong.getArtistID()+"','"+newSong.getAlbumID()+"')");
    }
    public void addNewAlbum (Album newAlbum) throws SQLException {
        Connection con = DriverManager.getConnection(params.getNoCreds(), params.getUsername(), params.getPassword());
        Statement addAlbum = con.createStatement();
        addAlbum.executeUpdate("INSERT  INTO Albums (Artist, Name, Year, RecordLabel) VALUES ('"+newAlbum.getArtistID()+"','"+newAlbum.getName()+"','"+newAlbum.getYear()+"','"+newAlbum.getRecordLabel()+"')");
    }
}
