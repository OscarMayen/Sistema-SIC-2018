/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.modelo.Empleado;
import com.conexion.Conexion;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;




/**
 *
 * @author DTO
 */
public class DaoEmpleado extends Conexion  {
 
  
    
         public void insertarEmpleado(Empleado emp) throws Exception {
            try {               
                 double horastra=Double.parseDouble(emp.getHoras_trabajo());
                 Date Fechacont=convertirSQLDate(emp.getFecha_contratacion());
                this.conectar();         
                String sql = "insert into empleado(nombre,salarioHora,salarioDiario,horasTrabajadas,fechaContratacion)values(?,?,?,?,?);";
                PreparedStatement pre = this.getCon().prepareStatement(sql);
                pre.setString(1, emp.getNombre());
                pre.setDouble(2, (emp.getSalario_diario()/horastra));
                pre.setDouble(3, emp.getSalario_diario());
                pre.setString(4, emp.getHoras_trabajo());
                pre.setDate(5, Fechacont);
                pre.executeUpdate();
            } catch (Exception e) {
                throw e;
            } finally {
                this.desconectar();
            }
        }

    public List<Empleado> mostrarEmpleado() throws Exception {
        List<Empleado> empleados = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql = "select * from empleado";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {
                Empleado em = new Empleado();
                em.setCodigo_empleado(res.getInt("codigoEmpleado"));
                em.setNombre(res.getString("nombre"));
                em.setSalario_hora(res.getDouble("salarioHora"));
                em.setSalario_diario(res.getDouble("salarioDiario"));                
                em.setHoras_trabajo(res.getString("horasTrabajadas"));                
                em.setFecha_contratacion(res.getDate("fechaContratacion"));               
                empleados.add(em);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return empleados;
    }

    public void modificarEmpleado(Empleado emp) throws Exception {
        double horastra = Double.parseDouble(emp.getHoras_trabajo());
        Date Fechacont = convertirSQLDate(emp.getFecha_contratacion());
        try {
         
            this.conectar();
           String sql = "update empleado set nombre=?, salarioHora=?, salarioDiario=?, horasTrabajadas=?, fechaContratacion=? "
                        + "where codigoEmpleado=?;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
                pre.setString(1, emp.getNombre());
                pre.setDouble(2, (emp.getSalario_diario()/horastra));
                pre.setDouble(3, emp.getSalario_diario());
                pre.setString(4, emp.getHoras_trabajo());
                pre.setDate(5, Fechacont);
                pre.setInt(6, emp.getCodigo_empleado());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void eliminarEmpleado(Empleado emp) throws Exception {
        try {
            this.conectar();
            String sql = "delete from empleado where codigoEmpleado=?;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, emp.getCodigo_empleado());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public Empleado leerId(Empleado emp) throws Exception 
    {
        PreparedStatement pr;
        ResultSet rs;
        Empleado em = null;
        
        try {   
                this.conectar();
                String sql = "select codigoEmpleado, nombre, salarioHora,salarioDiario,horasTrabajadas,fechaContratacion "
                        + "from empleado where codigoEmpleado=?;";
                PreparedStatement pre = this.getCon().prepareStatement(sql);
                
                pre.setInt(1, emp.getCodigo_empleado());
                rs = pre.executeQuery();
                
                while(rs.next())
                {
                    em= new Empleado();
                    em.setCodigo_empleado(rs.getInt("codigoEmpleado"));
                    em.setNombre(rs.getString("nombre"));
                    em.setSalario_hora(rs.getDouble("salarioHora"));
                    em.setSalario_diario(rs.getDouble("salarioDiario"));
                    em.setHoras_trabajo(rs.getString("horasTrabajadas"));
                    em.setFecha_contratacion(rs.getDate("fechaContratacion"));
                }        
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
          this.desconectar();
        }
        return em;
        
    }
    

public static java.sql.Date convertirSQLDate(java.util.Date utilSQL) {
        java.sql.Date SqlDate = new java.sql.Date(utilSQL.getTime());
        return SqlDate;
    }

}
