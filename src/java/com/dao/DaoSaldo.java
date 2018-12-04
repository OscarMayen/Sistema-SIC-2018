
package com.dao;

import com.conexion.Conexion;
import com.modelo.Saldo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DaoSaldo extends Conexion 
{
    public void insertarSaldo(Saldo sa) throws Exception {
        try {
            this.conectar();
            String sql="insert into saldo(anio,totalDebe,totalHaber,saldoFinal,idCuenta,idPeriodo) "
                    + "value(?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,sa.getAnio());
            pre.setDouble(2,sa.getSaldoInicial());
            pre.setDouble(3,sa.getSaldoActual());
            pre.setDouble(4,sa.getSaldoFinal());
            pre.setInt(5,sa.getCuenta());
            pre.setInt(6,sa.getPeriodo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        
    }
    
    public Saldo leerId(Saldo sa) throws Exception 
    {
        
        PreparedStatement pr;
        ResultSet rs;
        Saldo sld = null;
        
        try {   
                this.conectar();
                System.out.println("codigo Buscado: " + sa.getIdSaldo());
                String sql="select sa.idSaldo, sa.anio, sa.totalDebe, sa.totalHaber, sa.saldoFinal, "
                         + "sa.IdCuenta, sa.idPeriodo "
                         + "from saldo as sa "
                    + "where sa.idSaldo=?;";
                
                PreparedStatement pre = this.getCon().prepareStatement(sql);
                pre.setInt(1, sa.getIdSaldo());
                rs = pre.executeQuery();
                
                while(rs.next())
                {
                    sld = new Saldo();
                    sld.setIdSaldo(rs.getInt("idSaldo"));
                    sld.setAnio(rs.getInt("anio"));
                    sld.setSaldoInicial(rs.getDouble("totalDebe"));
                    sld.setSaldoActual(rs.getDouble("totalHaber"));
                    sld.setSaldoFinal(rs.getDouble("saldoFinal"));
                    sld.setCuenta(rs.getInt("idCuenta"));
                    sld.setPeriodo(rs.getInt("idPeriodo"));
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
        return sld;
        
    }
    
    
    public void modificarSaldo(Saldo sa) throws Exception{
        
        try {
           
            this.conectar();
            String sql="update saldo set anio=?, totalDebe=?, totalHaber=?, saldoFinal=?, "
                    + "idCuenta=?, idPeriodo=?  "
                    + "where idSaldo=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,sa.getAnio());
            pre.setDouble(2,sa.getSaldoInicial());
            pre.setDouble(3,sa.getSaldoActual());
            pre.setDouble(4,sa.getSaldoFinal());
            pre.setInt(5,sa.getCuenta());
            pre.setInt(6,sa.getPeriodo());
            pre.setInt(7,sa.getIdSaldo());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
            
        }
    }
    
    public void eliminarSaldo(Saldo sa) throws Exception {
        try {
            this.conectar();
            System.out.println("///////// dato");
            System.out.println("ID"+ sa.getIdSaldo());
            String sql="delete from saldo where idSaldo=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,sa.getIdSaldo());
            pre.executeUpdate();
        } catch (Exception e) {
        }
        finally{
            this.desconectar();
            
        }
    }
    public ArrayList<Saldo> mostrarSaldo() throws Exception
    {
        ArrayList<Saldo> saldos = new ArrayList();
        ResultSet res=null;
        try {
            this.conectar();
            String sql="select s.idSaldo, s.anio,  s.totalDebe, s.totalHaber, s.saldoFinal, "
                    + "c.descripcion, s.idPeriodo "
                    + "from saldo as s "
                    + "inner join cuenta as c on c.idCuenta=s.idCuenta";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()){
                Saldo sa=new Saldo();
                sa.setIdSaldo(res.getInt("idSaldo"));
                sa.setAnio(res.getInt("anio"));
                sa.setSaldoInicial(res.getDouble("totalDebe"));
                sa.setSaldoActual(res.getDouble("totalHaber"));
                sa.setSaldoFinal(res.getDouble("saldoFinal"));
                sa.setCuenta2(res.getString("descripcion"));
                sa.setPeriodo(res.getInt("idPeriodo"));
                saldos.add(sa);
            }
            
        } catch (Exception e) {
        }
     return saldos;   
    }
    
    public static java.sql.Date convertirSQLDate(java.util.Date UtilSQL)
     {
         java.sql.Date SqlSate = new java.sql.Date(UtilSQL.getTime());
         return SqlSate;
     }
    
    
    public Saldo saldoPorCodigo(int idCuenta) throws Exception 
    {
        
        PreparedStatement pr;
        ResultSet rs;
        Saldo sl = null;
        
        try {   
                this.conectar();
                
                String sql="select sa.idSaldo, sa.anio, sa.totalDebe, "
                         + "sa.totalHaber, sa.saldoFinal, sa.idCuenta, sa.idPeriodo "
                         + "from saldo as sa "
                    + "where sa.idCuenta=?;";
                
                PreparedStatement pre = this.getCon().prepareStatement(sql);
                pre.setInt(1, idCuenta);
                rs = pre.executeQuery();
                sl = new Saldo();
                while(rs.next())
                {
                    sl.setIdSaldo(rs.getInt("idSaldo"));
                    sl.setAnio(rs.getInt("anio"));
                    sl.setSaldoInicial(rs.getDouble("totalDebe"));
                    sl.setSaldoActual(rs.getDouble("totalHaber"));
                    sl.setSaldoFinal(rs.getDouble("saldoFinal"));
                    sl.setCuenta(rs.getInt("idCuenta"));
                    sl.setPeriodo(rs.getInt("idPeriodo"));
                }   
               
        } 
        catch (Exception e) 
        {
            throw new Exception("Error saldoPorCodigo: " + e.getMessage());
        }
        finally
        {
          this.desconectar();
        }
        return sl;
        
    }
    
    public void actualizarDebe(int id,Double sd) throws Exception
    {
        
        try {
           
            this.conectar();
            String sql="update saldo set totalDebe=?"
                    + "where idSaldo=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setDouble(1,sd);
            pre.setInt(2,id);
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
            
        }
    }
    
    public void actualizarHaber(int id,Double sd) throws Exception
    {
        
        try {
           
            this.conectar();
            String sql="update saldo set totalHaber=?"
                    + "where idSaldo=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setDouble(1,sd);
            pre.setInt(2,id);
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
            
        }
    }
    
    public void actualizarSaldoFinal(int id,Double sd) throws Exception
    {
        
        try {
           
            this.conectar();
            String sql="update saldo set saldoFinal=?"
                    + "where idSaldo=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setDouble(1,sd);
            pre.setInt(2,id);
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
            
        }
    }
    
    
}
