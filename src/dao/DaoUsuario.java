package dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {


    private Connection connection;

    public DaoUsuario() {
        connection = SingleConnection.getConnection();
    }


    public boolean cadastrarUsuario(Usuario usuario) {
        try {
            String sql = "insert into contas(nome,senha,email) values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,usuario.getNome());
            statement.setString(2,usuario.getSenha());
            statement.setString(3,usuario.getEmail());
            statement.execute();
           // connection.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro mensagem" + e.getMessage());
            System.out.println("-----");
            return false;

        }
    }

    public boolean validarUsuario(String email, String senha){

        try {
            String sql = "select * from contas where email = '"+email+"'and senha = '"+senha+"'";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

          if (resultSet.next()){
              System.out.println("achou!");
              return true;

          }else {
              System.out.println("Usuario não localizado");
              return false;
          }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro na busca o usuário "+e.getMessage());

        }
        return false;
    }
    public List<Usuario> listarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();

        try {

            String sql = "select * from contas";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet =statement.executeQuery();

            while (resultSet.next()){
                Usuario usuario = new Usuario(resultSet.getString("nome"),resultSet.getString("senha"),resultSet.getString("email"));
                usuarios.add(usuario);
            }

            return usuarios;

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("erro ao listar usuários "+e.getMessage());

        }
        return usuarios;
    }
}
