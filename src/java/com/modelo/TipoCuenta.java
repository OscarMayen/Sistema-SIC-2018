
package com.modelo;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class TipoCuenta implements Serializable
{
    private int id;
    private String nombre;

    public TipoCuenta() {
    }

    public TipoCuenta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
