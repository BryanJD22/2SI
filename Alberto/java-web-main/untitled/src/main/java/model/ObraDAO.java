package model;

import beans.Obra;
import beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObraDAO implements DAO<Obra,Integer>{

    MotorSQL motosSql;

    public ObraDAO() {
        this.motosSql = new MotorSQL();
    }
    @Override
    public int add(Obra bean) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Obra bean) {
        return 0;
    }

    @Override
    public ArrayList<Obra> findAll() throws SQLException {
        String sql = "SELECT * FROM OBRA";
        ArrayList<Obra> lstObras = new ArrayList<>();

        motosSql.conectar();
        ResultSet rs = motosSql.consultar(sql);


        try {
            while (rs.next()) {
                Obra obra = new Obra(rs.getInt("id_obra"),
                        rs.getString("titulo_obra"),
                                rs.getString("descripcion_obra"),
                                rs.getString("imagen_obra"),
                                rs.getTimestamp("fecha_creacion"),
                                rs.getTimestamp("fecha_modificacion"));

                lstObras.add(obra);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        motosSql.desconectar();
        return lstObras;
    }
}
