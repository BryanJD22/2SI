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
        int resp = 0;

        motosSql.conectar();

        String sql = "INSERT INTO OBRA(titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES '(" + bean.getTituloObra()+"','"
                + bean.getDescripcionObra() +"','" +bean.getDuracionMin()+ "','"+bean.getImagenObra()+"','"+bean.getPrecio()+"')";
        System.out.println(sql);
        resp = motosSql.modificar(sql);
        System.out.println(resp);
        return resp;
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
                                rs.getString("imagen_obra"));

                lstObras.add(obra);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        motosSql.desconectar();
        return lstObras;
    }

    public ArrayList<Obra> Top10Ventas() {
        String sql = "SELECT \n" +
                "    obra.id_obra,\n" +
                "    obra.titulo_obra,\n" +
                "    obra.descripcion_obra,\n" +
                "    obra.duracion_min,\n" +
                "    obra.imagen_obra,\n" +
                "    obra.precio,\n" +
                "    SUM(compra.cantidad) AS total_ventas\n" +
                "FROM obra\n" +
                "JOIN obra_sala ON obra.id_obra = obra_sala.id_obra\n" +
                "JOIN compra ON obra_sala.id_obra_sala = compra.id_obra_sala\n" +
                "GROUP BY obra.id_obra\n" +
                "ORDER BY total_ventas DESC\n" +
                "LIMIT 10;";
        System.out.println(sql);
        ArrayList<Obra> top10Obras = new ArrayList<>();

        motosSql.conectar();
        ResultSet rs = motosSql.consultar(sql);

        try {
            while (rs.next()) {
                Obra obra = new Obra(
                        rs.getInt("id_obra"),
                        rs.getString("titulo_obra"),
                        rs.getString("descripcion_obra"),
                        rs.getInt("duracion_min"),
                        rs.getString("imagen_obra"),
                        rs.getBigDecimal("precio")
                );

                top10Obras.add(obra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        motosSql.desconectar();
        return top10Obras;
    }

    public ArrayList<Obra> Top10Puntuadas() {
        String sql = "SELECT obra.*, AVG(valoracion.valoracion) AS puntuacion_promedio, " +
                "COUNT(valoracion.id_valoracion) AS total_valoraciones" +
                " FROM obra JOIN valoracion ON obra.id_obra = valoracion.id_obra" +
                " GROUP BY obra.id_obra, obra.titulo_obra " +
                "ORDER BY puntuacion_promedio DESC, " +
                "total_valoraciones DESC LIMIT 10;";
        System.out.println(sql);
        ArrayList<Obra> top10Puntuadas = new ArrayList<>();

        motosSql.conectar();
        ResultSet rs = motosSql.consultar(sql);

        try {
            while (rs.next()) {
                Obra obra = new Obra(
                        rs.getInt("id_obra"),
                        rs.getString("titulo_obra"),
                        rs.getString("descripcion_obra"),
                        rs.getInt("duracion_min"),
                        rs.getString("imagen_obra"),
                        rs.getBigDecimal("precio")
                );

                top10Puntuadas.add(obra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        motosSql.desconectar();
        return top10Puntuadas;
    }
}
