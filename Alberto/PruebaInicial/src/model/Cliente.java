package model;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Cliente {

    private int ClienteID;
    private String nombre;
    private String Apellidos;
    private String DNI;
    private String direccion;
    private  String Fecha_Nacimiento;

    public Cliente() {
    }

    public Cliente(int clienteID, String nombre, String apellidos, String DNI, String direccion, String fecha_Nacimiento) {
        ClienteID = clienteID;
        this.nombre = nombre;
        Apellidos = apellidos;
        this.DNI = DNI;
        this.direccion = direccion;
        Fecha_Nacimiento = fecha_Nacimiento;
    }

    public int getClienteID() {
        return ClienteID;
    }

    public void setClienteID(int clienteID) {
        ClienteID = clienteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        Fecha_Nacimiento = fecha_Nacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "ClienteID=" + ClienteID +
                ", nombre='" + nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", DNI='" + DNI + '\'' +
                ", direccion='" + direccion + '\'' +
                ", Fecha_Nacimiento='" + Fecha_Nacimiento + '\'' +
                '}';
    }

    public static String toArrayJson(ArrayList<Cliente>clientes){
        Gson gson = new Gson();
        return gson.toJson(clientes);

    }
}
