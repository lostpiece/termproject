package com.example.ensu4.termproject;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;


public class SplashActivity extends AppCompatActivity{
    ImageView mchain;
    int mScreenHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mchain = (ImageView) findViewById(R.id.chain);

    }

    protected void onResume() {
        super.onResume();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mScreenHeight = displaymetrics.heightPixels;

        startFireValuePropertyAnimation();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    private void startFireValuePropertyAnimation() {
        ValueAnimator positionAnimator = ValueAnimator.ofFloat(0,-mScreenHeight);
        positionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator){
                float value = (float) valueAnimator.getAnimatedValue();
                mchain.setTranslationY(value);
            }
        });


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setStartDelay(2000);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }
}
