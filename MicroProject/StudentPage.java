package com.example.teacherstudentapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

import java.util.Arrays;
import java.util.List;


public class StudentPage extends AppCompatActivity {

    Button sout;
    private static final int MY_REQUEST_CODE = 7117;
    List<AuthUI.IdpConfig> providers;
    ListView listView;
    String mTitle[] = {"Assignments","Notes","C Quiz","C++ Quiz","Java Quiz"};
    String mDescription[] = {"Assignment Description","Notes Description","Play C Quiz",
            "Play C++ Quiz","Play Java Quiz"};
    int image[] = {R.drawable.assignment,R.drawable.index,R.drawable.c_logo,R.drawable.cpp,R.drawable.java};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherpage);



        listView = findViewById(R.id.listview);
        sout = findViewById(R.id.signout);
        sout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AuthUI.getInstance()
                        .signOut(StudentPage.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                finish();
                                Intent i = new Intent(StudentPage.this,MainActivity.class);
                                startActivity(i);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StudentPage.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, image);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(StudentPage.this, "Assignment Description", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),SAssignmentActivity.class);
                    startActivity(i);
                }
                if (position ==  1) {
                    Toast.makeText(StudentPage.this, "Notes Description", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),SNotesActivity.class);
                    startActivity(i);
                }
                if (position ==  2) {
                    Toast.makeText(StudentPage.this, "Play C Quiz", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),C_Quiz.class);
                    startActivity(i);
                }
                if (position ==  3) {
                    Toast.makeText(StudentPage.this, "Play C++ Quiz", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),CPP_Quiz.class);
                    startActivity(i);
                }
                if (position ==  4) {
                    Toast.makeText(StudentPage.this, "Play Java Quiz", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),Student_Quiz.class);
                    startActivity(i);
                }

            }
        });
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

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]){
            super(c,R.layout.row2, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row2 = layoutInflater.inflate(R.layout.row2,parent,false);
            ImageView images = row2.findViewById(R.id.image);
            TextView myTitle = row2.findViewById(R.id.textView1);
            TextView myDescription = row2.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row2;
        }
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Logout")
                .setMessage("Are you sure you want to Logout?")
                .setPositiveButton("Yes, Log me out", new DialogInterface.OnClickListener()
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
