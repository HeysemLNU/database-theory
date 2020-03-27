package model.dbElements;


public class Song {
    private int songID;
    private int length;
    private String name;
    private String lyrics; // discuss this
    private int year;

    private int albumID;

    public Song (int inputLength, String inputName,int inputYear,int inputAlbumID, String inputLyrics ){
        setLyrics(inputLyrics);
        setLength(inputLength);
        setName(inputName);
        setYear(inputYear);

        setAlbumID(inputAlbumID);
    }

    public void  setLength (int setLength){
        length = setLength;
    }
    public void  setName (String setName){
        name =setName;
    }
    public void setLyrics(String setLyrics){
        lyrics =setLyrics;
    }
    public void  setYear (int setYear){
        year =setYear;
    }

    public void  setAlbumID (int setAlbumID){
        albumID =setAlbumID;
    }
    public void  setSongID (int setSongID) {songID =setSongID;}
    public int getLength(){return length;}
    public String getName(){return name;}
    public String getLyrics(){return lyrics;}
    public int getYear (){return year;}
    public int getAlbumID () {return  albumID;}
    public int getSongID (){return songID;}
}
