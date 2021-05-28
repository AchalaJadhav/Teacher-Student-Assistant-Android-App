package com.example.teacherstudentapp;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class Moodle_Webview extends AppCompatActivity {

    ProgressBar progress;
    ImageView image;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moodle__webview);

        progress = findViewById(R.id.progressBar);
        web = findViewById(R.id.webView);
        //image = findViewById(R.id.imageView);

        web.loadUrl("https://mahadbtmahait.gov.in/");

        web.getSettings().setJavaScriptEnabled(true);
        web.setWebChromeClient(new WebChromeClient());

    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack())
            web.goBack();
        else
            super.onBackPressed();
    }
}