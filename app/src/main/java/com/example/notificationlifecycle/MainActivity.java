package com.example.notificationlifecycle;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private CharSequence title = "MY NOTIFICATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreateNotification("OnCreate : ", 1);

    }

    public void CreateNotification(String s, int id) {

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder)
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle(title)
                                .setContentText(s);

        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(id, mBuilder.build());
    }

    @Override
    protected void onStart() {
        super.onStart();
        CreateNotification("OnStart", 2);
    }

    @Override
    protected void onResume() {
        super.onResume();

        CreateNotification("OnResume : ", 3);
    }

    @Override
    protected void onPause() {
        super.onPause();

        CreateNotification("OnPause : ", 4);
    }

    @Override
    protected void onStop() {
        super.onStop();
        CreateNotification("OnStop : ", 5);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CreateNotification("OnDestroy :", 6);
    }
}
