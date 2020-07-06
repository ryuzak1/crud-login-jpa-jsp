package dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DaoUsuario {


    private Connection connection;

    public boolean validarUsuario(String email, String senha) {
        return true;

    }

    public boolean cadastrarUsuario(Usuario usuario) {
        try {
            String sql = "insert into contas(nome,senha,email) values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            connection.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro mensagem" + e.getMessage());
            System.out.println("-----");
            return false;

        }

    }
}
