
package com.modelo;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Comprobante 
{
    private int idComprobante;
    private Date fecha;
    private String usuario;
    private String descripcion;
    private Date fechaContable;

    public Comprobante() {
    }

    public Comprobante(int idComprobante, Date fecha, String usuario, String descripcion, Date fechaContable) {
        this.idComprobante = idComprobante;
        this.fecha = fecha;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.fechaContable = fechaContable;
    }

    public Comprobante(Date fecha, String usuario, String descripcion, Date fechaContable) {
        this.fecha = fecha;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.fechaContable = fechaContable;
    }
    
    
    

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaContable() {
        return fechaContable;
    }

    public void setFechaContable(Date fechaContable) {
        this.fechaContable = fechaContable;
    }

   
    
}
