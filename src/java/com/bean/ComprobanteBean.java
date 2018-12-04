package com.bean;

import com.dao.DaoComprobante;
import com.dao.DaoComprobanteDetalle;
import com.dao.DaoCuenta;
import com.dao.DaoSaldo;
import com.modelo.Comprobante;
import com.modelo.ComprobanteDetalle;
import com.modelo.Cuenta;
import com.modelo.Saldo;
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
import java.util.Date;

/**
 *
 * @author admin
 */
@ManagedBean
@javax.faces.bean.ViewScoped
public class ComprobanteBean implements Serializable {

    private Comprobante com = new Comprobante(); 
    private ComprobanteDetalle comDe = new ComprobanteDetalle(); 
    private ArrayList<Comprobante> listaComprobantes;
    private String descripcion;
    private String ctaDesc;
    private String descBusq;
    private String ctaBuscq;
    private List < ComprobanteDetalle > lstDetalle = new ArrayList();
    
    private List < Cuenta > lstCta = new ArrayList();
    private Cuenta ctaSelect = new Cuenta();
    
    /*Atributos para crear Comprobante*////
    private int idComprobante;
    private Date fecha;
    private String usuario;
    private String descripcionCom;
    private Date fechaContable;
    
    /*****************************/
    

    /*Atributos para crear ComprobanteDetalle*////
    private double monto;
    private String accion;
    private int idCuenta;
    private double debe;
    private double haber;
    /*****************************/
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

    public ComprobanteDetalle getComDe() {
        return comDe;
    }

    public void setComDe(ComprobanteDetalle comDe) {
        this.comDe = comDe;
    }
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcionCom() {
        return descripcionCom;
    }

    public void setDescripcionCom(String descripcionCom) {
        this.descripcionCom = descripcionCom;
    }

    public Date getFechaContable() {
        return fechaContable;
    }

    
    public void setFechaContable(Date fechaContable) {
        this.fechaContable = fechaContable;
    }

    
    public int getIdComprobante() {
        return idComprobante;
    }

   
    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
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
        
        if(this.fecha==null||this.usuario==null||this.descripcionCom==null||this.fechaContable==null)
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"EROOR","DEBE COMPLETAR LOS CAMPOS"));
        }
        else 
        {
            Comprobante cb = new Comprobante(this.fecha, this.usuario, this.descripcionCom, this.fechaContable);
            daoC = new DaoComprobante();
            daoC.insertarComprobante(cb);
            listarComprobantes();
            cb = new Comprobante();
            this.idComprobante = daoC.recuperarUltimo();
            //mostrando mensaje//
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"EXITO","DATOS GUARDADOS"));
        }
        
        
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
            this.idCuenta=cuent.getIdCuenta();
            
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
          Cuenta ctaSel = (Cuenta) event.getObject();
          DaoCuenta daoCu = new DaoCuenta();
        Cuenta cuent = new Cuenta();

        try {
            cuent = daoCu.cuentaPorCodigo(ctaSel.getCodigo());
            this.idCuenta=cuent.getIdCuenta();
            ctaDesc =cuent.getCodigo();
                    
            
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
//        try {
//            Cuenta ctaSel = (Cuenta) event.getObject();
//            descripcion = ctaSel.getDescripcion();
//            ctaDesc = ctaSel.getCodigo();
//        } catch (Exception ex) {
//            Logger.getLogger(ComprobanteBean.class
//                    .getName())
//                    .log(Level.SEVERE, null, ex);
//            FacesContext.getCurrentInstance().addMessage(null,
//                    new FacesMessage("Error", "Error " + ex.getMessage()));
//        }
        RequestContext.getCurrentInstance().execute("PF('dlgCta').hide();");
    }
    
    public void listarComprobanteDetalle() throws Exception {
        DaoComprobanteDetalle daoCD;
        daoCD = new DaoComprobanteDetalle();
        this.lstDetalle = daoCD.mostrarComprobantesDetalle();
        this.comDe = new ComprobanteDetalle();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exito", "Transaccion mostrados correctamente"));

    }
    
     
    public void insertarComprobanteDtl() throws Exception {
        if (monto <=0 || idComprobante<=0) {
             FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exito", "Error"));
        return;   
        }
        DaoComprobanteDetalle daoD;
        
        ComprobanteDetalle cd= new ComprobanteDetalle(this.monto,this.accion,this.idComprobante,this.idCuenta);
        
        cd.setDescripcionCuenta(descripcion);
        cd.setCodigoCuenta(ctaDesc);
        daoD = new DaoComprobanteDetalle();
        daoD.insertarComprobanteDetalle(cd);
        
        // sacar el max y setear en cd
        //cd.setIdComprobanteDetalle(idComprobante);
        
         lstDetalle.add(cd);
      //  listarComprobantes();
        cd = new ComprobanteDetalle();
        //mostrando mensaje//
        calcularTotales();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exito", "Detalle insertado correctamente"));
        
       // modificarSaldos();
    }
    
    
    
        public void resetNew() {
        this.fecha = null;
        this.usuario = null;
        this.descripcionCom = null;
        this.fechaContable = null; 
        this.ctaDesc=null;
        this.descripcion=null;
        this.monto=0;
        this.accion=null;
        this.idComprobante=0;
        lstDetalle = new ArrayList();
        debe=0;
        haber=0;
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"NUEVA","NUEVA TRANSACCION"));
    }
    
    public void eliminarCD() throws Exception {
        DaoComprobanteDetalle daoCD = new DaoComprobanteDetalle();
        daoCD.eliminarComprobanteDetalle(this.comDe);
        this.comDe = new ComprobanteDetalle();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Detalle eliminado correctamente"));
    } 
    
    public void updateTotales()
    {   
       // calcularTotales();
        
    
    }
    
    void calcularTotales() {
        debe = 0;
        haber = 0;
        for(ComprobanteDetalle d : lstDetalle )
        {
            System.out.println(d.getAccion());
            if(d.getAccion().equals("Debe"))
            {
                debe = debe + d.getMonto();
            }
            else{
                haber=haber + d.getMonto();
            }
        }
       
    }
    
    public void modificarSaldos()
    {
        Cuenta c = new Cuenta();
        Saldo s = new Saldo();
        
        DaoSaldo daoS = new DaoSaldo();
        DaoCuenta daoC= new DaoCuenta();
        for(ComprobanteDetalle d : lstDetalle)
        {
            try {
               c=daoC.cuentaPorCodigo(d.getCodigoCuenta());
               s=daoS.saldoPorCodigo(c.getIdCuenta());
               if(d.getAccion().equals("Debe"))
               {   // SaldoInicial = totalDebe
                   s.setSaldoInicial(s.getSaldoInicial()+ d.getMonto());
                   daoS.actualizarDebe(s.getIdSaldo(), s.getSaldoInicial());
               } else{
                   // SaldoActual = totalHaber
                   s.setSaldoActual(s.getSaldoActual()+ d.getMonto());
                   daoS.actualizarHaber(s.getIdSaldo(),s.getSaldoActual());
                  
                   System.out.println("Resultado de la suma es 2: " + s.getSaldoActual());
               }
               if (c.getTipoCuenta()==1 || c.getTipoCuenta()==4) {
                   s.setSaldoFinal(s.getSaldoInicial()-s.getSaldoActual());
                   daoS.actualizarSaldoFinal(s.getIdSaldo(), s.getSaldoFinal());
                   System.out.println("Resultado de la suma 1: " + (s.getSaldoInicial()));
               } else {
                   s.setSaldoFinal(s.getSaldoActual()-s.getSaldoInicial());
                   daoS.actualizarSaldoFinal(s.getIdSaldo(), s.getSaldoFinal());
               }
               
               //&& 
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Saldos afectados correctamente"));
                
            } catch (Exception ex) {
                Logger.getLogger(ComprobanteBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    

}
