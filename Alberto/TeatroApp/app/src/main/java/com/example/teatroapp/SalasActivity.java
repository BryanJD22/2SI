package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.teatroapp.Adapter.AdapterSalas;
import com.example.teatroapp.Salas.SalaContract;
import com.example.teatroapp.Salas.SalaPresenter;
import com.example.teatroapp.beans.Sala;

import java.util.ArrayList;

public class SalasActivity extends AppCompatActivity implements SalaContract.View {

    private Button btnobras;
    public AdapterSalas adapterSalas;
    private SalaPresenter lstSalasPresenter;
    private ArrayList<Sala> lstSalas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salas);

        lstSalasPresenter = new SalaPresenter(this);

        lstSalasPresenter.getSalas();


    }

    @Override
    public void sucessLstSalas(ArrayList<Sala> lstSalas) {

    }

    @Override
    public void failureListFilms(String message) {

    }
}