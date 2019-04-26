package com.shreyanshjain.bhajjiwalaa_customers_app.classes;

public class OfferClass {
    private String offerId,offerName,key;
    private double discount;
    private int numDiscount;

    public OfferClass(){}

    public OfferClass(String offerId, String offerName, double discount){
        this.offerId=offerId;
        this.offerName=offerName;
        this.discount=discount;
    }

    public OfferClass(String offerId, String offerName, double discount, int numDiscount){
        this.offerId=offerId;
        this.offerName=offerName;
        this.discount=discount;
        this.numDiscount=numDiscount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getNumDiscount() {
        return numDiscount;
    }

    public void setNumDiscount(int numDiscount) {
        this.numDiscount = numDiscount;
    }

}
