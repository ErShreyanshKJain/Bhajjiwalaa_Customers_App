package com.shreyanshjain.bhajjiwalaa_customers_app.cart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.shreyanshjain.bhajjiwalaa_customers_app.CartListAdapter;
import com.shreyanshjain.bhajjiwalaa_customers_app.MainActivity;
import com.shreyanshjain.bhajjiwalaa_customers_app.R;
import com.shreyanshjain.bhajjiwalaa_customers_app.utiltity.ImageUrlUtils;

import java.util.ArrayList;

import static android.view.View.GONE;

public class CartListActivity extends AppCompatActivity implements Animation.AnimationListener {

    private static Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        mContext = CartListActivity.this;

        ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
        ArrayList<String> cartList = imageUrlUtils.getCartListImageUrl();

        setCartLayout();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager recyclerViewLayoutManager = new LinearLayoutManager(mContext);

        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.setAdapter(new CartListAdapter(cartList,mContext));

    }

    public void setCartLayout()
    {
        LinearLayout layoutCartItems = findViewById(R.id.layout_items);
        LinearLayout layoutCartPayments = findViewById(R.id.layout_payment);
        LinearLayout layoutCartNoItems = findViewById(R.id.cart_empty_layout);

        if(MainActivity.notificationCountCart>0)
        {
            layoutCartItems.setVisibility(View.VISIBLE);
            layoutCartNoItems.setVisibility(GONE);
            layoutCartPayments.setVisibility(View.VISIBLE);
        }
        else{
            layoutCartItems.setVisibility(GONE);
            layoutCartNoItems.setVisibility(View.VISIBLE);
            layoutCartPayments.setVisibility(GONE);

            Button startShopping = findViewById(R.id.empty_shop_btn);
            startShopping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

}
