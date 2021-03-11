package com.example.examevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.security.cert.CollectionCertStoreParameters;

public class MainActivity extends AppCompatActivity {

    // Member Variable
    private final String TAG = "ExamEvent";
    private Boolean D = true;

    private ConstraintLayout constraintLayout;
    private Button              leftbtn;
    private TextView            msg;
    private CheckBox            checkBox;
    private RadioGroup          radioGroup;
    private RadioButton         redRBTN,greenRBTN;


    // Member Method - Activity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 설정
        setContentView(R.layout.activity_main);

        // 초기화
        init();

        if(D) Log.i(TAG,"onCreate");
    }

    // Member Method - custom
    private void init() {
        //View 객체 가져오기
        leftbtn = findViewById(R.id.leftBTN);
        msg = findViewById(R.id.msgTXT);
        checkBox = findViewById(R.id.checkBox);
        redRBTN = findViewById(R.id.redRBTN);
        greenRBTN = findViewById(R.id.greenRBTN);
        radioGroup = findViewById(R.id.radioGroup);
        constraintLayout = findViewById(R.id.layout);

        // View 이벤트 리스너 설정
        leftbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"leftBTN - onClick");
            }
        });

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"msgTXT - onClick");
            }
        });

        leftbtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.i(TAG,"leftBTN - onLongClick");
                return true;
            }
        });

        // Check Box의 check를 눌렀을때 동작
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG,"CheckBox - Checkchange" + isChecked);
                constraintLayout.setBackgroundColor((isChecked) ? Color.LTGRAY : Color.WHITE);
                if(isChecked) constraintLayout.setBackgroundColor(Color.LTGRAY);
                else constraintLayout.setBackgroundColor(Color.WHITE);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i(TAG,"redioGroup - Checkchange" + ((RadioButton)findViewById(checkedId)).getText());

            }
        });

        redRBTN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG,"redRBTN - Checkchange" + buttonView.getText());
            }
        });
    }
}