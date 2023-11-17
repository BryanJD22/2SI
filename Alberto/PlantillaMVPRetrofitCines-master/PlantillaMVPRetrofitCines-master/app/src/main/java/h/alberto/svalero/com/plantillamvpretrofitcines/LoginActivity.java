package h.alberto.svalero.com.plantillamvpretrofitcines;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

import h.alberto.svalero.com.plantillamvpretrofitcines.beans.Usuario;
import h.alberto.svalero.com.plantillamvpretrofitcines.login_user.LoginContract;


/**
 * Activiy principal que contiene el login. Navega al Activity que contiene la lista de películas.
 */
public class LoginActivity extends
        AppCompatActivity implements LoginContract.View {


    private EditText edtUser;
    private EditText edtPass;
    private Button btnEnviar;

    private String valorUsuario=null;
    private String valorPass=null;

    //Variable para hacer el login
    Usuario user = new Usuario();
    //LoginPresenter  loginPresenter = new LoginPresenter(this);

    Usuario usuarioBundle=new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //instancias de los componentes visules
        //initComponentes();
        edtUser=findViewById(R.id.edtUser);
        edtPass=findViewById(R.id.edtPass);
        btnEnviar=findViewById(R.id.btnEnviar);

        //Comprobamos si el usuario ya se ha logeado
         checkUsuarioYPass();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                valorUsuario=edtUser.getText().toString();
                valorPass=edtPass.getText().toString();
                user.setEmail(valorUsuario);
                user.setPassword(valorPass);

                //1ºValidamos el formato de los datos insertados
                if(validarEmail(valorUsuario) && validarPass(valorPass)){
                   // loginPresenter.login(user);

                }

            }
        });

    }



    /**
     * Métod que valida  que el el email sea del formato correcto y  no se quede  vacio
     * @param email
     * @return
     */
    private boolean validarEmail(String email) {
        if(email.isEmpty()){
            edtUser.setError("El email no puede quedar vacío");
            return false;

        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtUser.setError("Email no válido");
            return false;

        }else{

            edtUser.setError(null);
            return true;

        }
    }


    /**
     * Método que valida que el campo contraseña no se quede vacío
     * @param pass
     * @return
     */
    private boolean validarPass(String pass) {
        if(pass.isEmpty() || pass.equals("")){
            edtPass.setError("La contraseña no puede quedar vacía");
            return false;
        }

        return true;
    }


    /**
     * Método que navega al 2º Activity con la lista de películas
     */
    private void nextScreen(){
        /*Intent intentFiltrarPeliculas=new Intent(getBaseContext(),FiltradoActivity.class);
        intentFiltrarPeliculas.putExtra("USUARIO",usuarioBundle);
        startActivity(intentFiltrarPeliculas);*/
        Toast.makeText(this, "Siguiente Pantalla.", Toast.LENGTH_SHORT).show();
    }



    /**
     * Método que comprueba si ya se ha logeado el usuario. Si es así pasamos a la sigjuiente pantalla
     * sin necesidad de introducir los datos
     */
    private void checkUsuarioYPass(){
        SharedPreferences preferences = getSharedPreferences("DATOS_LOGIN", Context.MODE_PRIVATE);
        String usuario=preferences.getString("USUARIO",null);
        if(usuario!=null){
            nextScreen();

        }
    }

    /**
     * Método que guarda en un fichero xml el usuario y password de forma permanente
     * @param usuario
     * @param pass
     */
    private void saveSharedPreferences(String usuario,String pass) {
        SharedPreferences preferences = getSharedPreferences("DATOS_LOGIN", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("USUARIO",usuario);
        editor.putString("PASS",pass);
        editor.commit();

    }

    @Override
    public void sucessLogin(ArrayList<Usuario> usuarios) {
        usuarioBundle=usuarios.get(0);
        nextScreen();

    }

    @Override
    public void failureLogin(String message) {
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        message, Toast.LENGTH_SHORT);
        toast1.show();
    }
}

