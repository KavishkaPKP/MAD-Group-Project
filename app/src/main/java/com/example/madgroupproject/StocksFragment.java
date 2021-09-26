package com.example.madgroupproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class StocksFragment extends Fragment {

    RecyclerView recview;
    MainAdapter1 mainAdapter1;
    FirebaseRecyclerOptions<Stocks> options;

    private String serialNumber;
    private String StockOwner;
    private String WarehouseLocation;
    private String InsideStock;
    private String Price;
    private String Quantity;


    public StocksFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stocks, container, false);

        recview = (RecyclerView) view.findViewById(R.id.recyStock);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Stocks> options =
                new FirebaseRecyclerOptions.Builder<Stocks>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Stocks"), Stocks.class)
                        .build();

        mainAdapter1 = new MainAdapter1(options);
        recview.setAdapter(mainAdapter1);
        Log.d("myTag", "");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mainAdapter1.startListening();
        Log.d("myTag", "");
    }

    @Override
    public void onStop() {
        super.onStop();
        mainAdapter1.stopListening();
    }
}