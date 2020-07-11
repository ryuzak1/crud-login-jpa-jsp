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

@WebServlet("/ServletControlerUsuario")
public class ServletControlerUsuario extends HttpServlet {
    DaoUsuario usuario = new DaoUsuario();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String acao = request.getParameter("acao");
        String email = request.getParameter("email");


        if (acao.equals("deletar")) {
            try {

                if (usuario.deletarUsuario(email)) {
                    System.out.println("Usuario Deletado com sucesso!");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    System.out.println("Erro ao deletar Usuário");
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erro ao tentar deletar usuário");

            }
        } else if (acao.equals("editar")) {
            try {
                Usuario usuarioEditar = usuario.PesquisarUsuario(email);
                System.out.println(usuarioEditar.getNome());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("criar-conta.jsp");
                request.setAttribute("usuario", usuarioEditar);
                requestDispatcher.forward(request, response);


            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erro ao tentar editar");

            }
        }


    }
}
