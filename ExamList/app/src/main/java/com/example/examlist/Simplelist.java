package com.example.examlist;

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
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Simplelist extends AppCompatActivity {

    // Member Variable
    private boolean                 D = true;
    private final String            TAG = "Simplelist";

    private ListView                datalist;

    // List 관련
    private ArrayList<HashMap<String,String>> arrdatas = new ArrayList<>();
    private SimpleAdapter           simpleAdapter;


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
        arrdatas = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();

        map.put("name","hong");
        map.put("area","Daegu");
        arrdatas.add(map);

        // List 생성
        simpleAdapter = new SimpleAdapter(this,
                                            arrdatas,
                                            R.layout.simple_list_layout,
                                            new String[]{"name","area"},
                                            new int[]{R.id.text1,R.id.text2});
        // LintView에 List설정
        datalist.setAdapter(simpleAdapter);

        // List Item Click 설정
        datalist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Simplelist.this, ((TextView) view.findViewById(R.id.text1)).getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }


}