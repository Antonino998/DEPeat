package com.example.depeat.Gifclass;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.depeat.R;
import com.example.depeat.ui.activities.HomeActivity;


import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    private static int  TIME_OUT_LOADING = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GifImageView gifImageView =  findViewById(R.id.GifImageView);
        gifImageView.setImageResource(R.drawable.loading);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);

            }
        },TIME_OUT_LOADING);


    }
}
