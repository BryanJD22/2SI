package h.alberto.svalero.com.plantillamvpretrofitcines.login_user;

import java.util.ArrayList;

import h.alberto.svalero.com.plantillamvpretrofitcines.beans.Usuario;

public interface LoginContract {

    public interface View{
        void sucessLogin(ArrayList<Usuario> usuarios);
        void failureLogin(String message);
    }

    public interface Presenter{
        void login(Usuario usuario);
        void peliculasByUser(Usuario user);

    }

    public interface Model{
        /*Programación Reactiva*/
        interface OnLoginUserListener{
            void onFinished(ArrayList<Usuario> usuarios);
            void onFailure(String error);
        }
        void getUsuarioService(OnLoginUserListener onLoginUserListener, Usuario user);



    }
}
