package dev.java.javaexchangerate.dto;

import java.util.HashMap;

public class CurrencyInvokerResponse {
    private HashMap<String, Double> quotes;
    private String source;
    private boolean success;
    private Long timestamp;

    public HashMap<String, Double> getQuotes() {
        return quotes;
    }

    public void setQuotes(HashMap<String, Double> quotes) {
        this.quotes = quotes;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
