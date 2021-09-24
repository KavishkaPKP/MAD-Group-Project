package com.example.madgroupproject;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class MainAdapter1 extends FirebaseRecyclerAdapter<Stocks,MainAdapter1.myViewHolder> {


    public MainAdapter1(@NonNull FirebaseRecyclerOptions options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Stocks model) {
        holder.StockOwner.setText(model.getStockOwner());
        holder.WarehouseLocation.setText(model.getWarehouseLocation());
        Log.d("myTag", "");
        Log.d("myTag", model.getStockOwner());
    }


    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.retreve_item,parent,false);
        return new MainAdapter1.myViewHolder(view);
    }
    class myViewHolder extends RecyclerView.ViewHolder{

        TextView StockOwner;
        TextView WarehouseLocation;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d("myTag", "");

            StockOwner = (TextView)itemView.findViewById(R.id.teStockOwner);
            WarehouseLocation = (TextView)itemView.findViewById(R.id.teWarehouseLocation);

        }

    }
}
