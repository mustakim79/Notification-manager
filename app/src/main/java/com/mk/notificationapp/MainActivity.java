package com.mk.notificationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    NotificationHelpers notif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notif=new NotificationHelpers(this);

    }
    public void sendNotif(View view) {
        String title="Great Sale",body="Sale on mobile 40% Hurry up !";
        EditText ed1=findViewById(R.id.editTextTextPersonName);
        EditText ed2=findViewById(R.id.editTextTextPersonName2);
        if(!ed1.getText().toString().equals(""))
        {
            title=ed1.getText().toString();
        }
        if(!ed2.getText().toString().equals(""))
        {
            body=ed2.getText().toString();
        }
        notif.sendNotificationuser(title,body,ShowNotificationuser.class);
    }

    public void send(View view) {
        Toast.makeText(this,"Hello ",Toast.LENGTH_SHORT).show();
    }
}