package com.example.madgroupproject;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainAdapter1 extends FirebaseRecyclerAdapter<Stocks,MainAdapter1.myViewHolder> {


    public MainAdapter1(@NonNull FirebaseRecyclerOptions options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull Stocks model) {
        holder.StockOwner.setText(model.getStockOwner());
        holder.WarehouseLocation.setText(model.getWarehouseLocation());
        Log.d("myTag", "");
        Log.d("myTag", model.getStockOwner());

//update data to the database

        holder.btnStockEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.StockOwner.getContext() )
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1200)
                        .create();



                View view = dialogPlus.getHolderView();

                EditText price = view.findViewById(R.id.txtPrice);
                EditText WarehouseLocation = view.findViewById(R.id.txtWarehouseLocation);
                EditText StockOwner = view.findViewById(R.id.txtStockOwner);

                Button btnUpdate = view.findViewById(R.id.btnUpdate);

                price.setText(model.getPrice());
                WarehouseLocation.setText(model.getWarehouseLocation());
                StockOwner.setText(model.getStockOwner());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Map<String,Object> map =new  HashMap<>();
                        map.put("price",price.getText().toString());
                        map.put("warehouseLocation",WarehouseLocation.getText().toString());
                        map.put("stockOwner",StockOwner.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Stocks")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {

                                        Toast.makeText(holder.StockOwner.getContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                        
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(holder.StockOwner.getContext(), "Error While Updating.", Toast.LENGTH_SHORT).show();
                                dialogPlus.dismiss();
                            }
                        });
                    }
                });
            }
        });



//        delete function
        holder.btnStockRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.StockOwner.getContext());
                builder.setTitle("Are You Sure.remove this Stock details?");
                builder.setMessage("Deleted data can`t be Undo");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        FirebaseDatabase.getInstance().getReference().child("Stocks")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.StockOwner.getContext(), "Cancel by User", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });


    }

//    View function

    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.retreve_item,parent,false);
        return new MainAdapter1.myViewHolder(view);
    }
    class myViewHolder extends RecyclerView.ViewHolder{

        TextView StockOwner;
        TextView WarehouseLocation;


        Button btnStockEdit;
        Button btnStockRemove;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d("myTag", "");

            StockOwner = (TextView)itemView.findViewById(R.id.teStockOwner);
            WarehouseLocation = (TextView)itemView.findViewById(R.id.teWarehouseLocation);

            btnStockEdit = (Button)itemView.findViewById(R.id.btnStockEdit);
            btnStockRemove = (Button)itemView.findViewById(R.id.btnStockRemove);
        }

    }
}
