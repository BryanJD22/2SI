package h.alberto.svalero.com.plantillamvpretrofitcines.beans;

import java.io.Serializable;

public class Film implements Serializable {
    private String titulo;
    private String trailer;
    private String sinopsis;
    private String fechaEstreno;
    private String url;
    private int duracion;
    private int nVotos;
    private int sPuntuacion;
    private int id;
    private double precio;

    public Film() {
    }
    public Film(String titulo, String trailer, String sinopsis, String fechaEstreno, String url, int duracion, int nVotos, int sPuntuacion, int id, double precio) {
        this.titulo = titulo;
        this.trailer = trailer;
        this.sinopsis = sinopsis;
        this.fechaEstreno = fechaEstreno;
        this.url = url;
        this.duracion = duracion;
        this.nVotos = nVotos;
        this.sPuntuacion = sPuntuacion;
        this.id = id;
        this.precio = precio;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTrailer() {
        return trailer;
    }
    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getFechaEstreno() {
        return fechaEstreno;
    }
    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public int getnVotos() {
        return nVotos;
    }
    public void setnVotos(int nVotos) {
        this.nVotos = nVotos;
    }
    public int getsPuntuacion() {
        return sPuntuacion;
    }
    public void setsPuntuacion(int sPuntuacion) {
        this.sPuntuacion = sPuntuacion;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
