package com.example.gtaidp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class VisualActivity extends AppCompatActivity {

    RelativeLayout pressure,gyroscope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visual);

        pressure = findViewById(R.id.press);
        gyroscope = findViewById(R.id.gyr);

        pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VisualActivity.this, PressureActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
