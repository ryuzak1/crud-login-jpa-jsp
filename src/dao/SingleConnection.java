package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
    private static String banco = "jdbc:postgresql://localhost:5432/crud-login?autoReconnect=true";
    private static String usuario ="postgres";
    private static String senha = "123";
    private static Connection connection = null;


    static {
        conectar();
    }
    public static void conectar(){
        if (connection == null){
            try{
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(banco,usuario,senha);
                System.out.println("Conectado ao banco com sucesso!");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Erro ao contectar com banco"+e.getCause());
            }

        }


    }

    public static Connection getConnection(){

        return connection;
    }

}
