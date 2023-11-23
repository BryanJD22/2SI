package com.example.teatroapp.Obras;

import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

public class ObraPresenter implements ObraContract.Presenter {

    private ObraContract.View vista;
    private ObraModel modelo;

    public ObraPresenter(ObraContract.View vista) {
        this.vista = vista;
        this.modelo = new ObraModel();
    }


    @Override
    public void getObra() {
        this.modelo.getObrasService(new ObraContract.Model.OnLstObrasListener(){

            @Override
            public void onFinished(ArrayList<Obra> lstObras) {
                vista.sucessListObras(lstObras);
            }

            @Override
            public void onFailure(String error) {

            }
        });


    }


}
