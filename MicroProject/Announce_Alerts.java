package com.example.teacherstudentapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Announce_Alerts extends AppCompatActivity {
    Button notifi;
    EditText mtitle, mmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announce__alerts);

        notifi = findViewById(R.id.sendNotification);
        mtitle = findViewById(R.id.title);
        mmessage = findViewById(R.id.message);

        notifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = mtitle.getText().toString();
                String message = mmessage.getText().toString();

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel channel = new NotificationChannel("myNotification", "myNotification",
                            NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager manager = getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);
                }

                Intent intent = new Intent(Announce_Alerts.this,Notification.class);
                intent.putExtra("myText",message);
                intent.putExtra("myTitle",title);
                PendingIntent pendingIntent = PendingIntent.getActivity(Announce_Alerts.this,1,intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(Announce_Alerts.this,"myNotification")
                        .setSmallIcon(R.drawable.ic_message)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);

                NotificationManagerCompat manager = NotificationManagerCompat.from(Announce_Alerts.this);
                manager.notify(999,builder.build());




            }
        });



    }
}
