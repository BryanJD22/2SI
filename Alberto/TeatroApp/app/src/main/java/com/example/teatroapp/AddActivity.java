package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.teatroapp.AddObras.AddContract;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity implements AddContract.View {

    private EditText edtTituloObra;
    private EditText edtDesc;
    private EditText edtDuracion;
    private EditText edtPrecio;



    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        edtTituloObra = findViewById(R.id.tituloObra);
        edtDesc = findViewById(R.id.desc);
        edtDuracion = findViewById(R.id.duracion);
        edtPrecio = findViewById(R.id.precio);



    }

    @Override
    public void sucessAdd(ArrayList<Obra> lstObras) {

    }

    @Override
    public void failureListFilms(String message) {

    }
}