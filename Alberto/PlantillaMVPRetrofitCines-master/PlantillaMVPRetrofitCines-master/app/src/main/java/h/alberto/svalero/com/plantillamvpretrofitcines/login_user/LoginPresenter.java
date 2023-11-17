package h.alberto.svalero.com.plantillamvpretrofitcines.login_user;

import java.util.ArrayList;

import h.alberto.svalero.com.plantillamvpretrofitcines.beans.Usuario;

public class LoginPresenter implements LoginContract.Presenter{

    /*Presenter, tiene que poder hablar con el Modelo, y desencadenar
   acciones en la Vista*/
    private LoginContract.View vista;
    private LoginModel modelo;

    public LoginPresenter(LoginContract.View vista) {
        this.vista = vista;
        this.modelo = new LoginModel();
    }


    @Override
    public void login(final Usuario user) {
        this.modelo.getUsuarioService(new LoginContract.
                Model.OnLoginUserListener() {
            public void onFinished(ArrayList<Usuario> usuarios)
            {
                vista.sucessLogin(usuarios);
            }

            @Override
            public void onFailure(String error) {
                vista.failureLogin("Error en el login");
            }
        } ,user);

    }

    @Override
    public void peliculasByUser(Usuario user) {

    }
}
