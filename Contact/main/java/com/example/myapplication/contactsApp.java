package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class contactsApp extends AppCompatActivity {
    TextView etName;
    Button btAddContact;
    ImageButton btCall;
    ImageButton btLocation;
    ImageButton btWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_app);
        init();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");
        String email = intent.getStringExtra("email");
        String website = intent.getStringExtra("website");
        String degree = intent.getStringExtra("degree");
        etName.setText(name);
        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(intent);
            }
        });
        btWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + website));
                startActivity(intent);
            }
        });
        btLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=("+ address +")"));
                startActivity(intent);
            }
        });

    }
    public void init(){
        etName = findViewById(R.id.tvName);
        btAddContact = findViewById( R.id.btnAddContact);
        btCall = findViewById(R.id.btCall);
        btLocation = findViewById(R.id.btLocation);
        btWebsite = findViewById(R.id.btWebsite);
    }

}