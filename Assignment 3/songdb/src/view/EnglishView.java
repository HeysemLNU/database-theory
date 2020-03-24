package view;

import model.CountryCode;

public class EnglishView implements ViewTemplate {

    public EnglishView() {

    }

    @Override
    public CountryCode getCC(String countryName) {
        EnglishCC countryCodeFunction = new EnglishCC();

        //if this returns null then the country code was not found
        CountryCode cc = countryCodeFunction.getEnglishCC(countryName);
        return null;
    }
}
