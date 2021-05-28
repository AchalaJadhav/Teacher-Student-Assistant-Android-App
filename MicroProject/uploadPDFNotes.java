package com.example.teacherstudentapp;

public class uploadPDFNotes {
    public String name,uri;

    public uploadPDFNotes(String name, String uri) {
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
