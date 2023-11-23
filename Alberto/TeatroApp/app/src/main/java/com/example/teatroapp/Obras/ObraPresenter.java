package com.example.teatroapp.Obras;

import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

public class ObraPresenter implements ObraContract.Presenter, ObraContract.Model.OnLstObrasListener{

    private ObraContract.View vista;
    private ObraModel modelo;

    public ObraPresenter(ObraContract.View vista, ObraModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }


    @Override
    public void getObra() {
        this.modelo.getObrasService(this);

    }

    @Override
    public void onFinished(ArrayList<Obra> lstObras) {

    }

    @Override
    public void onFailure(String error) {

    }
}
