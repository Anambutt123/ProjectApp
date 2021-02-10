package com.example.assignment3;

import android.app.Application;

import java.util.ArrayList;

public class MyApplicationClass extends Application {
    public static ArrayList<Product> people;
    @Override
    public void onCreate() {
        super.onCreate();
        people=new ArrayList<>();
        people.add(new Product("Dell 3500T ","Heavy Ha Yaar","LAPTOP","537.3","false"));
    }
}
