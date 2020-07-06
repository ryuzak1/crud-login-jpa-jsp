package servlets;

import dao.DaoUsuario;

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


        if (acao.equals("deletar")){
            try {

                if (usuario.deletarUsuario(email)){
                    System.out.println("Usuario Deletado com sucesso!");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                    requestDispatcher.forward(request,response);
                }else{
                    System.out.println("Erro ao deletar Usuário");
                }

            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Erro ao tentar deletar usuário");

            }
        }




    }
}
