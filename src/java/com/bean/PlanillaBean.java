/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.DaoPlanilla;
import com.modelo.Planilla;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author DTO
 */
@Named(value = "planillaBean")
@ViewScoped
public class PlanillaBean implements Serializable {

    private Planilla pla;
    private List<Planilla> listaPla;
    
    @PostConstruct
    public void init() 
    {
        pla= new Planilla();
        listaPla= new ArrayList<Planilla>();
    }

    DaoPlanilla daopa= new DaoPlanilla();
    public Planilla getPla() {
        return pla;
    }

    public void setPla(Planilla pla) {
        this.pla = pla;
    }

    public List<Planilla> getListaPla() {
        return listaPla;
    }

    public void setListaPla(List<Planilla> listaPla) {
        this.listaPla = listaPla;
    }
    
        public void listarPl(){
        try {
            listaPla = daopa.mostrarPlanilla();
           //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos mostrados correctamente"));
        } catch (Exception e) {
        }
    }//find e listarDepto
    
}
