package model.Variables;


public class Song {
    private int length;
    private String name;
    private String lyricks; // discuss this
    private int year;
    private  int artistID;
    private int albumID;

    public Song (int inputLength, String inputName,int inputYear, int inputArtistID,int inputAlbumID ){
        setLength(inputLength);
        setName(inputName);
        setYear(inputYear);
        setArtistID(inputArtistID);
        setAlbumID(inputAlbumID);
    }

    public void  setLength (int setLeangth){
        length =setLeangth;
    }
    public void  setName (String setName){
        name =setName;
    }
    public void  setLyricks (String setLyricks){
        lyricks =setLyricks;
    }
    public void  setYear (int setYear){
        year =setYear;
    }
    public void  setArtistID (int setArtistID){
        artistID =setArtistID;
    }
    public void  setAlbumID (int setAlbumID){
        albumID =setAlbumID;
    }
    public int getLength(){return length;}
    public String getName(){return name;}
    public String getLyricks (){return lyricks;}
    public int getYear (){return year;}
    public int getArtistID(){return artistID;}
    public int getAlbumID () {return  albumID;}
}
