package com.example.madgroupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //action bar hide onli this screen
        getSupportActionBar().hide();

        //splash show and 1000 millisecounds go to the menu

        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(2300);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(SplashScreen.this , Login.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
}