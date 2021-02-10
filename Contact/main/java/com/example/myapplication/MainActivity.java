package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnContacts;
    Button btnAddContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, contactsApp.class);
                startActivity(intent);

            }
        });
        btnAddContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, addContact.class);
                startActivity(intent);
            }
        });
    }
    public void init(){
        btnContacts = findViewById(R.id.btnContact);
        btnAddContacts = findViewById(R.id.btnAddContact);
    }
}