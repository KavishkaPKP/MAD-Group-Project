package com.example.madgroupproject;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOStocks {


    private DatabaseReference databaseReference;
    public DAOStocks(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Stocks.class.getSimpleName());
    }

    public Task<Void> add(Stocks st){

//        throw exception
        return databaseReference.push().setValue(st);

    }

}
