package com.example.teatroapp.beans;

import java.sql.Timestamp;

public class Obra {
    private int idObra;
    private String tituloObra;
    private String descripcionObra;
    private String imagenObra;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;

    public Obra() {
    }

    public Obra(int idObra, String tituloObra, String descripcionObra, String imagenObra, Timestamp fechaCreacion, Timestamp fechaModificacion) {
        this.idObra = idObra;
        this.tituloObra = tituloObra;
        this.descripcionObra = descripcionObra;
        this.imagenObra = imagenObra;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public String getTituloObra() {
        return tituloObra;
    }

    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }

    public String getDescripcionObra() {
        return descripcionObra;
    }

    public void setDescripcionObra(String descripcionObra) {
        this.descripcionObra = descripcionObra;
    }

    public String getImagenObra() {
        return imagenObra;
    }

    public void setImagenObra(String imagenObra) {
        this.imagenObra = imagenObra;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
