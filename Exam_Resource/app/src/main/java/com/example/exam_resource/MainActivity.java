package com.example.exam_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private LinearLayout linearLayout;
    private TextView msgTxt;
    private EditText msgETxt;

    // xml res 자원 접근 객체
    private Resources appRes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 객체 변수 초기화
        linearLayout = findViewById(R.id.linear);
        msgTxt = findViewById(R.id.msgText);
        msgETxt = findViewById(R.id.msgEditTXT);

        appRes = this.getResources();
    }

    public void onClick(View v) {
        // 클릭한 UI요소 객체가 인자로 넘어온다.
        if (v.getId() == R.id.linear) {
            msgTxt.setTextColor(Color.RED);
            msgTxt.setTextSize(30);
            String curTxt = msgETxt.getText().toString();


            // 입력 여부에 따라서 출력
            if(curTxt.length() > 0) {
                msgTxt.setText(curTxt);
            }
            else {
                //msgTxt.setText("Hou~");
                msgETxt.setText(appRes.getString(R.string.nothing));
            }
            Log.i(TAG,"curTxt =>"+curTxt);
        }
    }
}