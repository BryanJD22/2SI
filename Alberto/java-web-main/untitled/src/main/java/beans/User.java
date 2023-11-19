package beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class User {
    private String username;
    private String email; // Puedes agregar otros campos según tus necesidades

    private String pass;

    public User(String username, String email, String pass) {
        this.username = username;
        this.email = email;
        this.pass = pass;
    }



    public static String toArrayJson(ArrayList<User> usuarios) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(usuarios);
        return resp;
    }



    // Getters y setters


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
