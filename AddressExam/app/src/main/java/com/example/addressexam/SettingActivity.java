package com.example.addressexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    // Member Variable
    private final String TAG = "SAVE";

    private EditText            idETXT;
    private RadioGroup          ThemaRG;
    private RadioButton         whiteRBTN;
    private RadioButton         darkRBTN;
    private RadioButton         blueRBTN;
    private CheckBox            saveCheck;
    private CheckBox            connectCheck;

    private InputMethodManager  imm;

    private Boolean             enable = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Activity 화면 설정
        setContentView(R.layout.activity_setting);

        // Member Variable init
        init();


    }

    // Member Method - Custom


    private void init() {
        idETXT = findViewById(R.id.idETXT);
        idETXT.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    imm.hideSoftInputFromWindow(idETXT.getWindowToken(),0);
                }
                return true;
            }
        });

        ThemaRG = findViewById(R.id.themaR);
        whiteRBTN = findViewById(R.id.whiteRBTN);
        darkRBTN = findViewById(R.id.darkRBTN);
        blueRBTN = findViewById(R.id.blueRBTN);
        saveCheck = findViewById(R.id.autosave_check);
        connectCheck = findViewById(R.id.auto_connet_check);
        imm = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);
    }


    private void Enable(Boolean able) {
        whiteRBTN.setEnabled(able);
        darkRBTN.setEnabled(able);
        blueRBTN.setEnabled(able);
        connectCheck.setEnabled(able);
        saveCheck.setEnabled(able);
        idETXT.setEnabled(able);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.modifyBTN:
                enable = true;
                Enable(enable);
                break;
            case R.id.saveBTN:
                if(idETXT.getText().length() == 0){
                    Toast.makeText(SettingActivity.this,"ID를 입력하세요",Toast.LENGTH_SHORT).show();
                }
                else{
                    enable = false;
                    String Id = idETXT.getText().toString();
                    String Thema = ((RadioButton)findViewById(ThemaRG.getCheckedRadioButtonId())).getText().toString();
                    Boolean Auto_save = saveCheck.isChecked();
                    Boolean Auto_connect = connectCheck.isChecked();
                    Log.i(TAG,"ID : " + Id + "\n THEMA : " + Thema
                             + "\n AUTO SAVE : " + Auto_save + "\n AUTO CONNECT WIFI : " + Auto_connect);
                    Enable(enable);
                }
                break;
            case R.id.cancelBTN:
                if (enable) {
                    enable = false;
                    ThemaRG.clearCheck();
                    idETXT.setText("");
                    saveCheck.setChecked(false);
                    connectCheck.setChecked(false);
                    Enable(enable);
                }
                break;
            default:
                break;
        }
    }

}