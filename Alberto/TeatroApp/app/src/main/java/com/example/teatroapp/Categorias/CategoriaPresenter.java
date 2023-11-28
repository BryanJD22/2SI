package com.example.teatroapp.Categorias;

import com.example.teatroapp.Obras.ObraModel;
import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public class CategoriaPresenter extends ArrayList<Categoria> implements CategoriaContract.Presenter{

    private CategoriaContract.View vista;

    private CategoriaModel model;

    public CategoriaPresenter(CategoriaContract.View vista) {
        this.vista = vista;
        this.model = new CategoriaModel();
    }

    @Override
    public void getCategoria() {
        this.model.getCategoriasService(new CategoriaContract.Model.OnLstCategoriaListener() {
            @Override
            public void onFinished(ArrayList<Categoria> lstcategorias) {
                vista.sucessListCategorias(lstcategorias);
            }

            @Override
            public void onFailure(String error) {

            }
        });

    }
}
