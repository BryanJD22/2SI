package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teatroapp.AddObras.AddContract;
import com.example.teatroapp.AddObras.AddObraPresenter;
import com.example.teatroapp.beans.Obra;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AddActivity extends AppCompatActivity implements AddContract.View {

    private EditText edtTituloObra;

    private EditText edtCategoria;


    private EditText edtDesc;
    private EditText edtDuracion;
    private BigDecimal edtPrecio;

    Obra obra = new Obra();

    AddObraPresenter presenter = new AddObraPresenter(this);

    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        edtTituloObra = findViewById(R.id.tituloObra);
        edtDesc = findViewById(R.id.desc);
        edtCategoria = findViewById(R.id.categoria);
        edtDuracion = findViewById(R.id.duracion);
        //edtPrecio = findViewById(R.id.precio);

        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obra.setTituloObra(String.valueOf(edtTituloObra));
                obra.setCategoria(String.valueOf(edtCategoria));
                obra.setDescripcionObra(String.valueOf(edtDesc));
                obra.setDuracionMin(edtDuracion);
                //obra.setPrecio(edtPrecio);

                presenter.add(obra);
            }
        });

    }

    @Override
    public void sucessAdd(ArrayList<Obra> lstObras) {

    }

    @Override
    public void failureListFilms(String message) {

    }
}