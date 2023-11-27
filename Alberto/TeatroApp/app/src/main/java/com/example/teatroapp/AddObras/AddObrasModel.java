package com.example.teatroapp.AddObras;

import com.example.teatroapp.ApiS.ApiObras;
import com.example.teatroapp.ApiS.ApiTeatro;
import com.example.teatroapp.ApiS.ApiUsers;
import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddObrasModel implements AddContract.Model {

    public void addObra(Obra obra, final OnLstObrasListener onLstObrasListener) {
        ApiObras apiObras = ApiTeatro.getClient().create(ApiObras.class);
        Call<ArrayList<Obra>> call = apiObras.addObra("User.ADD", obra.getTituloObra(), obra.getCategoria(),
                                                            obra.getDescripcionObra(),obra.getDuracionMin(),obra.getPrecio());

        call.enqueue(new Callback<ArrayList<Obra>>() {
            @Override
            public void onResponse(Call<ArrayList<Obra>> call, Response<ArrayList<Obra>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Obra> obras = response.body();
                    if (obras != null && obras.size() > 0) {
                        // La obra se agregó correctamente, obtenemos el ID de la obra
                        String idObra = obras.get(0).getIdObra();

                        // Ahora, llamamos a la API para agregar la relación en la tabla 'obra_sala'
                        //addObraSala(idObra, obra.getIdSala(), obra.getFecha(), obra.getHora(), onLstObrasListener);
                    } else {
                        // Manejar error al agregar la obra
                        onLstObrasListener.onFailure("Error al agregar la obra");
                    }
                } else {
                    // Manejar error en la respuesta
                    onLstObrasListener.onFailure("Error en la respuesta al agregar la obra");
                }
            }

    }

    @Override
    public void getObrasService(OnLstObrasListener onLstObrasListener) {

    }
}
