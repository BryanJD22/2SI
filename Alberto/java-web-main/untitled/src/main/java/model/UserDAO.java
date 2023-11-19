package model;

import beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO implements DAO<User, Integer> {
    MotorSQL motosSql;

    public UserDAO() {
        this.motosSql = new MotorSQL();
    }
    @Override
    public int add(User bean) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(User bean) {
        return 0;
    }

    @Override
    public ArrayList<User> findAll() throws SQLException {
        String sql = "SELECT * FROM USERS";
        ArrayList<User> usuarios = new ArrayList<>();

        motosSql.conectar();
        ResultSet rs = motosSql.consultar(sql);

        try {
            while (rs.next()) {
                User user = new User(rs.getString("NOMBRE"),
                        rs.getString("EMAIL"));

                usuarios.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        motosSql.desconectar();
        return usuarios;
    }
}
