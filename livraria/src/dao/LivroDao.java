package dao;

import java.sql.*;
import java.util.logging.Logger;

public class LivroDao {
    Logger LOG = Logger.getGlobal();
    private static final String OBTER_POR_ID_SQL = "SELECT AUTOR, TITULO, COD_LIVRO, IMAGEM,"
            + "PRECO, DESCRICAO FROM ESTOQUE WHERE COD_LIVRO = ?";
    private static final String CONSULTAR_SQL = "SELECT COD_LIVRO, TITULO, AUTOR, PRECO,"
            + " IMAGEM, DESCRICAO FROM ESTOQUE WHERE TITULO LIKE ?";
    pulbic Livro consultar(int codigo) {
        Livro livro = null;
        try (Connection conexao = FabricaConexao.getConexao();
             PreparedStatement consulta = conexao.preparedStatement(OBTER_POR_ID_SQL);) {

            consulta.setInt(1, codigo);

            Result resultado = consulta.executeQuery();

            if (resultado.next)){
                livro = new Livro();
                livro.setAutor(resultado.getString("AUTOR"));
                livro.setCodigo(resultado.getString("COD_LIVRO"));
                livro.setImagem(resultado.getString("IMAGEM"));
                livro.setPreco(resultado.getString("PRECO"));
                livro.setTitulo(resultado.getString("TITULO"));
                livro.setDescricao(resultado.getString("DESCRICAO"));
            }
            resultado.close();

        } catch (SQLException e) {
            LOG.severe(e.toString());
        }
        return livro;
    }
        public List<Livro>(String titulo){

    }
}

