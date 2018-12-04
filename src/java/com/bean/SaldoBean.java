/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.DaoSaldo;
import com.modelo.Saldo;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author admin
 */
@ManagedBean
@ViewScoped
public class SaldoBean implements Serializable {

    private Saldo sa;
    private ArrayList<Saldo> listaSaldos; 
    
    public SaldoBean() {
    }

    public Saldo getSa() {
        return sa;
    }

    public void setSa(Saldo sa) {
        this.sa = sa;
    }

    public ArrayList<Saldo> getListaSaldos() {
        return listaSaldos;
    }

    public void setListaSaldos(ArrayList<Saldo> listaSaldos) {
        this.listaSaldos = listaSaldos;
    }
    
    public void prepararNuevoSaldo(){
        sa = new Saldo();
    }
    
    
    
    public void listarSaldos() throws Exception
    {
        DaoSaldo daoS;
        
        daoS = new DaoSaldo();
        this.listaSaldos = daoS.mostrarSaldo();
        this.sa = new Saldo();
        
    }
    
    public void insertarSaldo() throws Exception{
        DaoSaldo daoS;
        
        daoS = new DaoSaldo();
        daoS.insertarSaldo(this.sa);
        
        listarSaldos();
        this.sa = new Saldo();
        //mostrando mensaje
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exito","Saldo insertado correctamente"));
    }
    
    public void eliminar(Saldo base) throws Exception{
        DaoSaldo daoS;
        Saldo prueba;
        int id;

        daoS = new DaoSaldo();
        id = base.getIdSaldo();
        
        prueba = new Saldo();
        prueba.setIdSaldo(id);
        
        daoS.eliminarSaldo(base);
        
        this.listarSaldos();
        this.sa = new Saldo();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Saldo eliminado correctamente"));
    }
    
    public void seleccionar(Saldo sld) {
        DaoSaldo daoSa = new DaoSaldo();
        Saldo saVar;
        try {
            saVar = daoSa.leerId(sld);

            if (saVar != null) {
                this.sa = saVar;
            }

        } catch (Exception e) {
        }
    }
    
    public void modificar() {
        DaoSaldo daoSa = new DaoSaldo();
        try {
            daoSa.modificarSaldo(this.sa);
            this.listarSaldos();
            this.sa = new Saldo();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Saldo modificado correctamente"));
        } catch (Exception e) {
        }
    }
    
}
