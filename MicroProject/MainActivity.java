package com.example.teacherstudentapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button teacher,student,jscoe,moodle;
    private static final int MY_REQUEST_CODE = 7117;
    List<AuthUI.IdpConfig> providers;

 //   ConstraintLayout constraintLayout;
 //   AnimationDrawable animationDrawable,animationDrawable2,animationDrawable3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        teacher = findViewById(R.id.btntlogin);
        student = findViewById(R.id.btnslogin);
        jscoe = findViewById(R.id.btn_jscoe);
  //      moodle = findViewById(R.id.btn_moodle);

        //     constraintLayout = findViewById(R.id.mainlayout);
        //    animationDrawable = (AnimationDrawable)constraintLayout.getBackground();
        //   animationDrawable2 = (AnimationDrawable)teacher.getBackground();
        //    animationDrawable3 = (AnimationDrawable)student.getBackground();
        //    animationDrawable2.setEnterFadeDuration(2000);
        //    animationDrawable3.setExitFadeDuration(2000);
        //    animationDrawable2.setEnterFadeDuration(2000);
        //    animationDrawable3.setExitFadeDuration(2000);
        //    animationDrawable.setEnterFadeDuration(2000);
        //    animationDrawable.setExitFadeDuration(2000);
        //    animationDrawable.start();

        checkConnection();

    }

    private void loginFunction(){
        providers = Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build()
                //    new AuthUI.IdpConfig.FacebookBuilder().setPermissions(Arrays.asList("default", "email")).build(),
        );

        showSignInOptions();
    }

    private void showSignInOptions() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).setTheme(R.style.MyTheme).build(),MY_REQUEST_CODE
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MY_REQUEST_CODE){
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Toast.makeText(this,""+user.getEmail(),Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(this,""+response.getError().getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }
    // Returns for checking internet connection
    public void checkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNectwork = connectivityManager.getActiveNetworkInfo();


        if(null!= activeNectwork) {
            if (activeNectwork.getType() == ConnectivityManager.TYPE_WIFI) {
                Toast.makeText(MainActivity.this, "Operating on Wifi", Toast.LENGTH_SHORT).show();

                teacher.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent mainToTLogin = new Intent(MainActivity.this, TeacherPage.class);
                        startActivity(mainToTLogin);
                        loginFunction();
                    }
                });

                student.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent mainToSLogin = new Intent(MainActivity.this, StudentPage.class);
                        startActivity(mainToSLogin);
                        loginFunction();

                    }
                });

                jscoe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(MainActivity.this, Jscoe_Site.class);
                        startActivity(i);
                    }
                });

            }
            else if (activeNectwork.getType() == ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(MainActivity.this, "Operating on Mobile Data", Toast.LENGTH_LONG).show();

                teacher.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent mainToTLogin = new Intent(MainActivity.this, TeacherPage.class);
                        startActivity(mainToTLogin);
                        loginFunction();
                    }
                });

                student.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent mainToSLogin = new Intent(MainActivity.this, StudentPage.class);
                        startActivity(mainToSLogin);
                        loginFunction();
                    }
                });

                jscoe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(MainActivity.this, Jscoe_Site.class);
                        startActivity(i);
                    }
                });


            }
        }else {
            Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
            teacher.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "You will need an INTERNET CONNECTION", Toast.LENGTH_LONG).show();
                }
            });
            student.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "You will need an INTERNET CONNECTION", Toast.LENGTH_LONG).show();
                }
            });
            jscoe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "You will need an INTERNET CONNECTION", Toast.LENGTH_LONG).show();
                }
            });

        }
    }
        public void onBackPressed() {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Exit")
                    .setMessage("Do you want to exit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }

}