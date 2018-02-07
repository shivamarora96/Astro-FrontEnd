package com.saproductions.astro.Helper;

import java.util.ArrayList;


public class Response {

    boolean status;
    String date;
    ArrayList<Rashi> data;


    public boolean getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<Rashi> getData() {
        return data;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setData(ArrayList<Rashi> data) {
        this.data = data;
    }
}
