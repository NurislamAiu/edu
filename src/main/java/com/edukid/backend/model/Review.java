package com.edukid.backend.model;

public class Review {
    private String text;
    private String parent;
    private String photo;
    private String video;

    public Review() {}

    public Review(String text, String parent, String photo, String video) {
        this.text = text;
        this.parent = parent;
        this.photo = photo;
        this.video = video;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}