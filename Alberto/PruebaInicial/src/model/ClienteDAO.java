package model;

import java.util.ArrayList;

public class ClienteDAO implements DAO<Cliente, Integer>{

    private MotorSQL motorSQL;

    public ClienteDAO() {
        motorSQL = new MotorSQL();
    }
    @Override
    public int add(Cliente bean) {
        int resp = 0;
        try{
            motorSQL.connect();
            String sql = "INSERT INTO CLIENTE (nombre, DNI, ) VALUES('"
                    + bean.getNombre() + "', '"
                    + bean.getDNI() + "', '"
                    + bean.getDireccion() + "', '"
                    + bean.getFecha_Nacimiento()+"')";
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
            String sql = "DELETE FROM clientes WHERE id = " + id;
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
    public int update(Cliente bean) {
        int resp = 0;
        try {
            motorSQL.connect();
            String sql = "UPDATE clientes SET nombre = '" + bean.getNombre() + "', DNI = '" + bean.getDNI() + "', direccion = '" + bean.getDireccion() + "', fecha_nacimiento = '" + bean.getFecha_Nacimiento() + "' WHERE id = " + bean.getClienteID();
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
    public ArrayList<Cliente> findAll(Cliente bean) {
        



        return null;
    }
}
