package com.example.madgroupproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class  NewstockFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_newstock, container, false);
        final EditText  serialNumber = v.findViewById(R.id.txtSerialNumber);
        final EditText  StockOwner = v.findViewById(R.id.txtStockOwner);
        final EditText  WarehouseLocation = v.findViewById(R.id.txtWarehouseLocation);
        final EditText  InsideStock= v.findViewById(R.id.txtInsideStock);
        final EditText  Price= v.findViewById(R.id.txtPrice);
        final EditText  Quantity= v.findViewById(R.id.txtQuantity);
        Button btn = v.findViewById(R.id.btnAddItem);
        DAOStocks dao = new DAOStocks();
        btn.setOnClickListener(b-> {
//            Add data to the Database
            Stocks st = new Stocks(serialNumber.getText().toString(), StockOwner.getText().toString(), WarehouseLocation.getText().toString(), InsideStock.getText().toString(), Price.getText().toString(), Quantity.getText().toString());
            dao.add(st).addOnSuccessListener(V -> Toast.makeText(this.getContext(), "Add To Recode Successfully", Toast.LENGTH_SHORT).show()).addOnFailureListener(er -> Toast.makeText(this.getContext(), "Faild-" + er.getMessage(), Toast.LENGTH_SHORT).show());

        });


        return v;
    }
}