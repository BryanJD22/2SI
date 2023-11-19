/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action;

import DAO.UsuarioDAO;
import beans.Usuario;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HOME
 */
public class UsuarioAction implements IAction{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        String resp = "";
        String caso = request.getParameter("CASO");
        switch(caso){
            case "FIND_ALL":
                resp = findAll(request,response);
                break;
            case "REGISTER":
                register(request,response);
                break;
            
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void register(HttpServletRequest request, HttpServletResponse response) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        String NOMBRE = request.getParameter("NOMBRE");
        String EMAIL = request.getParameter("EMAIL");
        String PASS = request.getParameter("PASS");
        Usuario usuario = new Usuario(NOMBRE, EMAIL, PASS);
        usuarioDao.add(usuario);
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        ArrayList<Usuario> usuarios = usuarioDao.findAll();
        return Usuario.toArrayJson(usuarios);
    }
    
}
