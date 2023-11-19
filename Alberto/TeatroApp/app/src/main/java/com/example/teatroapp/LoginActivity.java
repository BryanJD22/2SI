package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teatroapp.beans.Usuario;
import com.example.teatroapp.login_user.LoginContract;
import com.example.teatroapp.login_user.LoginPresenter;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private EditText edtUser;
    private EditText edtPass;
    private Button btnEnviar;

    private String valorUsuario="";
    private String valorPass="";
    Usuario user = new Usuario();

     LoginPresenter presenter =
            new LoginPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        edtUser=findViewById(R.id.edtUser);
        edtPass=findViewById(R.id.edtPass);
        btnEnviar=findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                valorUsuario=edtUser.getText().toString();
                valorPass=edtPass.getText().toString();
                user.setEmail(valorUsuario);
                user.setPassword(valorPass);

                //1ºValidamos el formato de los datos insertados
                if(validarEmail(valorUsuario) && validarPass(valorPass)){
                    presenter.login(user);

                }

            }
        });
    }

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

    private boolean validarPass(String pass) {
        if(pass.isEmpty() || pass.equals("")){
            edtPass.setError("La contraseña no puede quedar vacía");
            return false;
        }

        return true;
    }

    @Override
    public void sucessLogin(ArrayList<Usuario> usuarios) {

    }

    @Override
    public void failureLogin(String message) {

    }
}