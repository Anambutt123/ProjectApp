package com.example.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    EditText etSurname;
    Button btnSubmitAct3;
    Button btnCancelAct3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        init();

        btnSubmitAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etSurname.getText().toString().trim();
                if(name.isEmpty())
                {
                    Toast.makeText(Activity3.this, "Enter surname", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    setResult(RESULT_OK,intent);
                    Activity3.this.finish();
                }
            }
        });

        btnCancelAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                Activity3.this.finish();
            }
        });

    }

    public void init()
    {
        etSurname = findViewById(R.id.etSurname);
        btnSubmitAct3 = findViewById(R.id.btnSubmitAct3);
        btnCancelAct3= findViewById(R.id.btnCancelAct3);
    }

}