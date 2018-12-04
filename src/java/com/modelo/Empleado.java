/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.util.Date;



/**
 *
 * @author DTO
 */
public class Empleado {
    
    private int codigo_empleado;
    private String nombre;
    private double salario_hora;
    private double salario_diario;
    private String horas_trabajo;
    private Date fecha_contratacion;

    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario_hora() {
        return salario_hora;
    }

    public void setSalario_hora(double salario_hora) {
        this.salario_hora = salario_hora;
    }

 

    public double getSalario_diario() {
        return salario_diario;
    }

    public void setSalario_diario(double salario_diario) {
        this.salario_diario = salario_diario;
    }

    public String getHoras_trabajo() {
        return horas_trabajo;
    }

    public void setHoras_trabajo(String horas_trabajo) {
        this.horas_trabajo = horas_trabajo;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }




  
   
     
}
