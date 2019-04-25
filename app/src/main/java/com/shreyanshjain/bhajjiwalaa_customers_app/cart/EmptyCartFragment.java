package com.shreyanshjain.bhajjiwalaa_customers_app.cart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shreyanshjain.bhajjiwalaa_customers_app.MainActivity;
import com.shreyanshjain.bhajjiwalaa_customers_app.R;
import com.shreyanshjain.bhajjiwalaa_customers_app.cart.CartListActivity;

public class EmptyCartFragment extends Fragment {

    Context context;
    public EmptyCartFragment()
    {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        context = (CartListActivity)getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        final View view = inflater.inflate(R.layout.empty_message_layout_action,container,false);

        Button shopNow = view.findViewById(R.id.empty_shop_btn);

        shopNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(), MainActivity.class));
            }
        });
        return view;
    }
}
