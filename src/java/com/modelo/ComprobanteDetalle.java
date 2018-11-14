
package com.modelo;

/**
 *
 * @author admin
 */
public class ComprobanteDetalle 
{
    private int idComprobanteDetalle;
    private double monto;
    private String accion;
    private int idComprobante;
    private int idCuenta;

    public ComprobanteDetalle() {
    }

    
    
    public ComprobanteDetalle(int idComprobanteDetalle, double monto, String accion, int idComprobante, int idCuenta) {
        this.idComprobanteDetalle = idComprobanteDetalle;
        this.monto = monto;
        this.accion = accion;
        this.idComprobante = idComprobante;
        this.idCuenta = idCuenta;
    }

    public int getIdComprobanteDetalle() {
        return idComprobanteDetalle;
    }

    public void setIdComprobanteDetalle(int idComprobanteDetalle) {
        this.idComprobanteDetalle = idComprobanteDetalle;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    
    
    
}
