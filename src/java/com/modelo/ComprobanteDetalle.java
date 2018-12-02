
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
    
    private String idComprobante2;
    private String idCuenta2;
    private String codigoCuenta;
    private String descripcionCuenta;
    
    
    public ComprobanteDetalle() {
    }

    
    
    public ComprobanteDetalle(int idComprobanteDetalle, double monto, String accion, int idComprobante, int idCuenta) {
        this.idComprobanteDetalle = idComprobanteDetalle;
        this.monto = monto;
        this.accion = accion;
        this.idComprobante = idComprobante;
        this.idCuenta = idCuenta;
    }

    public ComprobanteDetalle(double monto, String accion, int idComprobante, int idCuenta) {
        this.monto = monto;
        this.accion = accion;
        this.idComprobante = idComprobante;
        this.idCuenta = idCuenta;
    }
    
    

    //Solo para mostrar datos

    public ComprobanteDetalle(int idComprobanteDetalle, double monto, String accion, String idComprobante2, String idCuenta2) {
        this.idComprobanteDetalle = idComprobanteDetalle;
        this.monto = monto;
        this.accion = accion;
        this.idComprobante2 = idComprobante2;
        this.idCuenta2 = idCuenta2;
    }

    public ComprobanteDetalle(double monto, String accion, String codigoCuenta, String descripcionCuenta) {
        this.monto = monto;
        this.accion = accion;
        this.codigoCuenta = codigoCuenta;
        this.descripcionCuenta = descripcionCuenta;
    }
    

    public String getIdComprobante2() {
        return idComprobante2;
    }

    public void setIdComprobante2(String idComprobante2) {
        this.idComprobante2 = idComprobante2;
    }

    public String getIdCuenta2() {
        return idCuenta2;
    }

    public void setIdCuenta2(String idCuenta2) {
        this.idCuenta2 = idCuenta2;
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

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getDescripcionCuenta() {
        return descripcionCuenta;
    }

    public void setDescripcionCuenta(String descripcionCuenta) {
        this.descripcionCuenta = descripcionCuenta;
    }
    
    
    
    
}
