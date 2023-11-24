package com.example.teatroapp.beans;

import java.util.Date;

public class Sala {
    private int idSala;
    private int capacidad;
    private Date fechaCreacion;
    private Date fechaModificacion;

    public Sala() {


    }

    public Sala(int idSala, int capacidad) {
        this.idSala = idSala;
        this.capacidad = capacidad;
    }

    public Sala(int idSala, int capacidad, Date fechaCreacion, Date fechaModificacion) {
        this.idSala = idSala;
        this.capacidad = capacidad;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
