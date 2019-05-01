package com.shreyanshjain.bhajjiwalaa_customers_app.models;

//import com.google.gson.annotations.SerializedName;

public class Items {

    String id;
//    @SerializedName("category")
    String category;
//    @SerializedName("image")
    String image;
//    @SerializedName("name")
    String name;
//    @SerializedName("price")
    String price;
//    @SerializedName("stock")
    String stock;
//    @SerializedName("url")
    String url;

    public Items() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getStock() {
        return stock;
    }

    public String getUrl() {
        return url;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
