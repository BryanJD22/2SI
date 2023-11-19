/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioDAO;
import model.beans.Usuario;

/**
 *
 * @author HOME
 */
public class UsuarioAction implements IAction{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        String caso = request.getParameter("CASO");
        String resp = "";
        switch(caso){
            case "LOGIN":
                    resp = login(request,response);
                    break;
        }
        return resp;
    }

    private String login(HttpServletRequest request, HttpServletResponse response) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String ID_USUARIO = request.getParameter("id_usuario");
        String EMAIL = request.getParameter("email");
        String PASS = request.getParameter("pass");
        String NOMBRE = request.getParameter("nombre");
        String ID_ROL = request.getParameter("rol");


        
        return "";
        
    }
    
}
