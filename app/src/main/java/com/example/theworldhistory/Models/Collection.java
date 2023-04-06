package com.example.theworldhistory.Models;

public class Collection {

    int id;
    String title, status_number,
            status_1_1, status_1_2, status_1_3,
            status_2_1, status_2_2, status_2_3,
            image_1_1, image_1_2, image_1_3,
            image_2_1, image_2_2, image_2_3;

    public Collection(int id, String title, String status_number,
                 String status_1_1, String image_1_1, String status_1_2, String image_1_2,
                 String status_1_3, String image_1_3, String status_2_1, String image_2_1,
                 String status_2_2, String image_2_2, String status_2_3, String image_2_3) {
        this.id = id;
        this.title = title;
        this.status_number = status_number;
        this.status_1_1 = status_1_1;
        this.status_1_2 = status_1_2;
        this.status_1_3 = status_1_3;
        this.status_2_1 = status_2_1;
        this.status_2_2 = status_2_2;
        this.status_2_3 = status_2_3;
        this.image_1_1 = image_1_1;
        this.image_1_2 = image_1_2;
        this.image_1_3 = image_1_3;
        this.image_2_1 = image_2_1;
        this.image_2_2 = image_2_2;
        this.image_2_3 = image_2_3;

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

    public String getStatus_number() {
        return status_number;
    }

    public void setStatus_number(String status_number) {
        this.status_number = status_number;
    }

    public String getStatus_1_1() {
        return status_1_1;
    }

    public void setStatus_1_1(String status_1_1) {
        this.status_1_1 = status_1_1;
    }

    public String getStatus_1_2() {
        return status_1_2;
    }

    public void setStatus_1_2(String status_1_2) {
        this.status_1_2 = status_1_2;
    }

    public String getStatus_1_3() {
        return status_1_3;
    }

    public void setStatus_1_3(String status_1_3) {
        this.status_1_3 = status_1_3;
    }

    public String getStatus_2_1() {
        return status_2_1;
    }

    public void setStatus_2_1(String status_2_1) {
        this.status_2_1 = status_2_1;
    }

    public String getStatus_2_2() {
        return status_2_2;
    }

    public void setStatus_2_2(String status_2_2) {
        this.status_2_2 = status_2_2;
    }

    public String getStatus_2_3() {
        return status_2_3;
    }

    public void setStatus_2_3(String status_2_3) {
        this.status_2_3 = status_2_3;
    }

    public String getImage_1_1() {
        return image_1_1;
    }

    public void setImage_1_1(String image_1_1) {
        this.image_1_1 = image_1_1;
    }

    public String getImage_1_2() {
        return image_1_2;
    }

    public void setImage_1_2(String image_1_2) {
        this.image_1_2 = image_1_2;
    }

    public String getImage_1_3() {
        return image_1_3;
    }

    public void setImage_1_3(String image_1_3) {
        this.image_1_3 = image_1_3;
    }

    public String getImage_2_1() {
        return image_2_1;
    }

    public void setImage_2_1(String image_2_1) {
        this.image_2_1 = image_2_1;
    }

    public String getImage_2_2() {
        return image_2_2;
    }

    public void setImage_2_2(String image_2_2) {
        this.image_2_2 = image_2_2;
    }

    public String getImage_2_3() {
        return image_2_3;
    }

    public void setImage_2_3(String image_2_3) {
        this.image_2_3 = image_2_3;
    }
}
