package com.example.vanhung.demo;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {

    TextView txtcontrol;
    RelativeLayout.LayoutParams params;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtcontrol=(TextView)findViewById(R.id.my_textview);
        params=(RelativeLayout.LayoutParams)txtcontrol.getLayoutParams();
        txtcontrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation slide = new TranslateAnimation(0, 0, txtcontrol.getTop(), txtcontrol.getTop()+200);

                Log.d("before",String.valueOf(txtcontrol.getTop()));
                slide.setDuration(500);
                slide.setFillAfter(true);
                slide.setFillEnabled(true);
                slide.setFillBefore(true);
                slide.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //txtcontrol.layout(txtcontrol.getLeft(), txtcontrol.getTop(), txtcontrol.getLeft() + txtcontrol.getWidth(), txtcontrol.getTop() + txtcontrol.getHeight() + 200);
                        txtcontrol.requestLayout();
                        int i=0;
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                v.startAnimation(slide);

//                ObjectAnimator mover = ObjectAnimator.ofFloat(v, "translationY", txtcontrol.getTop(), v.getTop()+400);
//                mover.setInterpolator(new AccelerateInterpolator());
//
//                mover.start();
//                params.topMargin=params.topMargin+200;
//                txtcontrol.setLayoutParams(params);
            }
        });

    }



}
