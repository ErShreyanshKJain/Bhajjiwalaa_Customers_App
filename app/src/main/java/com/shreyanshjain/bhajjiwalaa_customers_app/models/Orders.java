package com.shreyanshjain.bhajjiwalaa_customers_app.models;

import java.util.ArrayList;

public class Orders {
    String id;
    ArrayList<Items> items;
    long timeDel;
    long timeOrd;
    String addressDelivered;
    String currentStatus;
    String phoneNo;

    public Orders() {
    }

    public Orders(String id, ArrayList<Items> items, long timeDel, long timeOrd, String addressDelivered, String currentStatus, String phoneNo) {
        this.id = id;
        this.items = items;
        this.timeDel = timeDel;
        this.timeOrd = timeOrd;
        this.addressDelivered = addressDelivered;
        this.currentStatus = currentStatus;
        this.phoneNo = phoneNo;
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

    public long getTimeDel() {
        return timeDel;
    }

    public void setTimeDel(long timeDel) {
        this.timeDel = timeDel;
    }

    public long getTimeOrd() {
        return timeOrd;
    }

    public void setTimeOrd(long timeOrd) {
        this.timeOrd = timeOrd;
    }

    public String getAddressDelivered() {
        return addressDelivered;
    }

    public void setAddressDelivered(String addressDelivered) {
        this.addressDelivered = addressDelivered;
    }
}
