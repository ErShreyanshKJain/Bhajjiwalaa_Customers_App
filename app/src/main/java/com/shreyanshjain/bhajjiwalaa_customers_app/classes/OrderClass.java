package com.shreyanshjain.bhajjiwalaa_customers_app.classes;

public class OrderClass {
    private String orderId, orderAddress, orderStatus, orderDuration, orderName, orderPhone;
    private double orderPrice;

    OrderClass(){}

    public OrderClass(String orderId, String orderAddress, String orderStatus, String orderDuration, String orderName, String orderPhone, double orderPrice) {
        this.orderId = orderId;
        this.orderAddress = orderAddress;
        this.orderStatus = orderStatus;
        this.orderDuration = orderDuration;
        this.orderName = orderName;
        this.orderPhone = orderPhone;
        this.orderPrice = orderPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDuration() {
        return orderDuration;
    }

    public void setOrderDuration(String orderDuration) {
        this.orderDuration = orderDuration;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }
}
