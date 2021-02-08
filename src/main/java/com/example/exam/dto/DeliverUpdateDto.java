package com.example.exam.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DeliverUpdateDto {
    @NotNull
    public int id;
    @NotNull
    @Size(max=200, message = "max 200 chars")
    public String contactPersonName;
    @NotNull
    @Size(max=15, message = "max 15 chars")
    public String contactPersonPhone;
    @NotNull
    @Size(max=300, message = "max 300 chars")
    public String address;
    @Size(max=30, message = "max 30 chars")
    public String preferredTime;
    public boolean delivered;

    public DeliverUpdateDto() {
    }

    public DeliverUpdateDto(@NotNull int id, @NotNull @Size(max = 200, message = "max 200 chars") String contactPersonName, @NotNull @Size(max = 15, message = "max 15 chars") String contactPersonPhone, @NotNull @Size(max = 300, message = "max 300 chars") String address, @Size(max = 30, message = "max 30 chars") String preferredTime, boolean delivered) {
        this.id = id;
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
