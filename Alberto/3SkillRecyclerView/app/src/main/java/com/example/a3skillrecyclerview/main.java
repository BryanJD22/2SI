package com.example.a3skillrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class main extends AppCompatActivity {

    ArrayList<recyclerview_list> recyclerview_list;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        recyclerview_list = new ArrayList<recyclerview_list>();
        recyclerview_list.add(new recyclerview_list(R.drawable.english,"English"));
        recyclerview_list.add(new recyclerview_list(R.drawable.art,"Art"));
        recyclerview_list.add(new recyclerview_list(R.drawable.sport,"Sport"));
        recyclerview_list.add(new recyclerview_list(R.drawable.history,"History"));
        recyclerview_list.add(new recyclerview_list(R.drawable.geography,"Geography"));
        recyclerview_list.add(new recyclerview_list(R.drawable.math,"Math"));
        recyclerview_list.add(new recyclerview_list(R.drawable.tech,"Tech"));
        recyclerview_list.add(new recyclerview_list(R.drawable.science,"Science"));

        recyclerview_adapter recyclerview_adapter = new recyclerview_adapter(recyclerview_list,this);
        recyclerView.setAdapter(recyclerview_adapter);
    }
}