package com.example.theworldhistory.Models;

public class Award {
    int id;
    String title, description, status_number, imageView;

    public Award(int id, String title, String description, String status_number, String imageView) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status_number = status_number;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusNumber() {
        return status_number;
    }

    public void setStatusNumber(String statusNumber) {
        this.status_number = statusNumber;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }
}
