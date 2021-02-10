package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addContact extends AppCompatActivity {
    EditText etName;
    EditText etAddress;
    EditText etNumber;

    EditText etWebsite;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        init();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String phone = etNumber.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                String website = etWebsite.getText().toString().trim();




                if (name.isEmpty()&&phone.isEmpty()&&address.isEmpty()&&website.isEmpty()) {
                    Toast.makeText(addContact.this, "Error: Field is Empty", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(addContact.this, contactsApp.class);
                    intent.putExtra("name", name);
                    intent.putExtra("phone", phone);
                    intent.putExtra("address", address);
                    intent.putExtra("website", website);
                    startActivity(intent);
                }
            }
        });
    }
    public void init(){
        etName= findViewById(R.id.etName);
        etAddress= findViewById(R.id.etAddress);
        etNumber = findViewById(R.id.etNumber);
        etWebsite = findViewById(R.id.etWebsite);
        btnSubmit = findViewById(R.id.btnSubmit);
    }
}