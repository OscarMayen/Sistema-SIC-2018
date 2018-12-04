/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.modelo.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author DTO
 */
@Named(value = "verificarSesionBean")
@SessionScoped
public class verificarSesionBean implements Serializable {

    /**
     * Creates a new instance of verificarSesionBean
     */
    public void verificarSesionBean() {
        try
        {
            FacesContext context=FacesContext.getCurrentInstance();
             Usuario us=(Usuario) context.getExternalContext().getSessionMap().get("usuario");
             
             if (us==null)
             {
                 context.getExternalContext().redirect("login.xhtml");
             }
        }
        catch (Exception e)
        {
        }
    }
    
}
