package com.example.nmimsgo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity_2 extends AppCompatActivity {
    Button b1;
    Spinner spinnerStart, spinnerEnd;
    FloatingActionButton b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        // Initialize UI components
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.floatingActionButton);
        spinnerStart = findViewById(R.id.spinner2);
        spinnerEnd = findViewById(R.id.spinner3);

        // Define locations
        String[] points = {
                "Nmims_Main_Gate",
                "Academic_Building",
                "Girl_Hostel",
                "Old_Boys_Hostel",
                "New_Boys_Hostel"
        };

        // Set adapters for spinners
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                points
        );
        spinnerStart.setAdapter(adapter);
        spinnerEnd.setAdapter(adapter);

        // Button click listener
        b1.setOnClickListener(v -> {
            String start = spinnerStart.getSelectedItem().toString();
            String end = spinnerEnd.getSelectedItem().toString();
            if (!start.equals(end)) {
                Intent intent = new Intent(this, MainActivity_1.class);
                intent.putExtra("start_location", start);
                intent.putExtra("end_location", end);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Start and End points cannot be the same", Toast.LENGTH_SHORT).show();
            }

        });
        b2.setOnClickListener(v -> {
            Intent intentq = new Intent(MainActivity_2.this, MainActivity.class);
            startActivity(intentq);
        });

    }
}