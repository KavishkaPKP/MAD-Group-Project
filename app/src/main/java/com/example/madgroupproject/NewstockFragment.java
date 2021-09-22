package com.example.madgroupproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class  NewstockFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_newstock, container, false);

        final EditText  serialNumber = v.findViewById(R.id.txtSerialNumber);
        final EditText  StockOwner = v.findViewById(R.id.txtStockOwner);
        final EditText  WarehouseLocation = v.findViewById(R.id.txtWarehouseLocation);
        final EditText  InsideStock= v.findViewById(R.id.txtInsideStock);
        final EditText  DiliverDate = v.findViewById(R.id.txtDiliverDate);
        DAOStocks dao = new DAOStocks();

        Button btn = v.findViewById(R.id.btnAddItem);
        btn.setOnClickListener(b->{

            Stocks st = new Stocks(serialNumber.getText().toString(),StockOwner.getText().toString(),WarehouseLocation.getText().toString(),InsideStock.getText().toString(),DiliverDate.getText().toString());
            dao.add(st).addOnSuccessListener(V-> {

                Toast.makeText(this,"Items added Successfully!", Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er->{

                Toast.makeText(this,""+er.getMessage(), Toast.LENGTH_SHORT).show();

            });

        });

        return v;


    }
}