package com.udacity.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }

    private String joke;

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}