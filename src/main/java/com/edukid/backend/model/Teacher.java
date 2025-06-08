package com.edukid.backend.model;

public class Teacher {

    private String name;
    private String role;
    private String photo;
    private String whatsapp;

    public Teacher() {
        // Пустой конструктор для Firebase
    }

    public Teacher(String name, String role, String photo, String whatsapp) {
        this.name = name;
        this.role = role;
        this.photo = photo;
        this.whatsapp = whatsapp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", photo='" + photo + '\'' +
                ", whatsapp='" + whatsapp + '\'' +
                '}';
    }
}