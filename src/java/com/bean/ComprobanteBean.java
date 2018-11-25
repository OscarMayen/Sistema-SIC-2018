package com.bean;

import com.dao.DaoComprobante;
import com.dao.DaoCuenta;
import com.modelo.Comprobante;
import com.modelo.Cuenta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author admin
 */
@ManagedBean
@javax.faces.bean.ViewScoped
public class ComprobanteBean implements Serializable {

    private Comprobante com;
    private ArrayList<Comprobante> listaComprobantes;
    private String descripcion;
    
    private List < Cuenta > lstCta = new ArrayList();
    private Cuenta ctaSelect = new Cuenta();

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Cuenta> getLstCta() {
        return lstCta;
    }

    public void setLstCta(List<Cuenta> lstCta) {
        this.lstCta = lstCta;
    }

    public Cuenta getCtaSelect() {
        return ctaSelect;
    }

    public void setCtaSelect(Cuenta ctaSelect) {
        this.ctaSelect = ctaSelect;
    }
    
    

    public void prepararNuevoComprobante() {
        com = new Comprobante();
    }

    public void listarComprobantes() throws Exception {
        DaoComprobante daoC;

        daoC = new DaoComprobante();
        this.listaComprobantes = daoC.mostrarComprobante();
        this.com = new Comprobante();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exito", "Comprobantes mostrados correctamente"));

    }

    public void insertarComprobante() throws Exception {
        DaoComprobante daoC;

        daoC = new DaoComprobante();
        daoC.insertarComprobante(this.com);
        listarComprobantes();
        this.com = new Comprobante();
        //mostrando mensaje//
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exito", "Comprobante insertado correctamente"));
    }

    public void eliminar() throws Exception {
        DaoComprobante daoC = new DaoComprobante();
        daoC.eliminarComprobante(this.com);
        this.com = new Comprobante();
        listarComprobantes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Comprobante eliminado correctamente"));
    }

    public void ctaListener(ValueChangeEvent vce) {
        
        if (vce.getNewValue() == null) {
            return;
        }
        if (vce.getNewValue().equals(vce.getOldValue())) {
            
        }
        DaoCuenta daoCu = new DaoCuenta();
       
        String cod = String.valueOf(vce.getNewValue().toString());
        Cuenta cuent = new Cuenta();

        try {
            
            if (cuent != null) {
                descripcion = cuent.getDescripcion();
                System.out.println(cuent.getDescripcion());
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Error", "# cuenta no existe"));
            }

        } catch (Exception ex) {
            Logger.getLogger(ComprobanteBean.class.getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error", "Error " + ex.getMessage()));
        }

    }
    
    public void btnBusqCtaListener() {
        RequestContext.getCurrentInstance().execute("PF('dlgCta').show();");
        
         
    }
    
    public void itemBuscarListener() {
        
        
    }
    
    public void onSelecttblCta(SelectEvent event) {
        RequestContext.getCurrentInstance().execute("PF('dlgCta').hide();");
    }

}
