package com.example.nmimsgo;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class contact extends AppCompatActivity {

    private TextView phoneTextView, emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        phoneTextView = findViewById(R.id.call);
        emailTextView = findViewById(R.id.feedback);

        Linkify.addLinks(phoneTextView, Linkify.PHONE_NUMBERS);
        Linkify.addLinks(emailTextView, Linkify.EMAIL_ADDRESSES);
    }
}
