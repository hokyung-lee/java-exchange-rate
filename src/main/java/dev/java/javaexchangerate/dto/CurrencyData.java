package dev.java.javaexchangerate.dto;

import dev.java.javaexchangerate.model.Currency;
import java.util.List;

public class CurrencyData {
    private String baseCountry;
    private String baseCurrency;
    private List<Currency> currencies;

    public String getBaseCountry() {
        return baseCountry;
    }

    public void setBaseCountry(String baseCountry) {
        this.baseCountry = baseCountry;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
