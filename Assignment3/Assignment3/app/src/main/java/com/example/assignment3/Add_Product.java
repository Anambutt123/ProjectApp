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
public class Add_Product extends AppCompatActivity  {
EditText etTitle;
EditText etDescription;
EditText etPrice;
EditText etSale;
EditText etType;
Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__product);
        etTitle=findViewById(R.id.etTitle);
        etDescription=findViewById(R.id.etDescription);
        etPrice=findViewById(R.id.etPrice);
        etSale=findViewById(R.id.etSale);
        etType=findViewById(R.id.etType);
        btnAdd=findViewById(R.id.btnAdd);

    btnAdd.setOnClickListener(new View.OnClickListener() {
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
                Intent intent=new Intent();
                MyApplicationClass.people.add(new Product(title,desc,type, Price,Sale));
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
                    Toast.makeText(Add_Product.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                etTitle.setText("");
                etPrice.setText("");
                etSale.setText("");
                etDescription.setText("");
                etType.setText("");
                setResult(RESULT_OK, intent);
                Add_Product.this.finish();
            }
        }
    });
    }


}