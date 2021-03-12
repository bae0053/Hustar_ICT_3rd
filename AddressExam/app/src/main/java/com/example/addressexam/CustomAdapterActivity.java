package com.example.addressexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapterActivity extends AppCompatActivity {

    // Member Variable
    private final String    TAG = "CustomAdapter";

    private ListView        dataList;
    private ArrayList<ItemData> dataArr;
    private ItemDataAdapter     adapter;


    // Member Method - Override
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    // Member Method - Custom
    private void init() {
        dataList = findViewById(R.id.addresslist);

        dataArr = new ArrayList<ItemData>();
        dataArr.add(new ItemData("test","123123123123","sadf@sadfsadf",R.drawable.penguin));
        dataArr.add(new ItemData("test","34523452345","sadf@21432153",R.drawable.shark));

        adapter = new ItemDataAdapter(CustomAdapterActivity.this,R.layout.address_list_layout,dataArr);
        dataList.setAdapter(adapter);

        dataList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomAdapterActivity.this, "OnItemClick - position : " + position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View v) {
        Log.i(TAG,"onClick()");
        switch (v.getId()) {
            case R.id.nameTXT :
            case R.id.phoneTXT :
            case R.id.emailTXT :
                Log.i(TAG,"TEXT : " + ((TextView)v).getText());
                break;
            case R.id.imageView :
                Log.i(TAG ," IMG ");
                break;
        }
    }
}