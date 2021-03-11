package com.example.examevent;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class EventActivity extends AppCompatActivity {


    // Member Variable
    private final String TAG = "ExamEvent";
    private Boolean D = true;

    private Button              okBTN;
    private EditText            nameEdit;
    private InputMethodManager  IMM;

    // Member Method - Activity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 설정
        setContentView(R.layout.activity_event);

        // 초기화
        init();

        if(D) Log.i(TAG,"onCreate");
    }

    // Member Method - custom
    private void init() {
        //View 객체 가져오기
        okBTN = findViewById(R.id.okBTN);
        nameEdit = findViewById(R.id.nameETXT);

        IMM = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);

        nameEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(D) Log.i(TAG,"onEditorAction " + actionId );
                if(actionId == EditorInfo.IME_ACTION_DONE)
                {
                    IMM.hideSoftInputFromWindow(nameEdit.getWindowToken(),0);
                }
                return true;
            }
        });

        // View 이벤트 리스너 설정
    }

    // Member Method - XML onClick Method
    public void Click(View v) {
        // Softkeyboard 숨기기
        IMM.hideSoftInputFromWindow(nameEdit.getWindowToken(),0);
    }

    long init_time = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i(TAG, "key Down : " +  keyCode);

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if(System.currentTimeMillis() - init_time > 3000) {
                    Toast.makeText(EventActivity.this,"종료하려면 한 번 더 누르세요",Toast.LENGTH_SHORT).show();
                    init_time = System.currentTimeMillis();
                }
                else {
                    finish();
                }
                break;
            case KeyEvent.KEYCODE_HOME:
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "Touch Down ( " + event.getX()+", "+event.getY()+")");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "Touch Move ( " + event.getX()+", "+event.getY()+")");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "Touch UP ( " + event.getX()+", "+event.getY()+")");
                break;
            default:
        }

        return true;
    }
}