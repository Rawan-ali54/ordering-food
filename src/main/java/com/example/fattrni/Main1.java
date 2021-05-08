package com.example.fattrni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    public void main1(View view) {
        Intent intent=new Intent(Main1.this,MainActivity2.class);
        startActivity(intent);

    }
}