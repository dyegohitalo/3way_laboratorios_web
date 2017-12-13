package data;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/livraria", "postgres", "root");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro de Driver de Banco!!!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro de conexão com o banco!!!");
            e.printStackTrace();
        }
        return null;
    }
}