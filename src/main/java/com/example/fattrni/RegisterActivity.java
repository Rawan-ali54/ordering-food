package com.example.fattrni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.prefs.Preferences;

public class RegisterActivity extends AppCompatActivity {

 Button REGISTRATION;
 EditText username, password, country,email,phone;
 DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        REGISTRATION=findViewById(R.id.button);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        country=findViewById(R.id.country);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        db=new DatabaseHelper(this);



        REGISTRATION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String usernameValue= username.getText().toString();
               String passwordValue = password.getText().toString();
               String countryValue= country.getText().toString();
               String emailValue= email.getText().toString();
               String phoneValue= phone.getText().toString();


            boolean c = db.insert(usernameValue,passwordValue,countryValue,emailValue,phoneValue);
            if(c)

                Toast.makeText(RegisterActivity.this, "User Registered!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(RegisterActivity.this, "enter the Values!", Toast.LENGTH_SHORT).show();


            }
        });

    }



}


