package com.example.addressexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // 멤버 변수 선언
    private final String TAG = "MainActivity";

    // Data 관련
    private ArrayList<HashMap<String,String>> address_data = new ArrayList<>();

    // List 관련
    private ListView addresslist;
    private SimpleAdapter addressAdapter;

    // 입력 관련
    private EditText name_edit;
    private EditText phone_edit;
    private EditText email_edit;


    private int arr_idx = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // App이 실행되면 변수 초기화
        init();

    }

    // Member Method - Custom
    private void init() {
        name_edit = findViewById(R.id.edit_name);
        phone_edit = findViewById(R.id.edit_phone);
        email_edit = findViewById(R.id.edit_email);
        addresslist = findViewById(R.id.addresslist);

        // List 생성
        addressAdapter = new SimpleAdapter(this,
                                            address_data,
                                            R.layout.address_list_layout,
                                            new String[]{"name","phone","email"},
                                            new int[]{R.id.nameTXT,R.id.phoneTXT,R.id.emailTXT});

        // ListView에 List를 탑재
        addresslist.setAdapter(addressAdapter);

        addresslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG,"ItemClick");
            }
        });
    }

    // 버튼을 눌렀을 때 실행되는 메소드
    public void onClick(View v) {
        // 추가 버튼
        if(v.getId() == R.id.add_BTN) {
            if (email_edit.getText().toString().length() == 0 ||
                    name_edit.getText().toString().length() == 0 ||
                    phone_edit.getText().toString().length() == 0) {
                Toast.makeText(MainActivity.this,"내용을 입력해주세요", Toast.LENGTH_SHORT).show();
            }
            else {
                HashMap<String,String> map = new HashMap<>();
                map.put("name",name_edit.getText().toString());
                map.put("phone",phone_edit.getText().toString());
                map.put("email",email_edit.getText().toString());
                address_data.add(map);

                arr_idx = address_data.size() - 1;

                arr_idx++;

                name_edit.getText().clear();
                phone_edit.getText().clear();
                email_edit.getText().clear();

                Toast.makeText(MainActivity.this,"주소록에 추가되었습니다.", Toast.LENGTH_SHORT).show();
            }
        }
        // 보기 버튼
        else if(v.getId() == R.id.view_BTN) {
            if (address_data.size() == 0) {
                Toast.makeText(MainActivity.this,"주소록이 비었습니다.", Toast.LENGTH_SHORT).show();
            }
            else {
                if (arr_idx == address_data.size())
                {
                    arr_idx = 0;
                }
                arr_idx++;
            }
        }
        // 삭제 버튼
        else if(v.getId() == R.id.del_BTN) {
            if (address_data.size() == 0)
            {
                Toast.makeText(MainActivity.this,"주소록이 비었습니다.", Toast.LENGTH_SHORT).show();
            }
            else {
                address_data.remove(--arr_idx);
                arr_idx --;
                if (address_data.size() == 0) {
                    arr_idx = 0;
                }
                else {
                    if (arr_idx < 0) {
                        arr_idx = 0;
                    }
                    arr_idx++;
                }
            }
        }

        // List에 변경사항이 있으면 최신화
        addressAdapter.notifyDataSetChanged();
    }
}