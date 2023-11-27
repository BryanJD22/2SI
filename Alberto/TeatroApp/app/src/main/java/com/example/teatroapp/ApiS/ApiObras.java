package com.example.teatroapp.ApiS;

import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiObras {

    @GET("ServletTeatro")
    Call<ArrayList<Obra>> lst_obras(@Query("ACTION") String action);
    @GET("ServletTeatro")
    Call<ArrayList<Obra>> lst_obras_sala(@Query("ACTION") String action, @Query("IDSALA") String idSala);

    @GET("ServletTeatro")
    Call<ArrayList<Obra>> lst_obras_categoria(@Query("ACTION") String action, @Query("CATEGORIA") String categoria);

}
