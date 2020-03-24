package model.dbElements;

import model.CountryCode;

public class Artist {
    private  int id;
    private String name;
    private CountryCode nationality;


    public  Artist (String inputName, CountryCode inputNationality){
        setName(inputName);
        setNationality(inputNationality);
    }

    public  void  setName (String setName){
        name = setName;
    }
    public  void  setNationality (CountryCode setNationality){
        nationality = setNationality;
    }
    public void setId (int setID){
        id = setID;
    }
    public int getId (){
        return  id;
    }
    public String getName (){
        return name;
    }
    public CountryCode getNationality (){
        return nationality;
    }
}
