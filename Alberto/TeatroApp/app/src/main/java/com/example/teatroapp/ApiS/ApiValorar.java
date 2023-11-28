package com.example.teatroapp.ApiS;

import com.example.teatroapp.beans.Obra;

import java.math.BigDecimal;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiValorar {

    @GET("ServletTeatro")
    Call<ArrayList<Obra>> addValoracion(@Query("ACTION") String action,
                                  @Query("VALORACION") int valoracion,
                                  @Query("IDOBRA") int idObra,
                                  @Query("IDUSER") int idUser;
}
