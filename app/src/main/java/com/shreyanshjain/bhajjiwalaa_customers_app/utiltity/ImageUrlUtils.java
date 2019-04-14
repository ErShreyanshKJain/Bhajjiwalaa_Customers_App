package com.shreyanshjain.bhajjiwalaa_customers_app.utiltity;

import java.util.ArrayList;

public class ImageUrlUtils {

    static ArrayList<String> wishlistImageUrl = new ArrayList<>();
    static ArrayList<String> cartListImageUrl = new ArrayList<>();

    public static String[] getFruitUrls() {
        String[] urls = new String[]
                {
                        "https://static.pexels.com/photos/1778/numbers-time-watch-white-medium.jpg",
                        "https://static.pexels.com/photos/189293/pexels-photo-189293-medium.jpeg",
                        "https://static.pexels.com/photos/4703/inside-apartment-design-home-medium.jpg",
                        "https://static.pexels.com/photos/133919/pexels-photo-133919-medium.jpeg",
                        "https://static.pexels.com/photos/111147/pexels-photo-111147-medium.jpeg",
                        "https://static.pexels.com/photos/2713/wall-home-deer-medium.jpg",
                        "https://static.pexels.com/photos/177143/pexels-photo-177143-medium.jpeg",
                        "https://static.pexels.com/photos/106936/pexels-photo-106936-medium.jpeg",
                        "https://static.pexels.com/photos/1778/numbers-time-watch-white-medium.jpg",
                        "https://static.pexels.com/photos/189293/pexels-photo-189293-medium.jpeg"
                };
        return urls;
    }

    public static String[] getVegetableUrls() {
        String[] urls = new String[]
                {
                        "https://static.pexels.com/photos/204611/pexels-photo-204611-medium.jpeg",
                        "https://static.pexels.com/photos/214487/pexels-photo-214487-medium.jpeg",
                        "https://static.pexels.com/photos/168575/pexels-photo-168575-medium.jpeg",
                        "https://static.pexels.com/photos/213384/pexels-photo-213384-medium.jpeg",
                        "https://static.pexels.com/photos/114907/pexels-photo-114907-medium.jpeg",
                        "https://static.pexels.com/photos/185030/pexels-photo-185030-medium.jpeg",
                        "https://static.pexels.com/photos/133579/pexels-photo-133579-medium.jpeg",
                        "https://static.pexels.com/photos/51383/photo-camera-subject-photographer-51383-medium.jpeg",
                        "https://static.pexels.com/photos/205926/pexels-photo-205926-medium.jpeg"
                };
        return urls;
    }

    public void addWishlistImageUrl(String wishImageUrl)
    {
        this.wishlistImageUrl.add(0,wishImageUrl);
    }


}
