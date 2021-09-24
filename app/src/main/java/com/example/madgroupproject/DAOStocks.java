package com.example.madgroupproject;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;
import java.util.Queue;

public class DAOStocks {


    private DatabaseReference databaseReference;
    public DAOStocks(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Stocks.class.getSimpleName());
    }

    //    Add method(throw data to database)
    public Task<Void> add(Stocks st){
        return databaseReference.push().setValue(st);
    }
}
