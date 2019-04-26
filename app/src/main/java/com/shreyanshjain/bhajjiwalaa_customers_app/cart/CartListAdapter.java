package com.shreyanshjain.bhajjiwalaa_customers_app.cart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.shreyanshjain.bhajjiwalaa_customers_app.MainActivity;
import com.shreyanshjain.bhajjiwalaa_customers_app.R;
import com.shreyanshjain.bhajjiwalaa_customers_app.models.Items;
import com.shreyanshjain.bhajjiwalaa_customers_app.utiltity.ImageUrlUtils;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class CartListAdapter
        extends RecyclerView.Adapter<CartListAdapter.ViewHolder>{

    private ArrayList<Items> cartListItem;
    public Context mContext;
    public View mView;

    public CartListAdapter(ArrayList<Items> cartListImageUrl, Context context, View view){
        cartListItem = cartListImageUrl;
        mContext = context;
        mView = view;
    }

    @NonNull
    @Override
    public CartListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cartlist_item,viewGroup,false);
        return new CartListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final String url = cartListItem.get(i).getUrl();
        Glide.with(mContext)
                .load(url)
                .centerCrop()
                .into(viewHolder.itemImage);

        final int pos = i;
        viewHolder.itemDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation fadeOut = AnimationUtils.loadAnimation(mContext,R.anim.animation_fade_out);
                fadeOut.setAnimationListener(new CartListActivity());

//                viewHolder.mView.setAnimation(fadeOut);

                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.removeCartListImageUrl(pos);
                notifyDataSetChanged();

                MainActivity.notificationCountCart--;

//                if(setAddButtonListener!=null)
//                    setAddButtonListener.setImageUrl(mCartListImageUrl.get(pos));

                if(MainActivity.notificationCountCart == 0)
                {
                    /*
                    * TODO: Add code to bring back the empty cart layout
                    * */

//                    Intent i = new Intent(mContext,MainActivity.class);

//                        LinearLayout layoutCartItems = mView.findViewById(R.id.layout_items);
//                        LinearLayout layoutCartPayments = mView.findViewById(R.id.layout_payment);
//                        LinearLayout layoutCartNoItems = mView.findViewById(R.id.empty_msg_layout);
//
//                        layoutCartItems.setVisibility(GONE);
//                        layoutCartNoItems.setVisibility(View.VISIBLE);
//                        layoutCartPayments.setVisibility(GONE);
//
//                        Button startShopping = view.findViewById(R.id.empty_shop_btn);
//                        startShopping.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//
//                            }
//                        });
                }
            }
        });

        /*
        * TODO: Add code to handle the change in values of quantity and re-calculate the price accordingly
        * */
//            viewHolder.itemQty.setOnItemSelectedListener();

    }

//    public void setEmptyFragment()
//    {
//        LinearLayout linearLayout = findViewById(R.id.layout_payment);
//        linearLayout.setVisibility(GONE);
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.add(R.id.activity_cart_list,new EmptyCartFragment());
//        ft.commit();
//
//    }


//    public static SetAddButton setAddButtonListener;
//    public static void setSetAddButton(SetAddButton setAddButton){
//        setAddButtonListener=setAddButton;
//    }

    @Override
    public int getItemCount() {
        return cartListItem.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final AppCompatTextView itemName,itemAmt;
        public final ImageView itemDel;
        public final Spinner itemQty;
        public final AppCompatImageView itemImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            itemImage = itemView.findViewById(R.id.cart_item_image);
            itemName = itemView.findViewById(R.id.cart_item_name);
            itemAmt = itemView.findViewById(R.id.cart_amount);
            itemDel = itemView.findViewById(R.id.cart_delete);
            itemQty = itemView.findViewById(R.id.cart_item_spinner);
        }
    }
}