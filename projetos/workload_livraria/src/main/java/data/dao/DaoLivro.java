package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dao.conection.FabricaConexao;
import data.model.Livro;

public class DaoLivro implements Dao<Livro>, ProjecoesLivro {

	private static final String OBTER_LIVRO_COD = "" + "Select * from estoque e where e.cod_livro = ?;";
	private static final String OBTER_LIVROS_POR_CHAVE_VALOR = "Select * from estoque e where e.? like ?;";

	@Override
	public Livro create(Livro modelo) {
		try (Connection con = FabricaConexao.getConnection();) {
			PreparedStatement ps = con.prepareStatement(Livro.CREATE_LIVRO);
			ps.setString(1, modelo.getCodigo());
			ps.setString(2, modelo.getTitulo());
			ps.setString(3, modelo.getDescricao());
			ps.setString(4, modelo.getAutor());
			ps.setDouble(5, modelo.getPreco());
			ps.setBytes(6, modelo.getImagem());

			ResultSet resultadoBanco = ps.executeQuery();
			Livro livro = criaObjetoLivroFromResultSet(resultadoBanco);
			
			return livro;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public Livro recuperar(long id) {
		try (Connection con = FabricaConexao.getConnection();) {
			PreparedStatement ps = con.prepareStatement(OBTER_LIVRO_COD);
			ps.setInt(1, Integer.parseInt(String.valueOf(id)));

			ResultSet resultadoBanco = ps.executeQuery();
			Livro livro = criaObjetoLivroFromResultSet(resultadoBanco);
			
			return livro;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Livro> livrosPorChaveValor(String chave, String valor) {
		List<Livro> livros = new ArrayList<>();

		try (Connection con = FabricaConexao.getConnection();) {
			PreparedStatement ps = con.prepareStatement(OBTER_LIVROS_POR_CHAVE_VALOR);
			ps.setString(1, chave);
			ps.setString(2, "%" + valor + "%");

			ResultSet resultadoBanco = ps.executeQuery();
			while (resultadoBanco.next()) {

				livros.add(criaObjetoLivroFromResultSet(resultadoBanco));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livros;
	}

	@Override
	public List<Livro> livrosPorCodigo(String codigo) {
		return livrosPorChaveValor(Livro.NOME_COL_COD_LIVRO, codigo);
	}

	@Override
	public List<Livro> livrosPorPreco(double preco) {
		return livrosPorChaveValor(Livro.NOME_COL_PRECO_LIVRO, String.valueOf(preco));
	}

	private Livro criaObjetoLivroFromResultSet(ResultSet resultadoBanco) throws SQLException {
		Livro livro = new Livro();
		livro.setId(resultadoBanco.getLong(Livro.NOME_COL_ID_LIVRO));
		livro.setCodigo(resultadoBanco.getString(Livro.NOME_COL_COD_LIVRO));
		livro.setTitulo(resultadoBanco.getString(Livro.NOME_COL_TITULO_LIVRO));
		livro.setDescricao(resultadoBanco.getString(Livro.NOME_COL_DESC_LIVRO));
		livro.setAutor(resultadoBanco.getString(Livro.NOME_COL_AUTOR_LIVRO));
		livro.setImagem(resultadoBanco.getBytes(Livro.NOME_COL_IMAGEM_LIVRO));
		livro.setPreco(resultadoBanco.getDouble(Livro.NOME_COL_PRECO_LIVRO));
		return livro;
	}

	@Override
	public Livro update(long id, String chave, String valor) {
		try (Connection con = FabricaConexao.getConnection();){
			PreparedStatement ps = con.prepareStatement(Livro.UPDATE_LIVRO);
			ps.setString(1, chave);
			ps.setString(2, valor);
			ps.setString(3, String.valueOf(id));
			
			int totalLinhasAlteradas = ps.executeUpdate();
			if (totalLinhasAlteradas > 0) {
				return recuperar(id);
			} else {
				throw new SQLException("Nao foi possivel atualizar o livro com id: "+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Livro delete(Livro modelo) {
		try (Connection con = FabricaConexao.getConnection();){
			PreparedStatement ps = con.prepareStatement(Livro.DELETE_LIVRO);
			ps.setString(1, String.valueOf(modelo.getId()));
			
			int totalLinhasAlteradas = ps.executeUpdate();
			if (totalLinhasAlteradas > 0) {
				return modelo;
			} else {
				throw new SQLException("Nao foi possivel remover o livro com id: " + modelo.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}