package com.example.teacherstudentapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class TAssignmentActivity extends AppCompatActivity {
    EditText editPDFName;
    Button btn_upload,back;
    //to use dependency for linking to the app and as we including third party
    DatabaseReference databaseReference;
    StorageReference storageReference,assignmentFolder;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tassignment);

        editPDFName  = findViewById(R.id.txt_pdfName);
        btn_upload = findViewById(R.id.btn_fileuploader);
//        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads/Assignments/");
            storageReference = FirebaseStorage.getInstance().getReference();
   //         assignmentReference = storageReference.child("uploads");

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPDFFile();
            }
        });

    }


    private void selectPDFFile() {
        Intent i = new Intent();
        i.setType("application/pdf"); //priority is of pdf
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i,"Select PDF file"),1);
        //ceatechooser=file manager opens
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

                if(requestCode == 1 && resultCode == RESULT_OK && data!=null && data.getData()!=null ){
                    uploadPDFFile(data.getData());
                }
    }

    private void uploadPDFFile(final Uri data) {
        final ProgressDialog progressDialog =new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.show();

        //enables only pdf files
         assignmentFolder = storageReference.child("/uploads/Assignments/"+editPDFName.getText().toString()+".pdf");
        assignmentFolder.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri uri = uriTask.getResult();

                  uploadPDF uploadPDF = new uploadPDF(editPDFName.getText().toString(),uri.toString());
                  databaseReference.child(databaseReference.push().getKey()).setValue(uploadPDF);

                Toast.makeText(TAssignmentActivity.this,"File Uploaded Successfully",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int progress = (int) ((100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount());
                progressDialog.setMessage("Uploaded: "+progress+"%");
            }
        });
    }
}