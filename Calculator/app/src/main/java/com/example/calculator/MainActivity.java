package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    // 변수 선언
    private String calcul = "";
    private double result = 0.0;
    private TextView calculView;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void delClick(View v) {

        calculView = findViewById(R.id.Calcul);
        resultView = findViewById(R.id.result);

        calcul = "";
        result = 0.0;
        calculView.setText(calcul);
        resultView.setText(String.valueOf(result));

    }

    public void equlClick(View v) {

        calculView = findViewById(R.id.Calcul);
        resultView = findViewById(R.id.result);

        if(calcul.equals("")){
            return;
        }

        if (calcul.endsWith("+") || calcul.endsWith("-") || calcul.endsWith("*") || calcul.endsWith("/")) {
            Toast.makeText(MainActivity.this, "연산할 수 없습니다.", Toast.LENGTH_LONG).show();
            return;
        }
        StringTokenizer token = new StringTokenizer(calcul, "+-*/", true);

        result = calculate(infixtoPostfix(token));

        resultView.setText(String.valueOf(result));

    }

    public void ClickFunc(View v) {

        String str = "";
        Button button;
        int ID = v.getId();

        calculView = findViewById(R.id.Calcul);
        resultView = findViewById(R.id.result);

        button = findViewById(ID);
        if ((calcul.endsWith("+") || calcul.endsWith("-") ||
                calcul.endsWith("*") || calcul.endsWith("/")) &&
                ((ID == R.id.divideBTN || ID == R.id.minorBTN
                        || ID == R.id.mutiBTN || ID == R.id.plusBTN))) {
            Toast.makeText(MainActivity.this, "연산자는 중복할 수 없습니다.", Toast.LENGTH_LONG).show();
        } else if (calcul.endsWith("/") && ID == R.id.zeroBTN) {
            Toast.makeText(MainActivity.this, "0으로 나눌 수 없습니다.", Toast.LENGTH_LONG).show();
        } else if (calcul.equals("") && ((ID == R.id.divideBTN || ID == R.id.minorBTN ||
                ID == R.id.mutiBTN || ID == R.id.plusBTN))) {
            Toast.makeText(MainActivity.this, "연산자를 입력할 수 없습니다.", Toast.LENGTH_LONG).show();
        } else {
            str = (String) button.getText();
            calcul += str;
            calculView.setText(calcul);
        }
    }

    // 연산자의 가중치를 부여
    private int weight_oper(String str) {
        if (str.equals("*") || str.equals("/")) {
            return 2;
        } else if (str.equals("+") || str.equals("-")) {
            return 1;
        } else return 0;
    }

    // 중위식을 후위식으로 바꿔주는 메소드
    private String infixtoPostfix(StringTokenizer token) {

        Stack<String> stack = new Stack();
        String cur_token = "";
        String postFix = "";

        while (token.hasMoreTokens()) {

            cur_token = token.nextToken();

            if (cur_token.equals("+") || cur_token.equals("-")
                    || cur_token.equals("*") || cur_token.equals("/")) {

                while (!stack.empty() && weight_oper(stack.peek()) >= weight_oper(cur_token)) {
                    postFix += " ";
                    postFix += stack.pop();
                    Log.i("postFIX", postFix);
                }
                Log.i("postFIX", postFix);
                stack.push(cur_token);
            } else {
                postFix += " ";
                postFix += cur_token;
                Log.i("postFIX", postFix);
            }
        }

        while (!stack.empty()) {
            postFix += " ";
            postFix += stack.pop();
            Log.i("postFIX", postFix);
        }
        Log.i("postFIX", postFix);
        return postFix;
    }

    public double calculate(String inFix) {
        Stack<String> stack = new Stack();
        String cur_token = "";
        StringTokenizer cal_token = new StringTokenizer(inFix, " ", false);

        while (cal_token.hasMoreTokens()) {

            cur_token = cal_token.nextToken();
            Log.i("CUR_TOKEN", cur_token);
            if (cur_token.equals("+") || cur_token.equals("-")
                    || cur_token.equals("*") || cur_token.equals("/")) {

                double a = Double.parseDouble(stack.pop());
                double b = Double.parseDouble(stack.pop());

                if (cur_token.equals("+")) stack.push(String.valueOf(b + a));
                if (cur_token.equals("-")) stack.push(String.valueOf(b - a));
                if (cur_token.equals("*")) stack.push(String.valueOf(b * a));
                if (cur_token.equals("/")) stack.push(String.valueOf(b / a));
            } else {
                stack.push(cur_token);
            }
        }
        String result = stack.pop();
        Log.i("RESULT", result);
        return Double.parseDouble(result);
    }
}