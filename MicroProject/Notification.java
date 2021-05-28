package com.example.teacherstudentapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Notification extends AppCompatActivity {
    TextView nmessage;
    Button btn_ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        nmessage = findViewById(R.id.notificationMessage);
        btn_ss = findViewById(R.id.screenshot);

        String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());

        nmessage.setText(date_n + "\n" + getIntent().getStringExtra(("myTitle")) + "\n" + getIntent().getStringExtra("myText"));
    }
}
