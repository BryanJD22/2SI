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

    }

    @Override
    public void getObrasService(OnLstObrasListener onLstObrasListener) {

    }
}
