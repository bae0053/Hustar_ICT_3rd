package com.example.addressexam;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemDataAdapter extends ArrayAdapter<ItemData> {
    // Member Variable
    private Context                 context;
    private int                     layoutResId;
    private ArrayList<ItemData>     DataList;

    // Constructor Method
    public ItemDataAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ItemData> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResId = resource;
        this.DataList = objects;
    }

    // Override Method
    // Data의 개수를 반환
    @Override
    public int getCount() {
        return DataList.size();
    }

    // 화면의 View를 그려주는 Method
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Data를 xml Layout에 넣어서 보이고 사용할 수 있도록 객체를 생성
        // (1) Item Layout xml ---> java 객체 변환 ( Layout 초기화 )
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layoutResId,null);

        // (2) Item Layout's View 객체 가져오기
        ImageView   imageView = convertView.findViewById(R.id.imageView);
        TextView    nameView = convertView.findViewById(R.id.name);
        TextView    nameTXTView = convertView.findViewById(R.id.nameTXT);
        TextView    phoneView = convertView.findViewById(R.id.phone);
        TextView    phoneTXTView = convertView.findViewById(R.id.phoneTXT);
        TextView    emailView = convertView.findViewById(R.id.email);
        TextView    emailTXTView = convertView.findViewById(R.id.emailTXT);

        // (3) Layout에 들어갈 Data 준비
        final ItemData    item = DataList.get(position);

        // (4) Layout <---> Data 연결
        nameTXTView.setText(item.getName());
        phoneTXTView.setText(item.getPhone());
        emailTXTView.setText(item.getEmail());

        // Image 크기를 동일하게 변환
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),item.getImgResId());
        bitmap = bitmap.createScaledBitmap(bitmap, 200, 200, true);
        imageView.setImageBitmap(bitmap);

        return convertView;
    }
}
