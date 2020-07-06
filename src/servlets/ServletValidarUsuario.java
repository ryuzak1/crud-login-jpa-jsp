package servlets;

import dao.DaoUsuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletValidarUsuario")
public class ServletValidarUsuario extends HttpServlet {
    DaoUsuario usuario = new DaoUsuario();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (usuario.validarUsuario(email, senha)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
            request.setAttribute("nomeUsuario",email);
            request.setAttribute("listadeusuarios",usuario.listarUsuarios());
            requestDispatcher.forward(request,response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("errologin.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
