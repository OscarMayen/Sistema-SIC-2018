
package com.dao;

import com.conexion.Conexion;
import com.modelo.Comprobante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DaoComprobante extends Conexion 
{
    public void insertarComprobante(Comprobante com) throws Exception {
        try {
            this.conectar();
            String sql="insert into comprobante(fecha,usuario,descripcion,fechaContable) value(?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,com.getFecha());
            pre.setString(2,com.getUsuario());
            pre.setString(3,com.getDescripcion());
            pre.setString(4,com.getFechaContable());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        
    }
    
    public void modificarComprobante(Comprobante com) throws Exception{
        try {
            this.conectar();
            String sql="update comprobante set fecha=?, usuario=?, descripcion=?, fechaContable=?  "
                    + "where idComprobante=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,com.getFecha());
            pre.setString(2,com.getUsuario());
            pre.setString(3,com.getDescripcion());
            pre.setString(4,com.getFechaContable());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
            
        }
    }
    
    public void eliminarComprobante(Comprobante com) throws Exception {
        try {
            this.conectar();
            String sql="delete from comprobante where idComprobante=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,com.getIdComprobante());
            pre.executeUpdate();
        } catch (Exception e) {
        }
        finally{
            this.desconectar();
            
        }
    }
    public ArrayList<Comprobante> mostrarComprobante() throws Exception
    {
        ArrayList<Comprobante> comprobantes = new ArrayList();
        ResultSet res=null;
        try {
            this.conectar();
            String sql="select * from comprobante";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()){
                Comprobante com=new Comprobante();
                com.setIdComprobante(res.getInt("idComprobante"));
                com.setFecha(res.getString("fecha"));
                com.setUsuario(res.getString("usuario"));
                com.setDescripcion(res.getString("descripcion"));
                com.setFechaContable(res.getString("fechaContable"));
                comprobantes.add(com);
            }
            
        } catch (Exception e) {
        }
     return comprobantes;   
    }
    
    
}
