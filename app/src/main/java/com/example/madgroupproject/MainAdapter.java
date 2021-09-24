package com.example.madgroupproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;


public class MainAdapter extends FirestoreRecyclerAdapter<Stocks, MainAdapter.myViewHolder> {

    public MainAdapter(@NonNull FirebaseRecyclerOptions<Stocks> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Stocks model) {

        holder.StockOwner.setText(model.getStockOwner());
        holder.WarehouseLocation.setText(model.getWarehouseLocation());

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.retreve_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView StockOwner;
        TextView WarehouseLocation;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            StockOwner = (TextView)itemView.findViewById(R.id.teStockOwner);
            WarehouseLocation = (TextView)itemView.findViewById(R.id.teWarehouseLocation);

        }
    }
}
