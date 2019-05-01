package com.shreyanshjain.bhajjiwalaa_customers_app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shreyanshjain.bhajjiwalaa_customers_app.MainActivity;
import com.shreyanshjain.bhajjiwalaa_customers_app.R;
import com.shreyanshjain.bhajjiwalaa_customers_app.SimpleStringRecyclerViewAdapter;
import com.shreyanshjain.bhajjiwalaa_customers_app.login.LoginActivity;
import com.shreyanshjain.bhajjiwalaa_customers_app.models.Items;
import com.shreyanshjain.bhajjiwalaa_customers_app.utiltity.ImageUrlUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class ImageListFragment extends Fragment {

    private static MainActivity mainActivity;
    ArrayList<Items> itemList;
    DatabaseReference mDatabaseReference;
    ValueEventListener eventListener;
    RecyclerView recyclerView;
    AlertDialog.Builder builder;
    AlertDialog dialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity)getActivity();

        builder = new AlertDialog.Builder(mainActivity);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.dialog_progress);
        dialog = builder.create();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(R.layout.layout_recyclerview_list,container,false);
        if (ImageListFragment.this.getArguments().getInt("type") == 1){
            getItemList("Fruits");
        }
        else{
            getItemList("Vegetables");
        }
        return recyclerView;
    }

    public void getItemList(final String category)
    {

        itemList = new ArrayList<>();
        dialog.show();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children=dataSnapshot.getChildren();
                for(DataSnapshot data:children) {
                    Items items=data.getValue(Items.class);
                    items.setId(data.getKey());
                    itemList.add(items);
                }
                setupRecyclerView(recyclerView,itemList);
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                dialog.dismiss();
            }
        };
        mDatabaseReference.child("orders")
                .child(category)
                .addValueEventListener(eventListener);

    }


    private void setupRecyclerView(RecyclerView recyclerView, ArrayList<Items> items) {
        SimpleStringRecyclerViewAdapter adapter = new SimpleStringRecyclerViewAdapter(recyclerView, items, mainActivity);
        recyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
