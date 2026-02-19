package com.kce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "GARDENER_TBL")
public class Gardener {

    @Id
    @Column(name = "GARDENER_ID", length = 10)
    private String gardenerID;

    @Column(name = "FULL_NAME", length = 150)
    private String fullName;

    @Column(name = "EMAIL", length = 120)
    private String email;

    @Column(name = "MOBILE", length = 20)
    private String mobile;

    @Column(name = "STREET_NAME", length = 150)
    private String streetName;

    @Column(name = "HOUSE_NO", length = 80)
    private String houseOrApartmentNo;

    @Column(name = "PREFERRED_CATEGORY", length = 50)
    private String preferredCategory;

    @Column(name = "STATUS", length = 20)
    private String status;


    public String getGardenerID() {
        return gardenerID;
    }

    public void setGardenerID(String gardenerID) {
        this.gardenerID = gardenerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseOrApartmentNo() {
        return houseOrApartmentNo;
    }

    public void setHouseOrApartmentNo(String houseOrApartmentNo) {
        this.houseOrApartmentNo = houseOrApartmentNo;
    }

    public String getPreferredCategory() {
        return preferredCategory;
    }

    public void setPreferredCategory(String preferredCategory) {
        this.preferredCategory = preferredCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n----------------------------------\n" +
               "Gardener ID: " + gardenerID + "\n" +
               "Full Name: " + fullName + "\n" +
               "House No: " + houseOrApartmentNo + "\n" +
               "Street Name: " + streetName + "\n" +
               "Mobile: " + mobile + "\n" +
               "Email: " + email + "\n" +
               "Preferred Category: " + preferredCategory + "\n" +
               "Status: " + status + "\n" +
               "----------------------------------";
    }
}