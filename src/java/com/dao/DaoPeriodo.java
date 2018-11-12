
package com.dao;

import com.conexion.Conexion;
import com.modelo.Periodo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DaoPeriodo extends Conexion
{
    public void insertarPeriodo(Periodo pe) throws Exception {
        try {
            this.conectar();
            String sql="insert into periodo(fechaInicio, fechaFin) value(?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1, pe.getFechaInicio());
            pre.setString(2, pe.getFechaFin());
            pre.executeUpdate();
            System.out.println("//////////////////////////");
             System.out.println("Iniciooooo " + pe.getFechaInicio());
            System.out.println("Fin " + pe.getFechaFin());
            System.out.println("//////////////////////////");
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        
    }
    
    public void modificarTipoCuenta(Periodo pe) throws Exception{
        try {
            this.conectar();
            String sql="update periodo set fechaInicio=?, fechaFin=? where idperiodo=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,pe.getFechaInicio());
            pre.setString(2,pe.getFechaFin());
            pre.setInt(3,pe.getIdPeriodo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
            
        }
    }
    
    public void eliminarPeriodo (Periodo pe) throws Exception {
        try {
            this.conectar();
            String sql="delete from periodo where idPeriodo=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,pe.getIdPeriodo());
            pre.executeUpdate();
        } catch (Exception e) {
        }
        finally{
            this.desconectar();
            
        }
    }
    
    
     public ArrayList<Periodo> mostrarPeriodo() throws Exception
    {
        ArrayList<Periodo> periodos = new ArrayList();
        ResultSet res=null;
        try {
            this.conectar();
            String sql="select * from periodo";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()){
                Periodo pe=new Periodo();
                pe.setIdPeriodo(res.getInt("idPeriodo"));
                pe.setFechaInicio(res.getString("fechaInicio"));
                pe.setFechaFin(res.getString("fechaFin"));
                periodos.add(pe);
                
            }
            
        } catch (Exception e) {
        }
     return periodos;   
    }
    
}
