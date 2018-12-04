
package com.dao;

import com.conexion.Conexion;
import com.modelo.TipoCuenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DaoTipoCuenta extends Conexion 
{
    public void insertarTipoCuentas(TipoCuenta tc) throws Exception {
        try {
            this.conectar();
            String sql="insert into tipocuenta(nombre) value(?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,tc.getNombre());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        
    }
    public void modificarTipoCuenta(TipoCuenta tc) throws Exception{
        try {
            this.conectar();
            String sql="update tipocuenta set nombre=? where idTipoCuenta=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,tc.getNombre());
            pre.setInt(2,tc.getId());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
            
        }
    }
    public void eliminarTipoCuenta (TipoCuenta tc) throws Exception {
        try {
            this.conectar();
            String sql="delete from tipocuenta where idTipoCuenta=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,tc.getId());
            pre.executeUpdate();
        } catch (Exception e) {
        }
        finally{
            this.desconectar();
            
        }
    }
    public ArrayList<TipoCuenta> mostrarTipoCuenta() throws Exception
    {
        ArrayList<TipoCuenta> tipoCuentas = new ArrayList();
        ResultSet res=null;
        try {
            this.conectar();
            String sql="select * from tipocuenta";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()){
                TipoCuenta tc=new TipoCuenta();
                tc.setId(res.getInt("idTipoCuenta"));
                tc.setNombre(res.getString("nombre"));
                tipoCuentas.add(tc);
                
            }
            
        } catch (Exception e) {
        }
     return tipoCuentas;   
    }
    
    
    
    
}
