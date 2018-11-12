
package com.bean;

import com.dao.DaoComprobante;
import com.modelo.Comprobante;
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
@javax.faces.bean.ViewScoped
public class ComprobanteBean {

    private Comprobante com;
    private ArrayList<Comprobante> listaComprobantes; 
    
    public ComprobanteBean() {
    }

    public Comprobante getCom() {
        return com;
    }

    public void setCom(Comprobante com) {
        this.com = com;
    }

    public ArrayList<Comprobante> getListaComprobantes() {
        return listaComprobantes;
    }

    public void setListaComprobantes(ArrayList<Comprobante> listaComprobantes) {
        this.listaComprobantes = listaComprobantes;
    }
    
    public void prepararNuevoComprobante(){
        com = new Comprobante();
    }
    
     public void listarComprobantes() throws Exception
    {
        DaoComprobante daoC;
        
        daoC = new DaoComprobante();
        this.listaComprobantes = daoC.mostrarComprobante();
        this.com = new Comprobante();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exito","Comprobantes mostrados correctamente"));
        
    }
    
    public void insertarComprobante() throws Exception{
        DaoComprobante daoC;
        
        daoC = new DaoComprobante();
        daoC.insertarComprobante(this.com);
        listarComprobantes();
        this.com = new Comprobante();
        //mostrando mensaje//
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exito","Comprobante insertado correctamente"));
    }
    
    public void eliminar() throws Exception{
        DaoComprobante daoC = new DaoComprobante();
        daoC.eliminarComprobante(this.com);
        this.com  = new Comprobante();
        listarComprobantes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Comprobante eliminado correctamente"));
    }
    
}
