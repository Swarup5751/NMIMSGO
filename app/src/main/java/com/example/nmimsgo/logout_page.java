package com.example.nmimsgo;

import android.content.Intent;
import android.os.Bundle;

import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class logout_page extends AppCompatActivity {

    private LinearLayout logoutButton, contactButton;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logout_page);

        auth = FirebaseAuth.getInstance();

        // Find the views by their correct IDs from XML
        contactButton = findViewById(R.id.button_terms);
        logoutButton = findViewById(R.id.button_contact);

        // Open Contact page on click
        contactButton.setOnClickListener(v -> {
            Intent intent = new Intent(logout_page.this, contact.class);
            startActivity(intent);
        });

        // Logout on click
        logoutButton.setOnClickListener(v -> {
            auth.signOut();
            Intent intent = new Intent(logout_page.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear backstack
            startActivity(intent);
            finish();
        });
    }
}
