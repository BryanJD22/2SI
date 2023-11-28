package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.teatroapp.Valorar.ValorarContract;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Valoracion;

import java.util.ArrayList;

public class DetallesActivity extends AppCompatActivity implements ValorarContract.View {
    private TextView tituloObra, obraValoracionTxt, duracionTxt, descObra;
    private ProgressBar progressBar;
    private NestedScrollView scrollView;
    private ImageView pic2, backImg;
    private RecyclerView recyclerViewCategorias;
    private int idObra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        idObra = getIntent().getIntExtra("idObra",0);
        initView();
    }



    private void initView() {
        tituloObra = findViewById(R.id.tituloObraDetalles);
        progressBar = findViewById(R.id.progressBarDetail);
        scrollView = findViewById(R.id.scrollView2);
        pic2 = findViewById(R.id.picDetail);
        obraValoracionTxt = findViewById(R.id.obraValoracion);
        duracionTxt = findViewById(R.id.duracionDetalles);
        descObra = findViewById(R.id.descDetalles);
        backImg = findViewById(R.id.backImg);
        recyclerViewCategorias = findViewById(R.id.categoriaDetalles);
        recyclerViewCategorias.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        backImg.setOnClickListener(v -> finish());
    }


    @Override
    public void sendRequestObras(ArrayList<Obra> lstObras) {

    }

    @Override
    public void sucessLstValoraciones(ArrayList<Valoracion> lstValoraciones) {

    }

    @Override
    public void failureListValoraciones(String message) {

    }
}