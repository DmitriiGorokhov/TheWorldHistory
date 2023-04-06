package com.example.theworldhistory.Models;

public class League {

    int id;
    String title, imageView;

    public League(int id, String title, String imageView) {
        this.id = id;
        this.title = title;
        this.imageView = imageView;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }
}
