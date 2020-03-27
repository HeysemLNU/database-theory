package view;

import model.*;

public interface ViewTemplate {

    CountryCode getCC();

    SelectedOption mainMenu();

    enum SelectedOption {
        DEFAULT, ADDARTIST, REMOVEARTIST, ADDSONG,
        REMOVESONG, ADDALBUM, REMOVEALBUM, SEARCHARTISTBYNAME,
        EXIT, SEARCHSONGNAME, SEARCHSONGLYRICS, SEARCHALBUMBYNAME,INITDB;
    }

    enum Errors {
        DBERROR, INVALIDARTIST,INVALIDCC,INVALIDOPTION,CLEARERROR, INVALIDYEAR, INVALIDID, INVALIDLENGTH;
    }

    enum InputRequests {
        ASKID;
    }
}
