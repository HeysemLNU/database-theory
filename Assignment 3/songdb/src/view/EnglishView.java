package view;

import model.CountryCode;

public class EnglishView implements ViewTemplate {

    @Override
    public CountryCode getCC(String countryName) {
        EnglishCC.getEnglishCC(countryName);
    }
}
