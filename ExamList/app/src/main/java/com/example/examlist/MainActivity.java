package com.example.examlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Member Variable
    private boolean                 D = true;
    private final String            TAG = "MainActivity";

    private ListView                datalist;

    // List 관련
    private ArrayList<String>       arrdatas = new ArrayList<>();
    private ArrayAdapter<String>    arrayAdapter;

    private EditText                nameEdit;

    private InputMethodManager      imm;


    // Member Method - Activity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init
        init();
        if(D) Log.i(TAG,"onCreate()");
    }


    // Member Method - Custom
    private void init() {
        datalist = findViewById(R.id.data_list);

        imm = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);

        nameEdit = findViewById(R.id.nameETXT);

        nameEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE)
                {
                    imm.hideSoftInputFromWindow(nameEdit.getWindowToken(),0);
                }
                return true;
            }
        });
        // List 생성
        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                arrdatas);
        // LintView에 List설정
        datalist.setAdapter(arrayAdapter);

        // List Item Click 설정
        datalist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, ((TextView)view).getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View v) {
        if(nameEdit.getText().length() != 0){
            arrdatas.add(nameEdit.getText().toString());
            datalist.setAdapter(arrayAdapter);
            nameEdit.setText("");
        }
    }
}