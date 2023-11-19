/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MotorSQL {
    Connection conn;
    Statement st;
    ResultSet rs;
    
    public String URL = "jdbc:derby://localhost:1527/PraticaFinal";
    public String USER ="bj3";
    public String PASS = "bj3";
    
    public void connect(){
        try {
            conn = DriverManager.getConnection(URL, USER,PASS);
            st= conn.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(MotorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void disconnect(){
        
        try {
            conn.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MotorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
    
    
    public int execute(String sql){
        
        int resp = 0;
        
        try {
            resp = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MotorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resp;
                    
    }
    
    public ResultSet executeQuery(String sql){
        
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MotorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
        
    }
    
}
