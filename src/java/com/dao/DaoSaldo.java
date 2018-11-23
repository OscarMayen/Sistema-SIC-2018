
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
            String sql="insert into saldo(anio,saldoInicial,saldoActual,saldoFinal,idCuenta,idPeriodo) "
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
    
    public void modificarSaldo(Saldo sa) throws Exception{
        try {
            this.conectar();
            String sql="update comprobante set anio=?, saldoInicial=?, saldoActual=?, saldoFinal=?, "
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
            String sql="select s.idSaldo, s.anio,  s.saldoInicial, s.saldoActual, s.saldoFinal, "
                    + "c.descripcion, s.idPeriodo "
                    + "from saldo as s "
                    + "inner join cuenta as c on c.idCuenta=s.idCuenta";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()){
                Saldo sa=new Saldo();
                sa.setIdSaldo(res.getInt("idSaldo"));
                sa.setAnio(res.getInt("anio"));
                sa.setSaldoInicial(res.getDouble("saldoInicial"));
                sa.setSaldoActual(res.getDouble("saldoActual"));
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
    
}
