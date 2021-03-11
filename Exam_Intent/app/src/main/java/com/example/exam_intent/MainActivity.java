package com.example.exam_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // XML onClick method
    public void onClick(View v) {
        // 화면 클릭하면 SecondActivity로 전환

        // (1) Intent 생선
        Intent Clickintent = new Intent(MainActivity.this,SecondActivity.class);

        // (2) Intent 전송 => startActivity()
        startActivity(Clickintent);
    }
}