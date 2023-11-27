package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.teatroapp.Adapter.UObrasAdapter;
import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.Obras.ObraPresenter;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity implements ObraContract.View {

    private RecyclerView.Adapter adapterTopVentas, adapterTopPopular, adapterAll;
    private ProgressBar loading1, loading2, loading3;
    private RecyclerView recyclerViewTopVentas, recyclerViewTopPopular, recyclerViewAll;

    ArrayList<Obra> lstobras = new ArrayList<>();

    private ObraPresenter lstObrasPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        initView();
        lstObrasPresenter = new ObraPresenter(this);
        lstObrasPresenter.getObraTopVentas();
        sendRequestTopVentas(lstObrasPresenter);

        lstObrasPresenter.getObraTopPopular();
        sendRequestTopPopular(lstObrasPresenter);

        lstObrasPresenter.getObra();
        sucessListObras(lstobras);

    }


    public void sendRequestTopVentas(ArrayList<Obra> lstObrasTopVentas){
        this.lstobras = lstObrasTopVentas;

        recyclerViewTopVentas = findViewById(R.id.topVentas);
        loading1.setVisibility(View.GONE);

        adapterTopVentas = new UObrasAdapter(lstObrasTopVentas);
        recyclerViewTopVentas.setAdapter(adapterTopVentas);


    }

    public void sendRequestTopPopular(ArrayList<Obra> lstObrasTopPopular){
        this.lstobras = lstObrasTopPopular;

        recyclerViewTopVentas = findViewById(R.id.topPopular);
        loading2.setVisibility(View.GONE);

        adapterTopPopular = new UObrasAdapter(lstObrasTopPopular);
        recyclerViewTopVentas.setAdapter(adapterTopPopular);


    }



    private void initView() {
        recyclerViewTopVentas = findViewById(R.id.topVentas);
        recyclerViewTopVentas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTopPopular = findViewById(R.id.topPopular);
        recyclerViewTopPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewAll = findViewById(R.id.allObras);
        recyclerViewAll.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        loading1 = findViewById(R.id.progressBar1);
        loading2 = findViewById(R.id.progressBar2);
        loading3 = findViewById(R.id.progressBar3);
    }

    @Override
    public void sucessListObras(ArrayList<Obra> lstObras) {

        this.lstobras = lstObras;

        recyclerViewAll = findViewById(R.id.allObras);
        loading3.setVisibility(View.GONE);

        adapterAll = new UObrasAdapter(lstObras);
        recyclerViewAll.setAdapter(adapterAll);

    }

    @Override
    public void failureListObras(String message) {

    }
}