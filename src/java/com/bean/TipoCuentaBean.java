
package com.bean;

import com.dao.DaoTipoCuenta;
import com.modelo.TipoCuenta;
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
public class TipoCuentaBean implements Serializable {

    private TipoCuenta tc;
    private ArrayList<TipoCuenta> listaTipoC;    
    
    public TipoCuentaBean() {
    }

    public TipoCuenta getTc() {
        return tc;
    }

    public void setTc(TipoCuenta tc) {
        this.tc = tc;
    }

    public ArrayList<TipoCuenta> getListaTipoC() {
        return listaTipoC;
    }

    public void setListaTipoC(ArrayList<TipoCuenta> listaTipoC) {
        this.listaTipoC = listaTipoC;
    }
    
     public void insertarTipoCuenta() throws Exception{
        DaoTipoCuenta daoTipoC;
        
        daoTipoC = new DaoTipoCuenta();
        daoTipoC.insertarTipoCuentas(this.tc);
        
        listarTipoCuentas();
        this.tc = new TipoCuenta();
        
        //mostrando menaje
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Exito","Tipo Cuenta insertada correctamente"));
    }
    
    public void modificarTipoCuenta() throws Exception{
         DaoTipoCuenta daoTipoC;
        
        daoTipoC = new DaoTipoCuenta();
        daoTipoC.modificarTipoCuenta(this.tc);
        
        listarTipoCuentas();
        this.tc = new TipoCuenta();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito","Tipo Cuenta modificado correctamente"));
    }
    
    public void listarTipoCuentas() throws Exception{
        DaoTipoCuenta daoTipoC;
        
        daoTipoC = new DaoTipoCuenta();
        this.listaTipoC = daoTipoC.mostrarTipoCuenta();
        this.tc = new TipoCuenta();
    }
    
    public void eliminar(TipoCuenta base) throws Exception{
        DaoTipoCuenta daoTipoC;
        TipoCuenta prueba;
        int id;

        daoTipoC = new DaoTipoCuenta();
        id = base.getId();
        
        prueba = new TipoCuenta();
        prueba.setId(id);
        
        daoTipoC.eliminarTipoCuenta(base);
        
        this.listarTipoCuentas();
        this.tc = new TipoCuenta();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Carrera eliminado correctamente"));
    }
    
}
