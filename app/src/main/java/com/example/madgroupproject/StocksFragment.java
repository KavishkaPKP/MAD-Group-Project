package com.example.madgroupproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class StocksFragment extends Fragment {

    private RecyclerView recyclerView;
    MainAdapter mainAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View i= inflater.inflate(R.layout.fragment_stocks, container, false);

        recyclerView = i.findViewById(R.id.recyStock);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());

        FirebaseRecyclerOptions<Stocks> options =
                new FirebaseRecyclerOptions.Builder<Stocks>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Stocks"), Stocks.class)
                        .build();


        mainAdapter  = new MainAdapter(options);
        recyclerView.setAdapter(mainAdapter);


        return i;
    }
}