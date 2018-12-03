/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reporteria;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

/**
 *
 * 
 */
@ManagedBean
@javax.faces.bean.ViewScoped
public class BalanceCompr implements Serializable {

    private Date fechaPeriod = new Date();

    public Date getFechaPeriod() {
        return fechaPeriod;
    }

    public void setFechaPeriod(Date fechaPeriod) {
        this.fechaPeriod = fechaPeriod;
    }
    
    
    
    /**
     * Creates a new instance of RptCtasBean
     */
    public BalanceCompr() {
    }
    
    public void btnImprimirListener() {
        try {
            String rutarpt = "/com/reportes/BalCompr.jasper";
           
        Calendar cal= Calendar.getInstance();
        cal.setTime(fechaPeriod);
        int year= cal.get(Calendar.YEAR);
        
           FacesContext fc = FacesContext.getCurrentInstance();
           HttpServletRequest request = (HttpServletRequest) fc
                   .getExternalContext().getRequest();
    
            String url = request.getContextPath() + "/Generar";

            request.getSession().setAttribute("rutarpt",rutarpt);
            request.getSession().setAttribute("url", url);
            
            Map param = new HashMap();
            param.put("anio", String.valueOf(year));
            
            request.getSession().setAttribute("parameters", param);
            RequestContext.getCurrentInstance().execute(
                    "window.open('" + url
                    + "','Rpt','location=0,menubar=0,resizable=1,"
                    + "status=0,toolbar=0');");
        

        } catch (Exception ex) {
//            Logger.getLogger(RptTickets.class.getName())
//                    .log(Level.SEVERE, null, ex);
//            alert("Error al generar el reporte. " + ex.getMessage(), 1);
        }
       
       
       
    }
    
}
