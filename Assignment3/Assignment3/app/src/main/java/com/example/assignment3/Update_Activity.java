package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Update_Activity extends AppCompatActivity {
    EditText etTitle;
    EditText etDescription;
    EditText etPrice;
    EditText etSale;
    EditText etType;
    Button btnUpdate;

    public Update_Activity(){


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_);
        etTitle=findViewById(R.id.etTitle);
        etDescription=findViewById(R.id.etDescription);
        etPrice=findViewById(R.id.etPrice);
        etSale=findViewById(R.id.etSale);
        etType=findViewById(R.id.etType);
        btnUpdate=findViewById(R.id.btnUpdate);

        int index=getIntent().getIntExtra("Index",1);
        Update(index);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=etTitle.getText().toString().trim();
                String desc=etDescription.getText().toString().trim();
                String  Sale= (etSale.getText().toString().trim());
                String Price= (etPrice.getText().toString().trim());
                String type=etType.getText().toString().trim();
                if(title.isEmpty()){
                    etTitle.setError("Error: This Field Can't be Empty");
                }
                else if(desc.isEmpty()){
                    etDescription.setError("Error: This Field Can't be Empty");
                }
                else if(type.isEmpty()){
                    etType.setError("Error: This Field Can't be Empty");
                }
                else if(Price.isEmpty()){
                    etPrice.setError("Error: This Field Can't be Empty");
                }
                else if(Sale.isEmpty()){
                    etSale.setError("Error: This Field Can't be Empty");
                }
                else{

                    Update_Org(index);


                    Intent intent=new Intent();
                    try {
                        FileOutputStream file = openFileOutput("Data.txt", MODE_PRIVATE);
                        OutputStreamWriter writeDataInFile = new OutputStreamWriter(file);
                        for (Product p:MyApplicationClass.people)
                        {
                            writeDataInFile.write(p.getTitle()+","+p.getDescription()+","+p.getType()+","+p.getPrice()+","+p.getSale()+"\n");
                        }
                        writeDataInFile.flush();
                        writeDataInFile.close();
                    }catch(IOException e)
                    {
                        Toast.makeText(Update_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    etTitle.setText("");
                    etPrice.setText("");
                    etSale.setText("");
                    etDescription.setText("");
                    etType.setText("");
                    setResult(RESULT_OK, intent);
                    Update_Activity.this.finish();
                }
            }
        });
    }
     public void  Update (int index) {
        etTitle.setText(MyApplicationClass.people.get(index).getTitle());
        etDescription.setText(MyApplicationClass.people.get(index).getDescription());
        etType.setText(MyApplicationClass.people.get(index).getType());
        etSale.setText(MyApplicationClass.people.get(index).getSale());
        etPrice.setText(MyApplicationClass.people.get(index).getPrice());
    }

    public void Update_Org(int index){
        MyApplicationClass.people.get(index).setTitle(etTitle.getText().toString());
        MyApplicationClass.people.get(index).setDescription(etDescription.getText().toString());
        MyApplicationClass.people.get(index).setType(etType.getText().toString());
        MyApplicationClass.people.get(index).setSale(etSale.getText().toString());
        MyApplicationClass.people.get(index).setPrice(etPrice.getText().toString());
    }
}