package com.mk.notificationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowNotificationuser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notificationuser);
        TextView tv=findViewById(R.id.textView2);
        Intent i=new Intent();
        String msg=i.getStringExtra("msg");
        tv.setText(msg);
    }
}