package com.example.teacherstudentapp;

public class uploadPDF {
    public String name;
    public String uri;

    public uploadPDF() {
    }

    public uploadPDF(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }


}
