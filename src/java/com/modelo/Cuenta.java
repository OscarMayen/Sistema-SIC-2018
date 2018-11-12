
package com.modelo;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Cuenta 
{
    private int idCuenta;
    private String codigo;
    private String descripcion;
    private int cuentaPadre;
    private int tipoCuenta;

    public Cuenta() {
    }

    public Cuenta(int idCuenta, String codigo, String descripcion, int tipoCuenta) {
        this.idCuenta = idCuenta;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoCuenta = tipoCuenta;
    }

    public Cuenta(int idCuenta, String codigo, String descripcion, int cuentaPadre, int tipoCuenta) {
        this.idCuenta = idCuenta;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cuentaPadre = cuentaPadre;
        this.tipoCuenta = tipoCuenta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCuentaPadre() {
        return cuentaPadre;
    }

    public void setCuentaPadre(int cuentaPadre) {
        this.cuentaPadre = cuentaPadre;
    }

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    
    
}
