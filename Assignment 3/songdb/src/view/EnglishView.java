package view;


import model.CountryCode;
import model.dbElements.Album;
import model.dbElements.Artist;
import model.dbElements.Song;

import java.sql.ResultSet;
import java.util.Scanner;

public class EnglishView implements ViewTemplate {


    //Add artist
    //add song
    //add album
    //edit artist
    //edit song
    //edit album
    //remove artist
    //remove song
    //remove album
    //show table artist
    //show table song
    //show table album
    //search by song name
    //search by artist name
    //search by album by year
    //search song by year
    //order songs by length min-max and max-min
    //order songs by year min-max and max-min
    //show song table join artist table
    //show artist table join with album table
    //search song by name with join artist table and album table

    Scanner sc;

    public EnglishView() {
        sc = new Scanner(System.in);
    }

    @Override
    public CountryCode getCC() {
        EnglishCC countryCodeFunction = new EnglishCC();

        System.out.println("Introduce the country name or the country code if you know it");
        System.out.println("Type UNKNOWN if you don't know the country of origin.");
        String countryName = sc.nextLine();


        //if this returns null then the country code was not found
        CountryCode cc = countryCodeFunction.getEnglishCC(countryName);
        if (cc == null) {
            System.out.println("The CC does not exist");
            return null;
        } else {
            System.out.println("The country is: " + countryName + " with country code " + cc.toString());
            return cc;
        }

    }

    @Override
    public SelectedOption mainMenu() {
        System.out.println("Select an option to continue");
        printOptions();
        prompt();
        String input = sc.nextLine();

        try {
            int selection = Integer.parseInt(input);
            switch (selection) {
                case 1: {
                    return SelectedOption.ADDARTIST;
                }
                case 2: {
                    return SelectedOption.REMOVEARTIST;
                }
                case 3: {
                    return SelectedOption.ADDALBUM;
                }
                case 4: {
                    return SelectedOption.REMOVEALBUM;
                }
                case 5: {
                    return SelectedOption.ADDSONG;
                }
                case 6: {
                    return SelectedOption.REMOVESONG;
                }
                case 7: {
                    return SelectedOption.SEARCHSONGNAME;
                }
                case 8: {
                    return SelectedOption.SEARCHSONGLYRICS;
                }
                case 9: {
                    return SelectedOption.SEARCHALBUMBYNAME;
                }
                case 10: {
                    return SelectedOption.SEARCHARTISTBYNAME;
                }
                case 11: {
                    return SelectedOption.COUNTSONGSARTIST;
                }
                case 1000: {
                    return SelectedOption.INITDB;
                }
                case 0: {
                    return SelectedOption.EXIT;
                }
                default: {
                    return SelectedOption.DEFAULT;
                }

            }

        } catch (NumberFormatException n) {
            return SelectedOption.DEFAULT;
        }


    }


    private void printOptions() {
        System.out.println("1: Add Artist");
        System.out.println("2: Remove Artist");
        System.out.println("3: Add Album");
        System.out.println("4: Remove Album");
        System.out.println("5: Add Song");
        System.out.println("6: Remove Song");
        System.out.println("7: Search Song by name");
        System.out.println("8: Search Song by Lyric Name");
        System.out.println("9: Search album by Name");
        System.out.println("10: Search Artist By Name");
        System.out.println("11: Show the number of songs of an artist");
        System.out.println("0: exit");
    }


    public int countSongArtist() {
        System.out.println("Introduce the ID of the artist you want to see the number of songs they have");
        System.out.println("If you don't know the ID of the artist press enter with no input");
        prompt();
        String input = sc.nextLine();
        try {
            if(input.equals("")) {
                return -1;
            }
            int inputID = Integer.parseInt(input);
            if (inputID < 1) {
                throw new NumberFormatException();
            } else {
                return inputID;
            }
        } catch(NumberFormatException nf) {
             error(Errors.INVALIDID);
             return 0;
        }
    }

    public void welcomeMessage() {
        System.out.println("Welcome to the music database!");
    }

    public Artist addNewArtist() {
        System.out.println("Adding artist to the database");
        System.out.println("Introduce the name of the artist");
        prompt();
        String artistName = sc.nextLine();
        CountryCode cc = getCC();
        if (artistName == null) {
            error(Errors.INVALIDARTIST);
        } else if (cc == null) {
            error(Errors.INVALIDCC);
        } else {
            Artist a = new Artist(artistName, cc);
            if (confirmArtist(a,"addition")) {
                return a;
            }
        }
        return null;
    }

    public Song addNewSong() {
        System.out.println("Adding song to the database");
        //Song s = new Song()
        System.out.println("Introduce the name of the song");
        prompt();
        String songName = sc.nextLine();
        System.out.println("Introduce the length of the song in seconds");
        prompt();
        String inputLength = sc.nextLine();
        int length = -1;
        try {
            length = Integer.parseInt(inputLength);
            if(length < 0) {
                throw new NumberFormatException();
            }
        } catch(NumberFormatException nf) {
            error(Errors.INVALIDLENGTH);
            return null;
        }
        System.out.println("Introduce the year of release of the song");
        prompt();
        String inputYear = sc.nextLine();
        int year = -1;
        try {
            year = Integer.parseInt(inputYear);
            if (year < 0 || year > 10000) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException nf) {
            error(Errors.INVALIDYEAR);
            return null;
        }
        System.out.println("Introduce the full lyrics of the song");
        prompt();
        String inputLyrics = formatTextSql(sc.nextLine());

        Song addedsong = new Song(length,songName,year,0,inputLyrics);
        System.out.println("Introduce the ID of the album this song belongs to");
        System.out.println("Don't know the ID? Press enter with no input to trigger a search based on the name!");
        System.out.println("The searches will be performed in order!");
        prompt();
        String inputAlbumID = sc.nextLine();
        int albumID = -1;
        if(inputAlbumID.equals("")) {
            addedsong.setAlbumID(albumID);
        } else {
            try {
                albumID = Integer.parseInt(inputAlbumID);
                if(albumID < 1) {
                    throw new NumberFormatException();
                }
                addedsong.setAlbumID(albumID);
            } catch (NumberFormatException nf) {
                error(Errors.INVALIDID);
                return null;
            }
        }

        if(addedsong.getAlbumID() == 0){
            //something went wrong, therefore return null
            return null;
        } else if(addedsong.getAlbumID() == -1) {
            return addedsong;
        } else {
            return addedsong;
        }
    }

    public Album addNewAlbum() {
        //notes about these, if they return null, then it means something has gone wrong.
        //if it retunrs -1 on the id it means it should prompt the user to search for the artist
        //via the name
        //if it returns anything else, it will assume that is the right ID and add it to the db

        System.out.println("Adding album to the database");
        System.out.println("Introduce the name of the album");
        prompt();
        String name = sc.nextLine();
        System.out.println();
        System.out.println("Introduce the year of release");
        prompt();
        int yearOfRelease = -1; //it's -1 so that it triggers the catch by default
        try {
            yearOfRelease = Integer.parseInt(sc.nextLine());
            if (yearOfRelease < 0 || yearOfRelease > 10000) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException nf) {
            error(Errors.INVALIDYEAR);
            return null;
        }
        System.out.println("Introduce the name of the record label that released this album");
        prompt();
        String recordLabel = sc.nextLine();
        System.out.println("Introduce the ID of the artist who released this album");
        System.out.println("Don't know the artist? Press enter with no input to search artists by name!");
        prompt();
        String inputResult = sc.nextLine();
        if (inputResult.equals("")) {
            return new Album(name, yearOfRelease, -1, recordLabel);
        } else {
            try {
                int inputID = Integer.parseInt(inputResult);
                if (inputID < 1) {
                    throw new NumberFormatException();
                } else {
                    Album newAlbum = new Album(name, yearOfRelease, inputID, recordLabel);
                        return newAlbum;
                }
            } catch (NumberFormatException nf) {
                error(Errors.INVALIDID);
                return null;
            }
        }
    }

    public boolean confirmArtist(Artist art, String process) {
        System.out.println("The artist is " + art.getName() + " from: " + art.getNationality());
        System.out.println("Proceed with " + process +"?" + " y/N");
        prompt();
        String choice = sc.nextLine();
        if (choice.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean confirmAlbum(Album alb, String process) {
        System.out.println("The album is " + alb.getName() + " released in " + alb.getYear() +
                " by the record label " + alb.getRecordLabel() + " with artistID " + alb.getArtistID());
        System.out.println("Proceed with " + process +"?" + " y/N");
        prompt();
        String choice = sc.nextLine();
        if (choice.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean confirmSong(Song son, String process) {
        String shortLyrics = "";
        if(son.getLyrics().length() > 31) {
            shortLyrics = son.getLyrics().substring(0,30);
        } else {
            shortLyrics = son.getLyrics();
        }
        System.out.println("The song is " + son.getName() + " released in " + son.getYear() +
                " with a length of " + son.getLength() + " and lyrics starting with '" + shortLyrics + ".....'"
        + " where the album ID is " + son.getAlbumID());
        System.out.println("Proceed with " + process +"?" + " y/N");
        prompt();
        String choice = sc.nextLine();
        if(choice.equals("y")) {
            return true;
        } else {
            return false;
        }
    }


    public String requestInput(InputRequests req) {
        switch(req) {
            case ASKID: {
                System.out.println("Input the desired ID");
                break;
            }
        }
        prompt();
        return sc.nextLine();
    }



    public String requestXname(String x) {
        System.out.println("Introduce the name of the " + x + " you want");
        prompt();
        String name = sc.nextLine();
        return name;
    }




    public void abort() {
        //perhaps make a better error management system with enums
        System.out.println("Aborting");
    }

    private void prompt() {
        System.out.print("\n:> ");
    }


    public void error(Errors err) {
        switch (err) {
            case DBERROR: {
                System.out.println("A database error occurred");
                return;
            }
            case INVALIDARTIST: {
                System.out.println("The artist introduced is not valid");
                return;
            }
            case INVALIDCC: {
                System.out.println("The country code does not exist or is invalid");
                return;
            }
            case INVALIDOPTION: {
                System.out.println("The option selected is not valid");
                return;
            }
            case CLEARERROR: {
                System.out.println("There was an error attempting to clear the screen");
                return;
            }
            case INVALIDYEAR: {
                System.out.println("The year introduced is not valid");
                return;
            }
            case INVALIDID: {
                System.out.println("The ID introduced is not valid");
                return;
            }
            case INVALIDLENGTH: {
                System.out.println("The length introduced is not valid");
            }
        }
    }

    public void success() {
        System.out.println("SUCCESS");
    }

    public void clear() {
        try {
            String os = System.getProperty("os.name");
            //System.out.println(os);
            if (os.contains("Windows")) {
                //for windows clear screen
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                //for unix/linux
                System.out.println("\033[H\033[2J");
            }
        } catch (Exception e) {
            error(Errors.CLEARERROR);
        }
    }

    public void printResultSet(ResultSet rs) {
        DBTablePrinter.printResultSet(rs);
    }

    public String formatTextSql(String s) {
        String s1 = s.replaceAll("[^a-zA-Z0-9 ]"," ");
        return s1;
    }
}

