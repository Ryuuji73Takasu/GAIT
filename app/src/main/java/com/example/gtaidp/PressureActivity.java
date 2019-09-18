package com.example.gtaidp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

public class PressureActivity extends AppCompatActivity {

    LinearLayout top,mid,midw,bot;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    String tt,mm,md,bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        top = findViewById(R.id.topp);
        mid = findViewById(R.id.mid);
        midw = findViewById(R.id.midw);
        bot = findViewById(R.id.ld);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("UserInfo").child("Pressure");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                PressureInfo info = dataSnapshot.getValue(PressureInfo.class);
              //  tt.setText(info.getTop());
                //age.setText(info.getAge());
                //mm.setText(info.getLeft());
                //md.setText(info.getRight());
                //bt.setText (info.getBottom());



              /*  if( tt >= 200){
                    top.setBackgroundColor(RED);
                }
                if( tt > 100 & tt<200){
                    top.setBackgroundColor(YELLOW);
                }
                if (tt>50 && tt<100 )
                {
                    top.setBackgroundColor(GREEN);
                }
                if( tt < 50 ){
                    top.setBackgroundColor(BLACK);
                }

                // Green = appropriate, black = low , red = high, yellow = marginal 
                */

            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }
}
