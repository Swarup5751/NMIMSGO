package com.example.nmimsgo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class splash_view extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge content
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_view);

        // Apply padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Delay and navigate to MainActivity
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(splash_view.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_DURATION);
    }
}
