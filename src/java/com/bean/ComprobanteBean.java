package com.bean;

import com.dao.DaoComprobante;
import com.dao.DaoCuenta;
import com.modelo.Comprobante;
import com.modelo.ComprobanteDetalle;
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

    private Comprobante com = new Comprobante(); 
    private ArrayList<Comprobante> listaComprobantes;
    private String descripcion;
    private String ctaDesc;
    private String descBusq;
    private String ctaBuscq;
    private List < ComprobanteDetalle > lstDetalle = new ArrayList();
    
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

    public String getCtaDesc() {
        return ctaDesc;
    }

    public void setCtaDesc(String ctaDesc) {
        this.ctaDesc = ctaDesc;
    }

    public List<ComprobanteDetalle> getLstDetalle() {
        return lstDetalle;
    }

    public void setLstDetalle(List<ComprobanteDetalle> lstDetalle) {
        this.lstDetalle = lstDetalle;
    }

    public String getDescBusq() {
        return descBusq;
    }

    public void setDescBusq(String descBusq) {
        this.descBusq = descBusq;
    }

    public String getCtaBuscq() {
        return ctaBuscq;
    }

    public void setCtaBuscq(String ctaBuscq) {
        this.ctaBuscq = ctaBuscq;
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

    public void ctaValueChangeListener() {
        
   
        DaoCuenta daoCu = new DaoCuenta();
        Cuenta cuent = new Cuenta();

        try {
            cuent = daoCu.cuentaPorCodigo(ctaDesc);
            
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
        DaoCuenta daoCu = new DaoCuenta();
        
        try {
            lstCta = daoCu.buscarCuenta(ctaBuscq, descBusq);
        } catch (Exception ex) {
            Logger.getLogger(ComprobanteBean.class.getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error", "Error " + ex.getMessage()));
        }
        
        
        
        
    }
    
    public void btnAddListener() {
        System.out.println("-------------------------");
        ComprobanteDetalle det = new ComprobanteDetalle ();
       
        
        lstDetalle.add(det);
        
    }
    
    public void onSelecttblCta(SelectEvent event) {
        
        if (event.getObject() == null) {
           FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error", "Error al seleccionar "));
            return;
        }
        try {
            Cuenta ctaSel = (Cuenta) event.getObject();
            descripcion = ctaSel.getDescripcion();
            ctaDesc = ctaSel.getCodigo();
        } catch (Exception ex) {
            Logger.getLogger(ComprobanteBean.class
                    .getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error", "Error " + ex.getMessage()));
        }
        RequestContext.getCurrentInstance().execute("PF('dlgCta').hide();");
    }

}
