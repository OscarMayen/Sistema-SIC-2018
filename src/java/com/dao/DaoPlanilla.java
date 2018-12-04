/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Empleado;
import com.modelo.Planilla;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DTO
 */
public class DaoPlanilla extends Conexion {

    

    public List<Planilla> mostrarPlanilla() throws Exception {
        List<Planilla> planillas = new ArrayList();
        ResultSet res;
        ResultSet res2;
        try {
            int cantidadEmp = 0;
            double salmen = 0;
            double aguinal = 0;
            double vacaci = 0;
            double insa = 0;
            double isss = 0;
            double afp = 0;
            double total = 0;
            Date actual = new Date();
            this.conectar();
            String sql = "select * from empleado";
            String sql2 = "select count(*)  AS total from empleado";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            PreparedStatement pre2 = this.getCon().prepareStatement(sql2);
            res = pre.executeQuery();            
            res2 = pre2.executeQuery();            
            
            while (res2.next())
            {                
                cantidadEmp=res2.getInt("total");
            }
            
            while (res.next()) 
            {
                
            
                
                Empleado em = new Empleado();
                Planilla pl = new Planilla();
                em.setCodigo_empleado(res.getInt("codigoEmpleado"));
                em.setNombre(res.getString("nombre"));
                em.setSalario_hora(res.getDouble("salarioHora"));
                em.setSalario_diario(res.getDouble("salarioDiario"));
                em.setHoras_trabajo(res.getString("horasTrabajadas"));
                em.setFecha_contratacion(res.getDate("fechaContratacion"));

                //Agregar empleado
                pl.setEmpleado(em);
                //Calculo del salario mensual
                salmen = (em.getSalario_diario() * 30);
                pl.setSalnommen(salmen);
                // calculo del aguinaldo
                if ((((actual.getTime() - em.getFecha_contratacion().getTime()) / (24 * 60 * 60 * 1000)) / 360) >= 10) {
                    //Calculo de aguinaldo
                    aguinal = (21 * em.getSalario_diario()) / 12;
                    pl.setAguinaldo(aguinal);
                    //Calculo de Vacaciones
                    vacaci = (((em.getSalario_diario() * 15) / 12) + ((em.getSalario_diario() * 15 * 0.3) / 12)
                            + (((em.getSalario_diario() * 15) / 12) * 0.14));
                    pl.setVacaciones(vacaci);

                } else if ((((actual.getTime() - em.getFecha_contratacion().getTime()) / (24 * 60 * 60 * 1000)) / 360) < 10
                        && (((actual.getTime() - em.getFecha_contratacion().getTime()) / (24 * 60 * 60 * 1000)) / 360) >= 3) {
                    //Calculo de aguinaldo
                    aguinal = (19 * em.getSalario_diario()) / 12;
                    pl.setAguinaldo(aguinal);
                    //Calculo de Vacaciones
                    vacaci = (((em.getSalario_diario() * 15) / 12) + ((em.getSalario_diario() * 15 * 0.3) / 12)
                            + (((em.getSalario_diario() * 15) / 12) * 0.14));
                    pl.setVacaciones(vacaci);
                } else if ((((actual.getTime() - em.getFecha_contratacion().getTime()) / (24 * 60 * 60 * 1000)) / 360) < 3
                        && (((actual.getTime() - em.getFecha_contratacion().getTime()) / (24 * 60 * 60 * 1000)) / 360) >= 1) {
                    //Calculo de aguinaldo
                    aguinal = (15 * em.getSalario_diario()) / 12;
                    pl.setAguinaldo(aguinal);
                    //Calculo de Vacaciones
                    vacaci = (((em.getSalario_diario() * 15) / 12) + ((em.getSalario_diario() * 15 * 0.3) / 12)
                            + (((em.getSalario_diario() * 15) / 12) * 0.14));
                    pl.setVacaciones(vacaci);
                }
                //calculo del isanforp
                if (cantidadEmp >= 10) {

                    insa = salmen * 0.01;
                    pl.setInsaforp(insa);
                } else {
                    insa = 0.0;
                    pl.setInsaforp(insa);
                }
                //calculo del isss
                isss = salmen * 0.075;
                pl.setIsss(isss);
                //calculo del afp
                afp = salmen * 0.065;
                pl.setAfp(afp);
                //cqalculo total
                total = salmen + pl.getAguinaldo() + pl.getInsaforp() + pl.getVacaciones() + pl.getAfp() + pl.getIsss();
                pl.setTotal(total);
                planillas.add(pl);
            }
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
        return planillas;
    }
}
