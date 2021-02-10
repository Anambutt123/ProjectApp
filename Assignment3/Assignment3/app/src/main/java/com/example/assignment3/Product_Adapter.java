package com.example.assignment3;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Product_Adapter extends  RecyclerView.Adapter<Product_Adapter.ViewHolder> implements View.OnLongClickListener{
    static ArrayList<Product> people;
    int i;

    Context context;
    ProductSelected activity ;
    public interface ProductSelected{
        public void OnProductSelected(int index);
    }

    public Product_Adapter(Context context,ArrayList<Product> list){
        people=list;
        this.context=context;
        activity=(ProductSelected)context;
    }

    @Override
    public boolean onLongClick(View v) {
        i=people.indexOf((Product)v.getTag());
        String name= people.get(i).getTitle();
        people.remove(i);
        notifyItemRemoved(i);
        return true;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvDescription;
        ImageView ivStatus;
        ImageView  ivType;
        TextView tvPrice;
        TextView tvTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescription=itemView.findViewById(R.id.tvDescription);
            ivType=itemView.findViewById(R.id.ivType);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            ivStatus=itemView.findViewById(R.id.ivStatus);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i=people.indexOf((Product) itemView.getTag());
                    activity.OnProductSelected(i);

                }
            });
        }
    }
    @NonNull
    @Override
    public Product_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull Product_Adapter.ViewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));
        holder.tvPrice.setText(people.get(position).getPrice());
        holder.tvDescription.setText(people.get(position).getDescription());
        holder.tvTitle.setText(people.get(position).getTitle());


        String status=people.get(position).getSale();
        if(status.equals("Sold")){
            holder.ivStatus.setImageResource(R.drawable.on_sale_big);
        }
        else {
            holder.ivStatus.setImageResource(R.drawable.best_price);
        }
        String type=people.get(position).getType();
        if(type.equals("LAPTOP")) {
            holder.ivType.setImageResource(R.drawable.laptop);
        }
        else if(type.equals("USB")){
            holder.ivType.setImageResource(R.drawable.memory);
        }
        else if(type.equals("HDD")){
            holder.ivType.setImageResource(R.drawable.hdd);
        }
        else if(type.equals("SCREEN")){
            holder.ivType.setImageResource(R.drawable.screen);
        }
    }
    @Override
    public int getItemCount() {
        return people.size();
    }

}




