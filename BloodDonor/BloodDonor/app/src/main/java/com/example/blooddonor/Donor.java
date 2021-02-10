package com.example.blooddonor;

import java.io.Serializable;

public class Donor implements Serializable {

    private String name, number, address, Bgroup;

    public Donor() {

    }

    public Donor(String name, String number, String address, String bgroup) {
        this.name = name;
        this.number = number;
        this.address = address;
        Bgroup = bgroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBgroup() {
        return Bgroup;
    }

    public void setBgroup(String bgroup) {
        Bgroup = bgroup;
    }
}
