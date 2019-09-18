package com.example.gtaidp;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText name,age,height,weight,email,password,username;
    private String Sname,Sage,Sgender,Sheight,Sweight,Semail,Spassword,Susername;
    private Button registerButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name    = (EditText)findViewById(R.id.Name);
        age     = (EditText)findViewById(R.id.Age);
        username  = (EditText)findViewById(R.id.UserName);
        weight  = (EditText)findViewById(R.id.Weight);
        email   = (EditText)findViewById(R.id.Email);
        password = (EditText)findViewById(R.id.Password);
        registerButton = (Button)findViewById(R.id.button5);

        mAuth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllInputData();
                createNewUser();
            }
        });

    }

    public void getAllInputData(){

        Sname = name.getText().toString();
        Sage = age.getText().toString();
        Susername = username.getText().toString();
        Sweight = weight.getText().toString();
        Spassword = password.getText().toString();
        Semail = email.getText().toString();

    }
    public void createNewUser(){
        mAuth.createUserWithEmailAndPassword(Semail, Spassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            InputInfo info = new InputInfo(Susername,Sname,Sage,Sweight,Semail,Spassword);
                            FirebaseUser user = mAuth.getCurrentUser();
                            DatabaseReference refdatabase = FirebaseDatabase.getInstance().getReference("UserInfo");
                            refdatabase.child(user.getUid()).setValue(info);
                            Intent intent = new Intent(RegisterActivity.this, ProfileActivity.class);
                            startActivity(intent);
                            finish();


                        } else {
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, ProfileActivity.class);
                            startActivity(intent);
                        }


                    }
                });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
