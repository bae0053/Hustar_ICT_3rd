package com.example.test;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // 멤버 변수 선언-----------------
    // ------------------------------
    // Debug ------------------------
    private final static String TAG = "test_App";    // Log 출력 시 구분자

    // UI ---------------------------
    private LinearLayout changelay;
    private TextView BGtext;

    // ------------------------------
    // Control ----------------------
    private Random random = new Random();


    // ------------------------------
    // 멤버 메소드 -------------------
    // ------------------------------
    // AppcompatActivity's method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 사용자에게 보여지는 화면 설정정
        setContentView(R.layout.change_color);

        // 디버깅을 위한 로그 출력
        Log.i(TAG,"onCreate");

        // 간단한 메세지 출력
        Toast.makeText(MainActivity.this,"muyaho~~~",Toast.LENGTH_LONG).show();

        // UI 요소 객체 가져오기
        //joinlay = findViewById(R.id.JoinLay);
        //joinlay.setBackgroundColor(Color.LTGRAY);


    }

    // onClick 속성 지원 method 반드시 public 이어야 한다
    // UI 요소 중 onClick 속성을 설정한 경우 실행되는 method
    public void ClickFuc(View v) {

        changelay = findViewById(R.id.changelay);
        BGtext = findViewById(R.id.BGText);

        if (v.getId() == R.id.CancelButton) {
            Toast.makeText(MainActivity.this, "Cancel",Toast.LENGTH_LONG).show();
        }
        else if (v.getId() == R.id.OkButton) {
            Toast.makeText(MainActivity.this, "Join",Toast.LENGTH_LONG).show();
        }
        else if (v.getId() == R.id.bluebutton) {
            changelay.setBackgroundColor(Color.BLUE);
            BGtext.setVisibility(View.VISIBLE);
            BGtext.setText(R.string.blueBTN);
        }
        else if (v.getId() == R.id.greenbutton) {
            changelay.setBackgroundColor(Color.GREEN);
            BGtext.setVisibility(View.VISIBLE);
            BGtext.setText(R.string.GreenBYN);
        }
        else if (v.getId() == R.id.ranBTN) {
            changelay.setBackgroundColor(Color.rgb(random.nextInt(255),
                    random.nextInt(255),random.nextInt(255)));
            BGtext.setVisibility(View.INVISIBLE);
        }
    }
}