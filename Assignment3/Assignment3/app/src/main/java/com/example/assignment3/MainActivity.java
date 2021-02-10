package com.example.assignment3;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class MainActivity extends AppCompatActivity implements Product_Adapter.ProductSelected {
    Button btnAdd;
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    ImageView ivRefresh;
    RecyclerView.LayoutManager layoutManager;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd=findViewById(R.id.btnAdd);
        ivRefresh=findViewById(R.id.ivRefresh);
        btnUpdate=findViewById(R.id.btnUpdate);
        recyclerView=findViewById(R.id.list);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        loadData();
        myAdapter=new Product_Adapter(this,MyApplicationClass.people);
        recyclerView.setAdapter(myAdapter);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                MyApplicationClass.people.remove(viewHolder.getAdapterPosition());

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
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                myAdapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(recyclerView);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Add_Product.class);
                startActivityForResult(intent,1);
            }
        });
        ivRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.notifyDataSetChanged();
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
               myAdapter.notifyDataSetChanged();

            }
        }
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                myAdapter.notifyDataSetChanged();

            }
        }
    }




    public void loadData()
    {
        MyApplicationClass.people.clear();
        File file = getApplicationContext().getFileStreamPath("Data.txt");
        String line;
        if(file.exists())
        {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("Data.txt")));
                while((line=reader.readLine())!=null)
                {
                    StringTokenizer tokens=new StringTokenizer(line, ",");
                    Product p = new Product(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), tokens.nextToken());
                    MyApplicationClass.people.add(p);

                }
            }catch (IOException e)
            {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Data.txt not exists", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void OnProductSelected(int index) {
        Intent intent=new Intent(MainActivity.this,Update_Activity.class);
        intent.putExtra("Index",index);
        startActivity(intent);
    }

    public void DatasetChanged(){
        myAdapter.notifyDataSetChanged();
    }

}