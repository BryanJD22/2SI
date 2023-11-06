package com.example.a3skillrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class pages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pages);

        int pageId = getIntent().getIntExtra("id",0);
    }
}