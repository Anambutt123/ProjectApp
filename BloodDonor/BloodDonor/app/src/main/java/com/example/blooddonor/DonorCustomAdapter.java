package com.example.blooddonor;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class DonorCustomAdapter extends RecyclerView.Adapter<DonorCustomAdapter.viewHolder> {

    Activity activity;
    ArrayList<Donor> donorArrayList;
    public static Donor donor;
    public static int pos;


    public DonorCustomAdapter(Activity activity, ArrayList<Donor> donorArrayList) {
        this.activity = activity;
        this.donorArrayList = donorArrayList;
        donor = new Donor();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       View view = layoutInflater.inflate(R.layout.datalist,parent,false);
        RecyclerView.ViewHolder  viewHolder= new viewHolder(view);
       return (DonorCustomAdapter.viewHolder) viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        String name = donorArrayList.get(position).getName();
        String number = donorArrayList.get(position).getNumber();


        holder.name_txt.setText(name);
        holder.number_txt.setText(number);
        holder.address_txt.setText( donorArrayList.get(position).getAddress());
        holder.bloodgrouptxt.setText( donorArrayList.get(position).getBgroup());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donor = donorArrayList.get(position);
                Log.d("donaraa",donor.getName());
                MainActivity.viewPager.setCurrentItem(1);
                pos = position;




            }
        });

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+ donorArrayList.get(position).getNumber()));
                activity.startActivity(intent);
            }
        });

        holder.location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "http://maps.google.com/maps?saddr=" + "28.30000" + "," + 78.666 + "&daddr=" + 78.6655 + "," + "78.65564";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return donorArrayList.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder{

       TextView name_txt, number_txt, address_txt, bloodgrouptxt;
        CardView cardView;
        ImageView call,location;

       public viewHolder(@NonNull View itemView) {
           super(itemView);
           name_txt = itemView.findViewById(R.id.name_txt);
           number_txt = itemView.findViewById(R.id.number_txt);
           bloodgrouptxt = itemView.findViewById(R.id.Donorgroup);
           address_txt = itemView.findViewById(R.id.address_txt);
           location = itemView.findViewById(R.id.location);
           call = itemView.findViewById(R.id.person_call);
           cardView = itemView.findViewById(R.id.datalist_card);

       }
   }

}
