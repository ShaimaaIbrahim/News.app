package com.example.news.Model;

public class DataMonawaat {
private int image;
private String text;
private String uri;

    public DataMonawaat(int image,String text,String uri) {
        this.image = image;
        this.text=text;
        this.uri=uri;

    }

    public int getimage() {
        return image;
    }

    public String gettext() {
        return text;
    }

    public String getUri() {
        return uri;
    }
}
