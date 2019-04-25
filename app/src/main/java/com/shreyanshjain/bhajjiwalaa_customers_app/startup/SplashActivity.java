package com.shreyanshjain.bhajjiwalaa_customers_app.startup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.shreyanshjain.bhajjiwalaa_customers_app.R;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {

    Animation fadeIn,fadeOut;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                                                R.anim.animation_fade_in);
        fadeIn.setAnimationListener(this);
        fadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation_fade_out);
        fadeOut.setAnimationListener(this);
        linearLayout = findViewById(R.id.splash_linear_layout);
        linearLayout.setVisibility(View.VISIBLE);
        linearLayout.startAnimation(fadeIn);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
//        linearLayout.startAnimation(fadeOut);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Intent i = new Intent(SplashActivity.this, WelcomeActivity.class);
        startActivity(i);
        this.finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
