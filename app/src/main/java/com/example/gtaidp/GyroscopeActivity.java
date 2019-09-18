package com.example.gtaidp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GyroscopeActivity extends AppCompatActivity {

    TextView heel,load,mid,terminal,swing;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        heel = findViewById(R.id.heel);
        load = findViewById(R.id.loading);
        mid = findViewById(R.id.mid);
        terminal =findViewById(R.id.terminal);
        swing = findViewById(R.id.swing);


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("UserInfo").child("Angle").child("Gyr");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                GyrInfo info = dataSnapshot.getValue(GyrInfo.class);
                heel.setText(info.getX());
                load.setText(info.getY());
                mid.setText(info.getZ());

                swing.setText(info.getX());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
