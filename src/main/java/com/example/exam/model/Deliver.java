package com.example.exam.model;

public class Deliver {
    public int id;
    public String contactPersonName;
    public String contactPersonPhone;
    public String address;
    public String preferredTime;
    public boolean delivered;

    public Deliver() {
    }

    public Deliver(String contactPersonName, String contactPersonPhone, String address, String preferredTime, boolean delivered) {
        this.contactPersonName = contactPersonName;
        this.contactPersonPhone = contactPersonPhone;
        this.address = address;
        this.preferredTime = preferredTime;
        this.delivered = delivered;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonPhone() {
        return contactPersonPhone;
    }

    public void setContactPersonPhone(String contactPersonPhone) {
        this.contactPersonPhone = contactPersonPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPreferredTime() {
        return preferredTime;
    }

    public void setPreferredTime(String preferredTime) {
        this.preferredTime = preferredTime;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
