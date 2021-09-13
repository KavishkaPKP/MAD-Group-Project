package com.example.madgroupproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity  implements View.OnClickListener{

    private boolean exit = false;
    public CardView inventory,warehouse,suppliers,settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //action bar hide onli this screen
        getSupportActionBar().hide();

        inventory = (CardView) findViewById(R.id.inventory);
        warehouse = (CardView) findViewById(R.id.warehouse);
        suppliers = (CardView) findViewById(R.id.suppliers);
        settings = (CardView) findViewById(R.id.settings);

        inventory.setOnClickListener(this);
        warehouse.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){

            case R.id.inventory:
                i = new Intent(this,Inventory.class);
                startActivity(i);
                break;

            case R.id.warehouse:
                i = new Intent(this,WareHouse.class);
                startActivity(i);
                break;
        }
    }


    //press back double exit
    @Override
    public void onBackPressed() {

        if (exit ){
            super.onBackPressed();
            return;
        }

        exit = true;
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                exit = false;
            }
        }, 1000);


    }
}