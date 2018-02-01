package data.dao.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/livraria_ter-qui", "postgres", "postgres");
		} catch (ClassNotFoundException e) {
			System.out.println("Erro do driver de banco!!!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro de conexao com o banco de dados!!!");
			e.printStackTrace();
		}

		return null;		
	}
}