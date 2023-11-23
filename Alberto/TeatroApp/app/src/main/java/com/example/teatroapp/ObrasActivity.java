package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.teatroapp.Adapter.AdapterObras;
import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.Obras.ObraPresenter;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public class ObrasActivity extends AppCompatActivity implements ObraContract.View {

    private RecyclerView recycler;

    private RecyclerView.Adapter adapter;

    private RecyclerView.LayoutManager lManager;

    private ObraPresenter lstObrasPresenter;

    private ArrayList<Obra> lstObras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obras);

        lstObrasPresenter = new ObraPresenter(this);

        lstObrasPresenter.getObra();

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.idReciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

    }

    @Override
    public void sucessListObras(ArrayList<Obra> lstObras) {
        // Crear un nuevo adaptador
        adapter = new AdapterObras(lstObras);
        this.lstObras=lstObras;
        recycler.setAdapter(adapter);

    }

    @Override
    public void failureListFilms(String message) {
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        message, Toast.LENGTH_SHORT);
        toast1.show();
    }
}