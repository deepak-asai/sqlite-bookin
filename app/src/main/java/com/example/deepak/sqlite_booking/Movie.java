package com.example.deepak.sqlite_booking;

/**
 * Created by deepak on 6/7/16.
 */
public class Movie {

    private String mname;
    private int id;

    public Movie(){

    }
    public Movie(String name) {
        this.mname = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.mname = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return mname;
    }
}
