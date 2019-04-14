package com.shreyanshjain.bhajjiwalaa_customers_app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shreyanshjain.bhajjiwalaa_customers_app.MainActivity;
import com.shreyanshjain.bhajjiwalaa_customers_app.R;
import com.shreyanshjain.bhajjiwalaa_customers_app.SimpleStringRecyclerViewAdapter;
import com.shreyanshjain.bhajjiwalaa_customers_app.utiltity.ImageUrlUtils;

public class ImageListFragment extends Fragment {

    private static MainActivity mainActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity)getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.layout_recyclerview_list,
                container,false);
        setupRecyclerView(recyclerView);
        return recyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        String[] items=null;
        if (ImageListFragment.this.getArguments().getInt("type") == 1){
            items= ImageUrlUtils.getFruitUrls();
        }
        else{
            items = ImageUrlUtils.getVegetableUrls();
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(recyclerView, items, mainActivity));
    }
}
