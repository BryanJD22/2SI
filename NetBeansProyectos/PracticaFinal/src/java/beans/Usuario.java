
package beans;

import com.google.gson.Gson;
import java.util.ArrayList;


public class Usuario {
    
    public int ID_USUARIO;
    public String NOMBRE;
    public String EMAIL;
    public String PASS;

    public Usuario() {
    }

    public Usuario(String NOMBRE, String EMAIL, String PASS) {
        this.NOMBRE = NOMBRE;
        this.EMAIL = EMAIL;
        this.PASS = PASS;
    }

    public Usuario(int ID_USUARIO, String NOMBRE, String EMAIL, String PASS) {
        this.ID_USUARIO = ID_USUARIO;
        this.NOMBRE = NOMBRE;
        this.EMAIL = EMAIL;
        this.PASS = PASS;
    }

    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID_USUARIO=" + ID_USUARIO + ", NOMBRE=" + NOMBRE + ", EMAIL=" + EMAIL + ", PASS=" + PASS + '}';
    }

    public static String toArrayJson(ArrayList<Usuario> usuarios){
        Gson gson = new Gson();
        return gson.toJson(usuarios);
        
        
    }
}
