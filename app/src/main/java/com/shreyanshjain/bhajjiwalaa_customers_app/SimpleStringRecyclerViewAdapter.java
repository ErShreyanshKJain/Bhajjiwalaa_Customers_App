package com.shreyanshjain.bhajjiwalaa_customers_app;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.bumptech.glide.Glide;

public class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

    private String[] mValues;
    private RecyclerView mRecyclerView;
    private MainActivity mainActivity;

    @NonNull
    @Override
    public SimpleStringRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new SimpleStringRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleStringRecyclerViewAdapter.ViewHolder viewHolder, int i) {

        Glide.with(mainActivity)
                .load(mValues[i])
                .centerCrop()
                .into(viewHolder.item_image);
    }

    @Override
    public int getItemCount() {
        return mValues.length;
    }

    public SimpleStringRecyclerViewAdapter(RecyclerView recyclerView, String[] items, MainActivity mActivity) {
        mValues = items;
        mRecyclerView = recyclerView;
        mainActivity = mActivity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public final View mView;
        public final AppCompatImageView item_image;
        public final AppCompatTextView item_name,item_amt;
        public final Spinner item_quantity;
        public final Button add_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            item_image = itemView.findViewById(R.id.card_image);
            item_name = itemView.findViewById(R.id.card_name);
            item_amt = itemView.findViewById(R.id.card_amount);
            item_quantity = itemView.findViewById(R.id.card_spinner);
            add_btn = itemView.findViewById(R.id.card_add_btn);
        }
    }

}
