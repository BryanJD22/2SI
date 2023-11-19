package com.example.teatroapp.login_user;

import com.example.teatroapp.ApiS.ApiTeatro;
import com.example.teatroapp.ApiS.ApiUsers;
import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginContract.Model{

    private  OnLoginUserListener onLoginUserListener;

    Usuario usuario;

    @Override
    public void getUsuarios(Usuario user, OnLoginUserListener onLoginUserListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiUsers apiUsers = ApiTeatro.getClient().
                create(ApiUsers.class);
        //petición asíncrona.
        Call<ArrayList<Usuario>> call = apiUsers.login("User");
        call.enqueue(new Callback<ArrayList<Usuario>>() {
            public void onResponse(Call<ArrayList<Usuario>> call,
                                   Response<ArrayList<Usuario>> response) {

                ArrayList<Usuario> usuarios = response.body();// Aquí tengo el JSON
                if(usuarios!=null){

                    onLoginUserListener.onFinished(usuarios);

                }else{
                    //OnLoginListener.onFinished(null);
                    onLoginUserListener.onFailure("Fallo: Login");
                }
            }




            @Override
            public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {

            }


        });
    }
}
