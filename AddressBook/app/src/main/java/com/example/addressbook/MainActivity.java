package com.example.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Member Variable
    private final Boolean D = true;
    private final String TAG = "MainActivity";

    // View Object
    private EditText    nameETXT, phoneETXT, emailETXT;
    private TextView    addressTXT;

    // Data
    private ArrayList<Address> addresseList = new ArrayList<>();

    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Activity 화면 설정
        setContentView(R.layout.activity_main);

        //xml View 객체 가져오기
        nameETXT = findViewById(R.id.editTextTextPersonName);
        phoneETXT = findViewById(R.id.editphone);
        emailETXT = findViewById(R.id.editemail);
        addressTXT = findViewById(R.id.addresstxt);
    }

    public void click(View v) {
        switch (v.getId()) {
            case R.id.addBTN :
                // 3개의 EditText 값 읽어서 Address 객체 생성 및 추가
                // (1) 3개의 EditText 값 입력 여부 체크
                if(nameETXT.getText().length() > 0 && phoneETXT.getText().length() > 0 && emailETXT.getText().length() > 0)
                {
                    // (2-1) Address 객체 생성 및 ArrayList 추가
                    addresseList.add(new Address(nameETXT.getText().toString(),
                            phoneETXT.getText().toString(), emailETXT.getText().toString()));

                    // (3) 3개의 EditText 초기화(지우기)
                    EditClear();

                    // (4) TextView에 Data 출력
                    Display();

                    Log.i(TAG,"add => " + addresseList.size());
                }
                else {
                    // (2-2) 사용자에게 알림 띄우기
                    Toast.makeText(MainActivity.this,R.string.add_msg, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.delBTN :
                // 모두 삭제 또는 가장 최근에 추가한 데이터 삭제
                if(addresseList.size() > 0) {
                    int lastIdx = addresseList.size()-1;
                    addresseList.remove(lastIdx);

                    // TextView에 데이터 출력
                    Display();
                }
                else {
                    Toast.makeText(MainActivity.this,R.string.del_msg, Toast.LENGTH_SHORT).show();

                }

                break;

            default:
                break;

        }

    }

    // Member Method - Custom

    // 3개의 EditText 초기화
    private void EditClear() {
        nameETXT.setText("");
        phoneETXT.setText("");
        emailETXT.setText("");
    }

    // TextView에 Data를 출력
    private void Display() {
        String datas = "";
        for(int i =0; i< addresseList.size();i++) {
            datas+=addresseList.get(i).getInfo() + "\n";
        }
        if (datas.length() > 0) {
            addressTXT.setText(datas);
        }
        else {
            addressTXT.setText(R.string.nothing);
        }
    }
}