package com.example.chess_nxtgen;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

public class F_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_page);

        final ImageView FirstLayout = (ImageView) findViewById(R.id.FirstLayout);
        final LinearLayout SecondLayout = (LinearLayout) findViewById((R.id.SecondLayout);

        SecondLayout.setVisibility(View.INVISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SecondLayout.setVisibility(View.VISIBLE);
                FirstLayout.setVisibility(View.INVISIBLE);
            }
        },5000);

        Button StartGame = (Button) findViewById((R.id.button);

        StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FirstPage.this , MainActivity.class);
                FirstPage.this.startActivity(i);
            }
        });
    }
}