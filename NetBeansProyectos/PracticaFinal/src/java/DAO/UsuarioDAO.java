/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Usuario;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOME
 */
public class UsuarioDAO implements DAO<Usuario, Integer>{
    MotorSQL motorSql;

    public UsuarioDAO() {
        this.motorSql = new MotorSQL();
    }
    

    @Override
    public int add(Usuario bean) {
        int resp =0;
        String sql = "INSERT INTO USUARIOS(NOMBRE,EMAIL,PASS) VALUES ('" +bean.getNOMBRE() +"','"+ bean.getEMAIL()+"','"+bean.getPASS()+"')";
        
        motorSql.connect();
        
        resp = motorSql.execute(sql);
        
        motorSql.disconnect();
        return resp;
    }

    @Override
    public int delete(Usuario bean, Integer integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Usuario bean, Integer integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> findAll() {
        String sql = "SELECT * FROM USUARIOS";
        ArrayList<Usuario> usuarios = new ArrayList<>();
        motorSql.connect();
        
        ResultSet rs = motorSql.executeQuery(sql);
        
        try {
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getString("NOMBRE"),rs.getString("EMAIL"), rs.getString("PASS"));
                usuarios.add(usuario);
             
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        motorSql.disconnect();
        
        
        
        return usuarios;
    }
    
}
