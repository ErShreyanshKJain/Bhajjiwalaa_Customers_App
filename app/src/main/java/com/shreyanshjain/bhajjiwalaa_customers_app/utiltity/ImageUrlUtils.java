package com.shreyanshjain.bhajjiwalaa_customers_app.utiltity;

import android.content.ClipData;
import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shreyanshjain.bhajjiwalaa_customers_app.models.Items;

import java.util.ArrayList;

public class ImageUrlUtils {

    static ArrayList<Items> cartListItem = new ArrayList<>();
    FirebaseAuth mAuth;
    ArrayList<Items> itemList;
    DatabaseReference mDatabaseReference;
    ValueEventListener eventListener;


    // Methods for Cart
    public void addCartListItem(Items cartListItem) {


        this.cartListItem.add(0,cartListItem);
    }

    public void removeCartListImageUrl(int position) {

        this.cartListItem.remove(position);
    }

    public ArrayList<Items> getCartListItem(){ return this.cartListItem; }

}

