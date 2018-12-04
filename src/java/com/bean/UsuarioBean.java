/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.DaoUsuario;
import com.modelo.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author DTO
 */
@Named(value = "loginBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    private Usuario usuario;
    private DaoUsuario userdao;
    
    @PostConstruct
    public void init() {
        usuario= new Usuario();
        userdao= new DaoUsuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion()
    {
        Usuario usa=null;
        String redireccion=null;
        try
        {
            usa=userdao.verificarUsuario(this.usuario);
            if (usa!= null) 
            {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usa);
                redireccion="./views/Bienvenido/bienvenido.xhtml?faces-redirect=true";
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales incorrectas"));
            }
            
        } 
        catch (Exception e) 
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Credenciales incorrectas"));
        }
      return redireccion;      
    }
    
    public void cerrarSesion()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
