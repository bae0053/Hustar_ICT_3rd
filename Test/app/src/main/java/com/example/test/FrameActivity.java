package com.example.test;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FrameActivity extends AppCompatActivity {

    //private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame);

    }

    public void onClickFunc (View view) {
        /*int btnN = view.getId();
        button = findViewById(btnN);
        button.setVisibility(View.INVISIBLE);*/

        view.setVisibility(View.GONE);
    }
}