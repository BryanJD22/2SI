package beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class User {
    private String username;
    private String token; // Puedes agregar otros campos según tus necesidades

    public User(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public static String toArrayJson(ArrayList<User> usuarios) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(usuarios);
        return resp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Getters y setters

}
