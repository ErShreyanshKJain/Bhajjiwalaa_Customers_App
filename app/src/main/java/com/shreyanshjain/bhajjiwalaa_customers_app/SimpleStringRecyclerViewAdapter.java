package com.shreyanshjain.bhajjiwalaa_customers_app;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.shreyanshjain.bhajjiwalaa_customers_app.cart.CartCountSetClass;
import com.shreyanshjain.bhajjiwalaa_customers_app.cart.SetAddButton;
import com.shreyanshjain.bhajjiwalaa_customers_app.models.Items;
import com.shreyanshjain.bhajjiwalaa_customers_app.utiltity.ImageUrlUtils;

import java.util.ArrayList;

public class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder>{

    private ArrayList<Items> mValues;
    private RecyclerView mRecyclerView;
    private MainActivity mainActivity;
    String url;

    @NonNull
    @Override
    public SimpleStringRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new SimpleStringRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SimpleStringRecyclerViewAdapter.ViewHolder viewHolder, int i) {

        Glide.with(mainActivity)
                .load(mValues.get(i).getUrl())
                .centerCrop()
                .into(viewHolder.item_image);

//        CartListAdapter.setSetAddButton(SimpleStringRecyclerViewAdapter.this);
        final int id = i;
        viewHolder.item_name.setText(mValues.get(i).getName());
        viewHolder.item_amt.setText("Rs. "+mValues.get(i).getPrice());
        viewHolder.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.addCartListItem(mValues.get(id));
                Toast.makeText(mainActivity.getApplicationContext(),"Item added to the cart",Toast.LENGTH_SHORT).show();
                MainActivity.notificationCountCart++;
                CartCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
                viewHolder.add_btn.setVisibility(View.GONE);
                viewHolder.item_amt.setText(R.string.item_in_cart);
                viewHolder.item_amt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
            }
        });

        /*
        * TODO: Add code to get back the add button for a particular item if it is removed from the cart
        * */
        /*
        * We can put a condition to check for an item that whether it is currently present in the
        * cartList or not. If it is present than remove the add button and if it is not then get
        * put the add button(if removed) or just let it be there
        * */
        ImageUrlUtils img = new ImageUrlUtils();
        if(!img.getCartListItem().contains(mValues.get(id)) ){
            viewHolder.add_btn.setVisibility(View.VISIBLE);
            viewHolder.item_amt.setText("Rs. "+mValues.get(id).getPrice());
            viewHolder.item_amt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
//            notifyDataSetChanged();
        }else{
            viewHolder.add_btn.setVisibility(View.GONE);
            viewHolder.item_amt.setText(R.string.item_in_cart);
            viewHolder.item_amt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        }

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public SimpleStringRecyclerViewAdapter(RecyclerView recyclerView, ArrayList<Items> items, MainActivity mActivity) {
        mValues = items;
        mRecyclerView = recyclerView;
        mainActivity = mActivity;
    }

//    @Override
//    public void setImageUrl(String url) {
//           this.url = url;
//    }

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
