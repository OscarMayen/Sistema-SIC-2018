/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.modelo.ComprobanteDetalle;
import com.dao.DaoComprobanteDetalle;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author admin
 */
@ManagedBean
@ViewScoped
public class ComprobanteDetalleBean implements Serializable {

    public ComprobanteDetalleBean() {
    }

    
    private ComprobanteDetalle cd;
    private ArrayList<ComprobanteDetalle> lista;
   
    

    public ComprobanteDetalle getCd() {
        return cd;
    }

    public void setCd(ComprobanteDetalle cd) {
        this.cd = cd;
    }

    public ArrayList<ComprobanteDetalle> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ComprobanteDetalle> lista) {
        this.lista = lista;
    }
    
    
    public void listar() throws Exception {
        DaoComprobanteDetalle daoCD;
        daoCD = new DaoComprobanteDetalle();
        this.lista = daoCD.mostrarLibroMayor();
        for(ComprobanteDetalle d:lista)
        { 
            System.out.println("ID: " + d.getIdComprobante());
            System.out.println("FECHA: " + d.getFecha2());
            System.out.println("DESCRIPCION: " + d.getComproDescripcion2());
            System.out.println("CUENTA: " + d.getIdCuenta2());
            System.out.println("MONTO: " + d.getMonto());
            System.out.println("ACCION: " + d.getAccion());
            System.out.println("\n");
        
        }
        this.cd = new ComprobanteDetalle();

    }
    
}
