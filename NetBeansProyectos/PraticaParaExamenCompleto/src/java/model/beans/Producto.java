
package model.beans;

import com.google.gson.Gson;
import java.util.ArrayList;


public class Producto {


    private String nombre;
    private String desc;
    private String img;
    private String tipo;

    public Producto() {
    }

    public Producto(String nombre, String desc, String img, String tipo) {
        this.nombre = nombre;
        this.desc = desc;
        this.img = img;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", desc=" + desc + ", img=" + img + ", tipo=" + tipo + '}';
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    public static String toArrayJson(ArrayList<Producto> productos){
        
        Gson gson = new Gson();
        
        return gson.toJson(productos);
        
    }
    
    
}
