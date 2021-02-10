package com.example.blooddonor;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;



import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {


    DonorItem [] myDonorItems;
   // DonorItem[] context;
    private Context context;
    public MainAdapter(DonorItem[]myDonorItems,DonorList donorList){

        this.myDonorItems = myDonorItems;
       // this.context = myDonorItems;

   }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       View view = layoutInflater.inflate(R.layout.datalist,parent,false);
        RecyclerView.ViewHolder  viewHolder= new viewHolder(view);
       return (MainAdapter.viewHolder) viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final DonorItem myDonordataList = myDonorItems[position];
        holder.name_txt.setText(myDonordataList.getDonorName());
        holder.number_txt.setText(myDonordataList.getDonorNumber());

    }

    @Override
    public int getItemCount() {
        return myDonorItems.length;
    }

    public  class viewHolder extends RecyclerView.ViewHolder{

       TextView name_txt, number_txt;


       public viewHolder(@NonNull View itemView) {
           super(itemView);
           name_txt = itemView.findViewById(R.id.name_txt);
           number_txt = itemView.findViewById(R.id.number_txt);
          itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                 /* //Intent intent= new Intent(context, DonorInfo.class);
                  intent.putExtra("Name", name_txt.getText().toString());
                  context.startActivity(intent);
*/
              }
          });
       }
   }

}
