package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.teatroapp.Adapter.AdapterObras;
import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.Obras.ObraPresenter;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public class ObrasActivity extends AppCompatActivity implements ObraContract.View {


    public AdapterObras adapterObras;
    private ObraPresenter lstObrasPresenter;

    private ArrayList<Obra> lstObras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obras_row);

        lstObrasPresenter = new ObraPresenter(this);

        lstObrasPresenter.getObra();

        /*// Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.idReciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);*/



    }

    @Override
    public void sucessListObras(ArrayList<Obra> lstObras) {
        // Crear un nuevo adaptador
        //adapter = new AdapterObras(lstObras);
        this.lstObras = lstObras;
        RecyclerView recyclerView = findViewById(R.id.recyclerObras);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        adapterObras = new AdapterObras(this,lstObras);
        recyclerView.setAdapter(adapterObras);

    }

    @Override
    public void failureListFilms(String message) {
        Toast.makeText(ObrasActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}