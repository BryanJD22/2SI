/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author HOME
 */
public class Usuario {
    private int id_usuario;
    private String email;
    private String pass;
    private String usuario;
    private int id_rol;
    
    
    
   public Usuario() {
            
    }

    public Usuario(int id_usuario, String email, String pass, String usuario, int id_rol) {
        this.id_usuario = id_usuario;
        this.email = email;
        this.pass = pass;
        this.usuario = usuario;
        this.id_rol = id_rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", email=" + email + ", pass=" + pass + ", usuario=" + usuario + ", id_rol=" + id_rol + '}';
    }
   
   
   public static String toArrayJson(ArrayList<Usuario> usuarios){
       Gson gson = new Gson();
       return gson.toJson(usuarios);
               
   }
    
}
