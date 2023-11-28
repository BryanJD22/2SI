package beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Categoria  {
    private int id_categoria;

    private String nombre_categoria;

    public Categoria() {
    }

    public Categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public Categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Categoria(int id_categoria, String nombre_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }


    public static String toArrayJson(ArrayList<Categoria> categorias) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(categorias);
        return resp;
    }
}
