package com.shreyanshjain.bhajjiwalaa_customers_app.models;

import java.util.ArrayList;

public class Users {

    String userId;
    String name;
    String phoneNo;
    String tokenId;
    String address;
//    ArrayList<Items> cart;
//    ArrayList<Orders> orders;

    public Users() {
    }

    public Users(String userId, String name, String phoneNo, String tokenId, String address) {
        this.userId = userId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.tokenId = tokenId;
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
