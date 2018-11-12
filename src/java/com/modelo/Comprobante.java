
package com.modelo;

/**
 *
 * @author admin
 */
public class Comprobante 
{
    private int idComprobante;
    private String fecha;
    private String usuario;
    private String descripcion;
    private String fechaContable;

    public Comprobante() {
    }

    public Comprobante(int idComprobante, String fecha, String usuario, String descripcion, String fechaContable) {
        this.idComprobante = idComprobante;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

    public String getFechaContable() {
        return fechaContable;
    }

    public void setFechaContable(String fechaContable) {
        this.fechaContable = fechaContable;
    }
    
    
    
}
