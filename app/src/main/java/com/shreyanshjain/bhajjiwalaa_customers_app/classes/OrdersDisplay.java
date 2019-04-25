package com.shreyanshjain.bhajjiwalaa_customers_app.classes;

import android.graphics.drawable.Drawable;

public class OrdersDisplay {
    private String name;
    private String stock;
    private String price;
    private String category,key;
    private String image;
    private String url;

    public OrdersDisplay (){}

    public OrdersDisplay (String name, String stock, String price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public OrdersDisplay (String name, String stock, String price, String category) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.category = category;
    }

    public OrdersDisplay (String name, String stock, String price, String category, String image,String url) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.category = category;
        this.image = image;
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
