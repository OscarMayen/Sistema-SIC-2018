/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.DaoCuenta;
import com.modelo.Cuenta;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author admin
 */
@ManagedBean
@ViewScoped
public class CuentaBean implements Serializable {

    private Cuenta cu;
    private String descripcion;
    private ArrayList<Cuenta> listaCuentas;

    public CuentaBean() {
    }

    public Cuenta getCu() {
        return cu;
    }

    public void setCu(Cuenta cu) {
        this.cu = cu;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    public void prepararNuevoCuenta() {
        cu = new Cuenta();
    }

    public void listarCuentas() throws Exception {
        DaoCuenta daoC;

        daoC = new DaoCuenta();
        this.listaCuentas = daoC.listarCuentas();
        this.cu = new Cuenta();

    }

    public void insertarCuenta() throws Exception {
        DaoCuenta daoCu;

        daoCu = new DaoCuenta();
        daoCu.insertarCuentas(this.cu);

        listarCuentas();
        this.cu = new Cuenta();

        //mostrando mensaje
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Exito", "Cuenta insertada correctamente"));
    }

    public void eliminar() throws Exception {
        DaoCuenta daoCu = new DaoCuenta();
        daoCu.eliminarCuenta(this.cu);
        this.cu = new Cuenta();
        listarCuentas();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Cuenta eliminado correctamente"));
    }

    public void seleccionar(Cuenta cuent) {
        DaoCuenta daoCu = new DaoCuenta();
        Cuenta cuVar;
        try {
            cuVar = daoCu.leerId(cuent);

            if (cuVar != null) {
                this.cu = cuVar;
            }

        } catch (Exception e) {
        }
    }

    public void modificar() {
        DaoCuenta daoCu = new DaoCuenta();
        try {
            daoCu.modificarCuenta(this.cu);
            this.listarCuentas();
            this.cu = new Cuenta();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Cuenta modificada correctamente"));
        } catch (Exception e) {
        }
    }
    


}
