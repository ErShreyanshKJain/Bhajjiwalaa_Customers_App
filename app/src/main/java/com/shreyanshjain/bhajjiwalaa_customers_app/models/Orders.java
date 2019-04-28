package com.shreyanshjain.bhajjiwalaa_customers_app.models;

import java.util.ArrayList;

public class Orders {
    String id;
    ArrayList<Items> items;
    long timestamp;
    String addressDelivered;

    public Orders() {
    }

    public Orders(String id, ArrayList<Items> items, long timestamp, String addressDelivered) {
        this.id = id;
        this.items = items;
        this.timestamp = timestamp;
        this.addressDelivered = addressDelivered;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getAddressDelivered() {
        return addressDelivered;
    }

    public void setAddressDelivered(String addressDelivered) {
        this.addressDelivered = addressDelivered;
    }
}
