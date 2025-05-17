package com.example.nmimsgo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Handle insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find views by ID
        LinearLayout buttonRouteFinder = findViewById(R.id.button_route_finder);
        LinearLayout buttonMaps = findViewById(R.id.button_maps);
        LinearLayout buttonWeather = findViewById(R.id.button_inbox);
        LinearLayout buttonsetting = findViewById(R.id.button_settings);
        LinearLayout buttonss = findViewById(R.id.button_traffic);
        LinearLayout buttonmess = findViewById(R.id.button_mess);

        // Set click listeners
        buttonRouteFinder.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity_2.class);
            startActivity(intent);
        });

        buttonMaps.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MapViewActivity.class);
            startActivity(intent);
        });

        buttonWeather.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, weather.class);
            startActivity(intent);
        });

        buttonsetting.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, logout_page.class);
            startActivity(intent);
        });

        buttonmess.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MessActivity.class);
            startActivity(intent);
        });

        buttonss.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Weatheractivity.class);
            startActivity(intent);
        });
    }
}