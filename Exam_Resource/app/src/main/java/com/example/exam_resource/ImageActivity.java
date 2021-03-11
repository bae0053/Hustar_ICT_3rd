package com.example.exam_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    // 멤버 변수 선언
    private ImageView myIMG;
    private Resources myres;
    private int imgId[] = {R.drawable.applesample,
            R.drawable.grapesample, R.drawable.lemonsample,
            R.drawable.orangesample, R.drawable.pineapplesample};
    private int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);


        myIMG = findViewById(R.id.LemonImage);
        myres = this.getResources();
    }

    public void onClick(View v) {
        if (v.getId() == R.id.changeBTN) {

            // 클릭할 때마다 이미지를 변경

            myIMG.setImageDrawable(myres.getDrawable(imgId[index]));

            // 삼항연산자로 하는 방법
            //index = (index == (imgId.length-1)) ? 0 : index++;

            if (index == (imgId.length - 1)) {
                index = 0;
            } else {
                index++;
            }
            /*switch ((int)(Math.random() *5)){
                case 0:
                    myIMG.setImageResource(R.drawable.applesample);
                    break;
                case 1:
                    myIMG.setImageResource(R.drawable.grapesample);
                    break;
                case 2:
                    myIMG.setImageResource(R.drawable.lemonsample);
                    break;
                case 3:
                    myIMG.setImageResource(R.drawable.orangesample);
                    break;
                case 4:
                    myIMG.setImageResource(R.drawable.pineapplesample);
                    break;
                default:
                    break;
            }*/
        }
    }
}