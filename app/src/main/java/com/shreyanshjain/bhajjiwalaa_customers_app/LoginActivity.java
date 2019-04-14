package com.shreyanshjain.bhajjiwalaa_customers_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class LoginActivity extends AppCompatActivity {

    AppCompatImageView app_logo;
    RelativeLayout login_layout;
    Button login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        app_logo = findViewById(R.id.login_logo);
        login_layout =  findViewById(R.id.login_layout);

        app_logo.animate()
                .setDuration(700)
                .translationY(-600f)
                .scaleXBy(-0.5f)
                .scaleYBy(-0.5f);

        login_layout.animate()
                .setDuration(1700)
                .alphaBy(1.0f);

        login_btn = findViewById(R.id.login_button);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
