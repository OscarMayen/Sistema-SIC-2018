/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.DaoEmpleado;
import com.modelo.Empleado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author DTO
 */
@Named(value = "empleadodBean")
@ViewScoped
public class EmpleadodBean implements Serializable{

    private Empleado emp;
    private List<Empleado> listaEmp;
    
    @PostConstruct
    public void init() {
        emp= new Empleado();
        listaEmp= new ArrayList<Empleado>();
    }
    
    DaoEmpleado empdao= new DaoEmpleado();

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public List<Empleado> getListaEmp() {
        return listaEmp;
    }

    public void setListaEmp(List<Empleado> listaEmp) {
        this.listaEmp = listaEmp;
    }


    public void registrar(){
        
        try {        
            empdao.insertarEmpleado(this.emp);
      
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos insertados correctamente Empleado registrado con exito"));            
            this.listarE();
        } catch (Exception e) {
        }
    }//fin de registrar
    
    
    
    public void listarE(){
        try {
            listaEmp = empdao.mostrarEmpleado();
           //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos mostrados correctamente"));
        } catch (Exception e) {
        }
    }//find e listarDepto
    
    
    public void seleccionar(Empleado empl){
        Empleado EmpVar;
        try 
        {            
            EmpVar = empdao.leerId(empl);
            if(EmpVar!=null){
                this.emp = EmpVar;
            }
            
        } catch (Exception e) {
        }
    }//fin del metodo seleccionar
    
    
    public void modificar(){
        try {
            empdao.modificarEmpleado(emp);
            this.listarE();
            addMessage("Exito", "Empleado modificado correctamente");
        } catch (Exception e) {
        }
    }//fin de modificar
    
    public void eliminar(Empleado emple){
        try {
            empdao.eliminarEmpleado(emple);
            addMessage("Exito", "Empleado eliminado correctamente.");
            this.listarE();
        } catch (Exception e) {
        }
    }//fin de eliminar
    
    public void prepararEmpleado(){
        emp = new Empleado();
    }
    
    
   

    
    
     public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    

}
