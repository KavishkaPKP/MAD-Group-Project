package com.example.madgroupproject;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SettingActivity extends AppCompatActivity {

    Button btnAddUser,btnLogoutSetting,rPwd,dAccount,users,groups,location ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        btnAddUser = findViewById(R.id.btnAddUser);
        btnLogoutSetting = findViewById(R.id.btnLogoutSetting);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this,Add_user.class);
                startActivity(intent);
                finish();

            }
        });

        btnLogoutSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(SettingActivity.this,Login.class);
                startActivity(intent);
                finish();

            }
        });
    }

    public void onClick(View view) {
    }
}
