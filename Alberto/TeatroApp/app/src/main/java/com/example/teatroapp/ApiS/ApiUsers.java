package com.example.teatroapp.ApiS;

import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiUsers {

    @GET("ServletTeatro")
    Call<ArrayList<Usuario>> login(@Query("ACTION") String action);

}
