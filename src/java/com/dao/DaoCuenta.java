
package com.dao;

import com.conexion.Conexion;
import com.modelo.Cuenta;
import com.modelo.TipoCuenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DaoCuenta extends Conexion
{
    
    public ArrayList<Cuenta> listarCuentas() throws Exception
    {
        ArrayList<Cuenta> cuentas = new ArrayList();
        ResultSet res=null;
        try {
            this.conectar();
           String sql="select cu.idCuenta, cu.codigo, cu.descripcion, "
                    + "c.descripcion as cuentaPadre, tc.nombre as tipoCuenta "
                    + "from cuenta as cu "
                    + "left  join tipocuenta as tc on tc.idTipoCuenta = cu.tipoCuenta "
                   + "left  join cuenta as c on c.idCuenta = cu.cuentaPadre ";
            
          // String sql= "select * from cuenta ";
           PreparedStatement pre=this.getCon().prepareCall(sql);
           res = pre.executeQuery();
           while (res.next())
           {
                Cuenta cu = new Cuenta();
                cu.setIdCuenta(res.getInt("idCuenta"));
                cu.setCodigo(res.getString("codigo"));
                cu.setDescripcion(res.getString("descripcion"));
                cu.setCuentaPadre2(res.getString("cuentaPadre"));
                cu.setTipoCuenta2(res.getString("tipoCuenta"));
                cuentas.add(cu);
             }
            
            
        } catch (Exception e) {
        }
     return cuentas;   
    }
    
    public void insertarCuentas(Cuenta cu) throws Exception {
        try {
            this.conectar();
            String sql="insert into cuenta(codigo, descripcion, cuentaPadre, tipoCuenta ) value(?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,cu.getCodigo());
            pre.setString(2,cu.getDescripcion());
            pre.setInt(3,cu.getCuentaPadre());
            pre.setInt(4,cu.getTipoCuenta());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        
    }
    
     public void modificarCuenta(Cuenta tc) throws Exception{
        try {
            this.conectar();
            String sql="update cuenta set codigo=?, descripcion=?,  "
                    + "cuentaPadre=?, tipoCuenta=?"
                    + "where idCuenta=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,tc.getCodigo());
            pre.setString(2,tc.getDescripcion());
            pre.setInt(3,tc.getCuentaPadre());
            pre.setInt(4,tc.getTipoCuenta());
            pre.setInt(5,tc.getIdCuenta());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
            
        }
    }
    
     
     public void eliminarCuenta(Cuenta cu) throws Exception 
    {
        int flag;
        PreparedStatement pstmt;
        String sql;
        //procedimiento
        flag = 0;
        try 
        {
            this.conectar();
            sql = "delete from cuenta where idCuenta=?;";
            pstmt = this.getCon().prepareStatement(sql);
            pstmt.setInt(1, cu.getIdCuenta());
            pstmt.executeUpdate();
            pstmt.close();
            flag = 1;
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            desconectar();
        }

    }
    
}
