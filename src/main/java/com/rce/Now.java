package com.rce;

public class Now {

    private String dateTime;

    public Now(){ }

    public Now(String datetime) {
        this.dateTime = datetime;
    }

    public String getDatetime() {
        return dateTime;
    }

    public void setDatetime(String datetime) {
        this.dateTime = datetime;
    }
}
