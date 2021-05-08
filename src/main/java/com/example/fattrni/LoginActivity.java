package com.example.fattrni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db =new DatabaseHelper(this);
            e1=(EditText) findViewById(R.id.username);
            e2=(EditText) findViewById(R.id.password);
            b1=(Button) findViewById(R.id.login);
            b2=(Button) findViewById(R.id.register);








    }

    public void login(View view) {
        String s1= e1.getText().toString();
        String s2=e2.getText().toString();
        if(s1.equals("")|| s2.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
        }
        else{
            boolean chkusername=db.check(s1,s2);
            if(chkusername==true)
            {


                Toast.makeText(getApplicationContext(), "Done!", Toast.LENGTH_SHORT).show();
                Intent intent;
                intent = new Intent(LoginActivity.this, Main1.class);
                startActivity(intent);

            }
            else
                Toast.makeText(getApplicationContext(), "InValid username or password", Toast.LENGTH_SHORT).show();
        }
    }

    public void register(View view) {
        Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}