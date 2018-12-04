/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DTO
 */
public class DaoUsuario extends Conexion{
    
    public Usuario verificarUsuario(Usuario user) throws Exception
    {
         ResultSet res;
          Usuario us=null;
        try 
        {
            this.conectar();
            String sql = "select idUsuario, usuario, password from usuario where usuario=? and password=?;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, user.getUsuario());
            pre.setString(2, user.getPassword());
            res = pre.executeQuery();
            while (res.next()) 
            {
                us = new Usuario();
                us.setId(res.getInt("idUsuario"));
                us.setUsuario(res.getString("usuario"));
                us.setPassword(res.getString("password"));                
            }
        } 
        catch (Exception e)
        {
            throw e;
        } 
        finally 
        {
            this.desconectar();
        }
        
     return us;
    }
}
