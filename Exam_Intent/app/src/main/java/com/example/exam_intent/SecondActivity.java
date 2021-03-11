package com.example.exam_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onClick(View v) {
        // 현재 Activity를 종료

        if (v.getId() == R.id.backBTN) {
            finish();
        }
        else if (v.getId() == R.id.secondlayout) {
            Intent intent = new Intent(SecondActivity.this,Thirdactivity.class);

            startActivity(intent);
        }
    }
}