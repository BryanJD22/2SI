package com.example.teatroapp.login_user;

import android.util.Log;

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
        ApiUsers apiUsers = ApiTeatro.getClient().create(ApiUsers.class);
        //petición asíncrona.
        Call<ArrayList<Usuario>> call = apiUsers.login("User.FIND_ALL");
        call.enqueue(new Callback<ArrayList<Usuario>>() {
            public void onResponse(Call<ArrayList<Usuario>> call,Response<ArrayList<Usuario>> response) {
                if(response.isSuccessful()){
                    ArrayList<Usuario> usuarios = response.body();// Aquí tengo el JSON
                    if(usuarios!=null) {
                        for (Usuario usuario : usuarios) {
                            // Check if email and password match
                            if (usuario.getEmail().equals(user.getEmail()) && usuario.getPassword().equals(user.getPassword())) {
                                // Match found, call onFinished
                                onLoginUserListener.onFinished(usuarios);
                                return; // No need to continue checking
                            }
                        }

                    }else{
                        Log.d("Bryan Error", "1");
                        onLoginUserListener.onFailure("Fallo: Login");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make login request", t);
                onLoginUserListener.onFailure("Failed to make login request");
                Log.d("Bryan Error", "1");
            }
        });
    }
}
