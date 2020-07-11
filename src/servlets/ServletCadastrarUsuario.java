package servlets;

import dao.DaoUsuario;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletCadastrarUsuario")
public class ServletCadastrarUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoUsuario daoUsuario = new DaoUsuario();
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        Usuario usuario = new Usuario(nome,senha,email);

        Usuario usuarioPesquisa = daoUsuario.PesquisarUsuario(email);
        if(usuarioPesquisa == null){

        if(daoUsuario.cadastrarUsuario(usuario)){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("sucessoCadastro.jsp");
            requestDispatcher.forward(request,response);
        }else {

            System.out.println("Usuário não cadastrado");
        }
        }else{
            if (daoUsuario.atualizarUsuario(usuario)){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("sucessoCadastro.jsp");
                requestDispatcher.forward(request,response);

            }
            else {
                System.out.println("Usuário não cadastrado");
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
