
package com.bean;

import com.dao.DaoPeriodo;
import com.modelo.Periodo;
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
public class PeriodoBean {

    private Periodo pe;
    private ArrayList<Periodo> listaPeriodos; 
    
    public PeriodoBean() {
    }

    public Periodo getPe() {
        return pe;
    }

    public void setPe(Periodo pe) {
        this.pe = pe;
    }

    public ArrayList<Periodo> getListaPeriodos() {
        return listaPeriodos;
    }

    public void setListaPeriodos(ArrayList<Periodo> listaPeriodos) {
        this.listaPeriodos = listaPeriodos;
    }
    
    public void prepararNuevoPeriodo(){
        pe = new Periodo();
    }
    
     public void listarPeriodos() throws Exception
    {
        DaoPeriodo daoP;
        
        daoP = new DaoPeriodo();
        this.listaPeriodos = daoP.mostrarPeriodo();
        this.pe = new Periodo();
        FacesContext context = FacesContext.getCurrentInstance();
        //context.addMessage(null, new FacesMessage("Exito","Periodo mostrados correctamente"));
        
    }
    
    public void insertarPeriodo() throws Exception{
        DaoPeriodo daoP;
        
        daoP = new DaoPeriodo();
        daoP.insertarPeriodo(this.pe);
        listarPeriodos();
        this.pe = new Periodo();
        //mostrando mensaje
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exito","Periodo insertado correctamente"));
    }
    
    public void eliminar() throws Exception{
        DaoPeriodo daoP = new DaoPeriodo();
        daoP.eliminarPeriodo(this.pe);
        this.pe  = new Periodo();
        listarPeriodos();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Periodo eliminado correctamente"));
    }
    
}
