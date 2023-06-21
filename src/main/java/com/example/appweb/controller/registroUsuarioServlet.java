package com.example.appweb.controller;

import java.io.*;
import java.rmi.server.ServerCloneException;
import java.util.List;

import com.example.appweb.model.Data.DAO.UsuarioDAO;
import com.example.appweb.model.Data.DBGenerator;
import com.example.appweb.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.jooq.DSLContext;

@WebServlet(name = "registroUsuarioServlet", value = "/registroUsuario")
public class registroUsuarioServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("RegistroUsuario");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher respuesta = request.getRequestDispatcher("/registroUsuario.jsp");
        respuesta.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher respuesta = request.getRequestDispatcher("/registroErroneo.jsp");
        if(request.getParameter("edad").length() != 0 && request.getParameter("nombre").length() != 0 && request.getParameter("rut").length() != 0){
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String rut = request.getParameter("rut");

            Usuario usuario = new Usuario(nombre, edad, rut);

            try {
                if (agregarUsuario(usuario) == true){
                    request.setAttribute("Usuario", usuario);
                    respuesta = request.getRequestDispatcher("/registroExitoso.jsp");
                } else {
                    respuesta = request.getRequestDispatcher("/usuarioRepetido.jsp");
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        respuesta.forward(request, response);
    }
    private boolean agregarUsuario(Usuario usuario) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("RegistroUsuario");
        List<Usuario> usuario1 = UsuarioDAO.obtenerUsuario(query,"rut",usuario.getRut());
        if(usuario1.size() != 0){
            return false;
        }
        else{
            UsuarioDAO.agregarUsuario(query,usuario);
            return true;
        }
    }
}
