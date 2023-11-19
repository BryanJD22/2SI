
package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MotorSQL {
    Connection conn;
    Statement st;
    ResultSet rs;
    
    public String URL ="jdbc:derby://localhost:1527/Bj";
    public String USER ="bj";
    public String PASS ="bj123";

    
    public void connect(){
        try {
            conn = DriverManager.getConnection(URL,USER,PASS);     
            st = conn.createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(MotorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect(){
        try {
            conn.close();
            rs.close();
            st.close();
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
