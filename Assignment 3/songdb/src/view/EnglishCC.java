package view;

import model.CountryCode;

public class EnglishCC {
    public static CountryCode getEnglishCC(String country) {
        String allLow = country.toLowerCase();
        //replaces numbers and spaces by nothing
        String noSpacesNumbers = allLow.replaceAll("[0-9]+| ","");

        switch (noSpacesNumbers) {
            case "afghanistan": {
                return CountryCode.AF;
            }
            case "alandislands": {
                return CountryCode.AX;
            }
            case "albania": {
                return CountryCode.AL;
            }
            case "algeria": {
                return CountryCode.DZ;
            }
            case "americansamoa": {
                return CountryCode.AS;
            }
            case "andorra": {
                return CountryCode.AD;
            }
            case "angola": {
                return CountryCode.AO;
            }
            case "anguilla": {
                return CountryCode.AI;
            }
            case "antarctica": {
                return CountryCode.AQ;
            }
            case "antiguaandbarbuda": {
                return CountryCode.AG;
            }
            case "argentina": {
                return CountryCode.AR;
            }
            case "armenia": {
                return CountryCode.AM;
            }
            care "aruba": {
        }
    }
}
