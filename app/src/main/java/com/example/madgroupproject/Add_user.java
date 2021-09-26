package com.example.madgroupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Add_user extends AppCompatActivity {

    //initialize

    EditText firstName, lastName, email, password;
    Button btnCreate;
    TextView loginTV;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        // Typecasting

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnCreate = findViewById(R.id.btnCreate);
        loginTV =findViewById(R.id.loginTV);

        ///    take firebase instance here

        auth = FirebaseAuth.getInstance();

        loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Add_user.this,Login.class);
                startActivity(intent);
                finish();
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailID, pass, fName, lName;

                fName = firstName.getText().toString();
                lName = lastName.getText().toString();
                emailID = email.getText().toString();
                pass = password.getText().toString();

                if (fName.isEmpty()) {
                    firstName.setError("Please Enter Your Name");
                    firstName.requestFocus();

                } else if (lName.isEmpty()) {
                    lastName.setError("Please Enter Your Last Name");
                    lastName.requestFocus();

                }else if (emailID.isEmpty()) {
                    email.setError("Please Enter Your Email");
                    email.requestFocus();

                }else if (pass.isEmpty()) {
                    password.setError("Please Enter Your Password");
                    password.requestFocus();

                }else{

                    auth.createUserWithEmailAndPassword(emailID, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()) {
                                startActivity(new Intent(Add_user.this,Login.class));
                                finish();

                            } else {
                                Toast.makeText(Add_user.this, task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
            }
        });

    }


}