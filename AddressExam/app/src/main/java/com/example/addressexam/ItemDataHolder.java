package com.example.addressexam;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


// ListView item 표시해주는 XML Layout --> Java Object 저장
public class ItemDataHolder {

    public ImageView    imageView;
    public TextView     nameTXTView;
    public TextView     phoneTXTView;
    public TextView     emailTXTView;

    public ItemDataHolder(View root) {

        this.imageView = root.findViewById(R.id.imageView);
        this.nameTXTView = root.findViewById(R.id.nameTXT);
        this.phoneTXTView = root.findViewById(R.id.phoneTXT);
        this.emailTXTView = root.findViewById(R.id.emailTXT);
    }
}
