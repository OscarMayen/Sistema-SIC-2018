
package com.dao;

import com.conexion.Conexion;
import com.modelo.ComprobanteDetalle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DaoComprobanteDetalle extends Conexion
{
    
     public void insertarComprobanteDetalle(ComprobanteDetalle comDe) throws Exception {
        try 
        {
            this.conectar();
            String sql = "insert into comprobanteDetalle(monto,accion,idComprobante,idCuenta) value(?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setDouble(1,comDe.getMonto());
            pre.setString(2, comDe.getAccion());
            pre.setInt(3, comDe.getIdComprobante());
            pre.setInt(4, comDe.getIdCuenta());
            pre.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        
    }
     
     public void modificarComprobanteDetalle(ComprobanteDetalle comDe) throws Exception{
        try {
            this.conectar();
            String sql="update comprobanteDetalle set monto=?, accion=?, idComprobante=?, idCuenta=?  "
                    + "where idComprobanteDetalle=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setDouble(1,comDe.getMonto());
            pre.setString(2,comDe.getAccion());
            pre.setInt(3,comDe.getIdComprobante());
            pre.setInt(4,comDe.getIdCuenta());
            pre.setInt(5,comDe.getIdComprobanteDetalle());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
            
        }
    }
     
     public void eliminarComprobanteDetalle(ComprobanteDetalle comDe) throws Exception {
        try {
            if(comDe!=null)
            {   
                System.out.println("id: " + comDe.getIdComprobanteDetalle());
                System.out.println("MONTO: " + comDe.getMonto());
                System.out.println("ACCION: " + comDe.getAccion());
                System.out.println("IDCOMPROBANTE: " + comDe.getIdComprobante());
            }
            this.conectar();
            String sql="delete from comprobanteDetalle where idComprobanteDetalle=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,comDe.getIdComprobante());
            pre.executeUpdate();
            
        } catch (Exception e) {
        }
        finally{
            this.desconectar();
            
        }
    }
     
     public ArrayList<ComprobanteDetalle> mostrarComprobantesDetalle() throws Exception
    {
        ArrayList<ComprobanteDetalle> comprobanteDetalles = new ArrayList();
        ResultSet res=null;
        try {
            this.conectar();
            String sql="select cd.monto, cd.accion, c.codigo, c.descripcion "
                    + "from comprobanteDetalle as cd "
                    + "inner join cuenta as c on c.idCuenta=cd.idCuenta; ";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()){
                ComprobanteDetalle comDe=new ComprobanteDetalle();
                comDe.setMonto(res.getDouble("monto"));
                comDe.setAccion(res.getString("accion"));
                comDe.setCodigoCuenta(res.getString("codigo"));
                comDe.setDescripcionCuenta(res.getString("descripcion"));
                comprobanteDetalles.add(comDe);
            }
            
        } catch (Exception e) {
        }
     return comprobanteDetalles;   
    }
    
     
     
    
}
