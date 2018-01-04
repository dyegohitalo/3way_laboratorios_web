package dao;

import data.FabricaConexao;
import model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class LivroDao implements Dao<Livro>{

    private static final String NOME_COL_AUTOR_LIVRO = "autor";
    private static final String NOME_COL_AUTOR_LIVRO = "cod_livro";
    private static final String NOME_COL_AUTOR_LIVRO = "titulo";
    private static final String NOME_COL_AUTOR_LIVRO = "imagem";
    private static final String NOME_COL_AUTOR_LIVRO = "descricao";
    private static final String NOME_COL_AUTOR_LIVRO = "preco";
    private static final String OBTER_LIVROS_POR_TITULO= "";


    private static final String OBTER_LIVRO_COD = "Select * from estoque e where e.cod_livro = ?;";
    private static final String OBTER_LIVRO_COD = "Select * from estoque e where titulo like '%A%';

    @override
    public Livro criar (Livro modelo){
        return null;
    }

    @override
    public Livro recuperar (Long id) {
        try (Connection connection = FabricaConexao.getConnection();) {
            PreparedStatement ps = connection.prepareStatement(OBTER_LIVRO_COD);
            ps.setInt(1, Integer.parseInt(String.valueOf(id)));
            Resultset resultadoBancoanco ps.executeQuery();
            livro.setAutor(resultadoBanco.getString("AUTOR"));
            livro.setAutor(resultadoBanco.getInt("COD_LIVRO"));
            livro.setAutor(resultadoBanco.getString("IMAGEM"));
            livro.setAutor(resultadoBanco.getDouble("PRECO"));
            livro.setAutor(resultadoBanco.getString("TITULO"));
            livro.setAutor(resultadoBanco.getString("DESCRICAO"));

            connection.close();

            return livro;
        } catch (SQLException e) {
            System.out.println("Erro de conexão com o banco!!!");
            e.printStackTrace();
        }
    }

    @override
    public Livro update (Livro modelo){
        return null;
    }

    @override
    public Livro delete (Livro modelo){
        return null;
    }

    public List<Livro> consultar(String titulo){
        List<Livro> livros = new ArrayList<>();
        try (Connection connection = FabricaConexao.getConnection();) {
            PreparedStatement ps = connection.prepareStatement(OBTER_LIVROS_POR_TITULO);
            ps.setString(1, "%"+ titulo +"%");

            Resultset resultadoBancoanco ps.executeQuery();
            while (resultadoBanco.next()) {
                livro.setAutor(resultadoBanco.getString("AUTOR"));
                livro.setAutor(resultadoBanco.getString("COD_LIVRO"));
                livro.setAutor(resultadoBanco.getString("IMAGEM"));
                livro.setAutor(resultadoBanco.getDouble("PRECO"));
                livro.setAutor(resultadoBanco.getString("TITULO"));
                livro.setAutor(resultadoBanco.getString("DESCRICAO"));

                livro.add(livro);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão com o banco!!!");
            e.printStackTrace();
            return livro;
        }
    }

}
