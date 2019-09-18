package com.example.gtaidp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private TextView name,age,height,weight,email,out,username;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name    = (TextView)findViewById(R.id.profile_name);
        username = (TextView)findViewById(R.id.profile_username);
        age     = (TextView)findViewById(R.id.profile_age);
        email  = (TextView)findViewById(R.id.profile_email);
        weight  = (TextView)findViewById(R.id.profile_weight);
        //out = (TextView)findViewById(R.id.textOut);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("UserInfo").child("Patient").child(user.getUid());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                InputInfo info = dataSnapshot.getValue(InputInfo.class);
                name.setText(info.getName());
                //age.setText(info.getAge());
                username.setText(info.getUsername());
                email.setText(info.getEmail());
                //weight.setText(info.getWeight());
                //Toast.makeText(ProfileActivity.this, info.getEmail(),Toast.LENGTH_LONG).show();
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ProfileActivity.this, DashBoardActivity.class);
        startActivity(intent);
        finish();
    }
}
