
package controller.Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductoDAO;
import model.beans.Producto;


public class ProductoAction implements IAction{

   

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        String caso = request.getParameter("CASO");
        String resp = "";
        switch(caso){
            case "FIND_ALL":
                resp = findAll(request,response);
                break;
            case "FILTER":
                resp = findbyFilter(request,response);
                break;          
        }
        
        return resp;
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO productoDao = new ProductoDAO();
        ArrayList<Producto> productos = productoDao.findAll();
        return Producto.toArrayJson(productos);
    }
    
    private String findbyFilter(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO productoDao = new ProductoDAO();
        String tipo = request.getParameter("FILTER");
        ArrayList<Producto> productos = productoDao.findbyFilter(tipo);
        return Producto.toArrayJson(productos);
    }
    
}
