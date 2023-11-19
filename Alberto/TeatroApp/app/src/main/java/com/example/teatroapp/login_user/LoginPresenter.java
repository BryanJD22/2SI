package com.example.teatroapp.login_user;

import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

public class LoginPresenter implements LoginContract.Presenter{

    private LoginContract.View vista;
    private LoginModel modelo;

    public LoginPresenter(LoginContract.View vista) {
        this.vista = vista;
        this.modelo = new LoginModel();
    }
    @Override
    public void login(Usuario usuario) {
        this.modelo.getUsuarios(usuario, new LoginContract.
                        Model.OnLoginUserListener() {
                    public void onFinished(ArrayList<Usuario> usuarios)
                    {
                        vista.sucessLogin(usuarios);
                    }

                    @Override
                    public void onFailure(String error) {
                        vista.failureLogin("Error en el login");
                    }
                });

    }
}
