package com.example.news.Model;

public class New {
    private String description;
    private String title;
    private String uriImage;
    private String PublishedAt;
    private String name;
    public New(String name,String description,String uriImage,String publishedAt,String title ) {
        this.description=description;
        this.title=title;
        this.uriImage=uriImage;
        this.PublishedAt=publishedAt;
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUriImage() {
        return uriImage;
    }

    public String getPublishedAt() {
        return PublishedAt;
    }

    public String getName() {
        return name;
    }
}
