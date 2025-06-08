package com.edukid.backend.model;

public class Subscriber {
    private String phone;

    public Subscriber() {}

    public Subscriber(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}