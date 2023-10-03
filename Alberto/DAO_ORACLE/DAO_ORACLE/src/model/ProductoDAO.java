package model;
import java.sql.*;
import java.util.ArrayList;

public class ProductoDAO implements DAO<Producto,Integer> {
    private MotorSQL motorSQL;

    public ProductoDAO() {
        motorSQL = new MotorSQL();
    }
    @Override
    public int add(Producto bean) {
        int resp = 0;
        try{
            motorSQL.connect();
            String sql = "INSERT INTO PRODUCTO (nombre, codigo,preciounitario, proveedorID) VALUES('"
                    + bean.getNombre() + "', '"
                    + bean.getCodigo() + "', '"
                    + bean.getPrecioUnitario() + "', '"
                    + bean.getProveedorID()+"')";
            System.out.println("Sentencia INSERT ->" + sql);
            resp = motorSQL.execute(sql);
        }catch(Exception ex){
            System.out.println(ex);
        }finally{
            motorSQL.disconnect();
        }
        if(resp > 0){
            System.out.println("Sentencia ejecutada con éxito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer id) {
        int resp = 0;
        try {
            motorSQL.connect();
            String sql = "DELETE FROM PRODUCTO WHERE id = " + id;
            System.out.println("Sentencia DELETE -> " + sql);
            resp = motorSQL.execute(sql);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            motorSQL.disconnect();
        }
        if (resp > 0) {
            System.out.println("Sentencia ejecutada con éxito.");
        }
        return resp;
    }

    @Override
    public int update(Producto bean) {
        return 0;
    }

    @Override
    public ArrayList<Producto> findAll(Producto bean) {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try{
            motorSQL.connect();
            ResultSet rs = motorSQL.executeQuery(sql);
            while(rs.next()){
                Producto producto = new Producto(
                        rs.getInt("productoID"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("clave")
                );
                productos.add(producto);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            motorSQL.disconnect();
        }
        return productos;
    }
}
