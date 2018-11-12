
package com.modelo;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Periodo 
{
    private int idPeriodo;
    private String fechaInicio;
    private String fechaFin;

    public Periodo() {
    }

    public Periodo(int idPeriodo, String fechaInicio, String fechaFin) {
        this.idPeriodo = idPeriodo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    
   
}
