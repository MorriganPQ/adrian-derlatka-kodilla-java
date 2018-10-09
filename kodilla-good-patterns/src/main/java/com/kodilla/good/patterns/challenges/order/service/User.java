package com.kodilla.good.patterns.challenges.order.service;

public class User {
    private String name;
    private String surname;
    private String address;
    private String mail;
    private String phone;

    public User(final String name, final String surname, final String address, final String mail, final String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.mail = mail;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }
}
