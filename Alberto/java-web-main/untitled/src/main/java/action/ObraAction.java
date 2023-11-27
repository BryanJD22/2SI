package action;

import beans.Obra;
import beans.User;
import model.ObraDAO;
import model.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObraAction implements IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String pagDestino = "";
        String action = request.getParameter("ACTION");

        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_ALL":
                pagDestino = findAll(request, response);
                break;
            case "ADD":
                pagDestino = addObra(request, response);
                break;
            case "FINDBY_ID":
                pagDestino = findbyid(request, response);
                break;
            case "TOP10VENTAS":
                pagDestino = top10Ventas(request, response);
                break;

            case "TOP10PUNTUADAS":
                pagDestino = top10Puntuas(request, response);
                break;

        }
        return pagDestino;
    }

    private String findbyid(HttpServletRequest request, HttpServletResponse response) {
        String idSala = request.getParameter("IDSALA");

        if (idSala != null && !idSala.isEmpty()) {
            ArrayList<Obra> obrasBySala = new ObraDAO().findObrasBySala(Integer.parseInt(idSala));

            return Obra.toArrayJson(obrasBySala);
        } else {

            return "{'error': 'Missing or empty IDSALA parameter'}";
        }
    }

    private String top10Puntuas(HttpServletRequest request, HttpServletResponse response) {
        ObraDAO obraDAO = new ObraDAO();
        ArrayList<Obra> top10Puntuadas = obraDAO.Top10Puntuadas();

        return Obra.toArrayJson(top10Puntuadas);
    }

    private String top10Ventas(HttpServletRequest request, HttpServletResponse response) {
        ObraDAO obraDAO = new ObraDAO();
        ArrayList<Obra> top10Ventas = obraDAO.Top10Ventas();
        return Obra.toArrayJson(top10Ventas);

    }



    private String addObra(HttpServletRequest request, HttpServletResponse response) {
        ObraDAO obraDAO = new ObraDAO();
        String tituloObra = request.getParameter("TITULO");
        String desc = request.getParameter("DESC");
        String duracion = request.getParameter("DURACION");
        String img = request.getParameter("IMG");
        String precio = request.getParameter("PRECIO");
        BigDecimal precioObra = new BigDecimal(precio);
        Obra obra = new Obra(tituloObra,desc, Integer.parseInt(duracion),precioObra,img);
        int respuesta = obraDAO.add(obra);
        return "{\"lineas_afectadas\":"+respuesta+"}";

    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ObraDAO obraDAO = new ObraDAO();
        ArrayList<Obra> obras = obraDAO.findAll();
        System.out.println(obras);
        return Obra.toArrayJson(obras);

    }
}
