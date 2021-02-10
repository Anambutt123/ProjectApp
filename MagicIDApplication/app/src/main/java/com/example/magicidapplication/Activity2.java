package com.example.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tvWelcome = findViewById(R.id.tvWelcome);
        Intent intent = getIntent();
        Toast.makeText(this, tvWelcome.getText(), Toast.LENGTH_SHORT).show();
    }
}