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


public class NewstockFragment extends Fragment {

    private EditText editText;
    private ImageView imageView;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_newstock, container, false);


        editText = v.findViewById(R.id.txtSerialNumber);
        editText = v.findViewById(R.id.txtStockOwner);
        editText = v.findViewById(R.id.txtWarehouseLocation);
        editText = v.findViewById(R.id.txtInsideStock);


        button = v.findViewById(R.id.btnAddItem);

        return v;


    }
}