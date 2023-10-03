package model;

import java.util.ArrayList;

public class ProductoDAO implements DAO<Producto,Integer>{

    private MotorSQL motorSQL;

    public ProductoDAO()
    {
        motorSQL = new MotorSQL();
    }
    @Override
    public int add(Producto bean) {
        int resp = 0;
        try{
            motorSQL.connect();
            String sql = "INSERT INTO Producto (Codigo, Nombre, PrecioUnitario) VALUES('"
                    + bean.getCodigo() + "', '"
                    + bean.getNombre() + "', '"
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
            String sql = "DELETE FROM producto WHERE id = " + id;
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
        int resp = 0;
        try {
            motorSQL.connect();
            String sql = "UPDATE producto SET nombre = '" + bean.getNombre() + "', codigo = '" + bean.getCodigo() + "', preciounitario = '" + bean.getPrecioUnitario() + "', proveedorid = '" + bean.getProveedorID() + "' WHERE id = " + bean.getProductoID();
            System.out.println("Sentencia UPDATE -> " + sql);
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
    public ArrayList<Producto> findAll(Producto bean) {
        return null;
    }
}
