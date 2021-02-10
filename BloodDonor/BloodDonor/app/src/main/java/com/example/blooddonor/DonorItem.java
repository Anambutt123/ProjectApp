package com.example.blooddonor;

public class DonorItem {

    private String donorName, donorNumber;

    public DonorItem(String donorName, String donorNumber) {
        this.donorName = donorName;
        this.donorNumber = donorNumber;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorNumber() {
        return donorNumber;
    }

    public void setDonorNumber(String donorNumber) {
        this.donorNumber = donorNumber;
    }
}
