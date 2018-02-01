package data.dao.conection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = FabricaConexao.getConnection();
		
		if (connection != null) {
			System.out.println("Conexão estabelecida com sucesso!!!");
		} else {
			System.out.println("Conexão não foi estabelecida!");
		}
	}

}