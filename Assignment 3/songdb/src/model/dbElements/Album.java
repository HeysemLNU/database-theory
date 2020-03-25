package model.dbElements;

public class Album {
    private int albumID;
    private int artistID;
    private String name;
    private  int year;
    private String recordLabel;

    public Album (String inputName,int inputYear, int inputArtistID,String inputRecordLabel){
        setName(inputName);
        setYear(inputYear);
        setArtistID(inputArtistID);
        setRecordLabel(inputRecordLabel);
    }

    public void  setName (String setName){
        name =setName;
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
    public void setRecordLabel(String setRecordLabel){
        recordLabel= setRecordLabel;
    }
    public String getName(){return name;}
    public int getYear (){return year;}
    public int getArtistID(){return artistID;}
    public int getAlbumID () {return  albumID;}
    public String getRecordLabel(){return recordLabel;}
}
