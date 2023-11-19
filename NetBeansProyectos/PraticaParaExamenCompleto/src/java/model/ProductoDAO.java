/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.Producto;

/**
 *
 * @author HOME
 */
public class ProductoDAO implements DAO<Producto, Integer>{
    
    MotorSQL motorSql;

    public ProductoDAO() {
        this.motorSql = new MotorSQL();
    }
    

    @Override
    public int add(Producto bean) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Producto bean, Integer integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Producto bean, Integer integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> findAll() {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTOS";
        
        motorSql.connect();
        ResultSet rs = motorSql.executeQuery(sql);
        try {
            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getString(1),
                        rs.getString(3),
                        rs.getString(2),
                        rs.getString(4)

                );
                productos.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        motorSql.disconnect();
        
        
        return productos;
    }
    
    
        public ArrayList<Producto> findbyFilter(String tipo) {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTOS WHERE  TIPO = '"+ tipo + "'";
        
        motorSql.connect();
        ResultSet rs = motorSql.executeQuery(sql);
        try {
            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getString(1),
                        rs.getString(3),
                        rs.getString(2),
                        rs.getString(4)

                );
                productos.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        motorSql.disconnect();
        
        
        return productos;
    }
    
}
