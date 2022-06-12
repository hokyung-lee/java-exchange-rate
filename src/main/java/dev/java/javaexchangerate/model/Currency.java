package dev.java.javaexchangerate.model;

public class Currency {
    private String countryName;
    private String currencyName;
    private double exchangeRate;

    public Currency(String countryName, String currencyName, double exchangeRate) {
        this.countryName = countryName;
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }
}
