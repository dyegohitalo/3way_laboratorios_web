package data;

import java.sql.*;

public class TestaConexao {
    public static void main(String[] args) {
        Connection con;
        try {
            con = FabricaConexao.getConexao();
            if (con != null)
                System.out.println("Inf.: A conexão estabelecida!!!");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
