package com.example.depeat.Gifclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.depeat.R;

import pl.droidsonroids.gif.GifImageView;

public class GifMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);

        GifImageView gifImageView =  findViewById(R.id.GifImageView);
        gifImageView.setImageResource(R.drawable.loading);


    }
}
