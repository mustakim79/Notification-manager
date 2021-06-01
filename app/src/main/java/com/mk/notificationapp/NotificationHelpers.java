package com.mk.notificationapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Random;

public class NotificationHelpers extends ContextWrapper {
    private static final String CHANNEL_NAME="My channel";
    private static final String CHANNEL_ID="com.mk.notificationapp"+CHANNEL_NAME;
    public NotificationHelpers(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannels();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannels() {
        NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationChannel.setLightColor(Color.RED);
        notificationChannel.setDescription("This is description of channel");
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

        NotificationManager manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.createNotificationChannel(notificationChannel);
    }
    public void sendNotificationuser(String title,String body,Class Activityname) {
        Intent i =new Intent(this,Activityname);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.putExtra("msg","You have entered by notification");
        PendingIntent pi=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setStyle(new NotificationCompat.BigTextStyle().setSummaryText("Summary").setBigContentTitle(title).bigText(body))
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();
        NotificationManagerCompat.from(this).notify(new Random().nextInt(),notification);
    }
}
