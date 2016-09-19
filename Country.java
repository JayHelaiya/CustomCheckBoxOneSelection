package com.example.nichetech.customchackbox;

/**
 * Created by nichetech on 19/9/16.
 */
public class Country {

    public int CountryID;
    public String CountryName;
    public  int flag;

    public Country(int countryID, String countryName) {
        CountryID = countryID;
        CountryName = countryName;
        this.flag = flag;
    }

    public int getCountryID() {
        return CountryID;
    }

    public void setCountryID(int countryID) {
        CountryID = countryID;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
