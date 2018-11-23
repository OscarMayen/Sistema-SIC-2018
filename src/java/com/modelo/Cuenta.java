
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

    private String  cuentaPadre2;
    private String tipoCuenta2;
    
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

    //Solo para mostrar los datos
    public Cuenta(int idCuenta, String codigo, String descripcion, String cuentaPadre2, String tipoCuenta2) {
        this.idCuenta = idCuenta;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cuentaPadre2 = cuentaPadre2;
        this.tipoCuenta2 = tipoCuenta2;
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

    public String getCuentaPadre2() {
        return cuentaPadre2;
    }

    public void setCuentaPadre2(String cuentaPadre2) {
        this.cuentaPadre2 = cuentaPadre2;
    }

    public String getTipoCuenta2() {
        return tipoCuenta2;
    }

    public void setTipoCuenta2(String tipoCuenta2) {
        this.tipoCuenta2 = tipoCuenta2;
    }

    
    
    
}
