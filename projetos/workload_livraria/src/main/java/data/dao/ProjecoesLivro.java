package data.dao;

import java.util.List;
import data.dao.exception.DAOException;
import data.model.Livro;

public interface ProjecoesLivro {

	List<Livro> livrosPorChaveValor(String chave, String valor) throws DAOException;
	
	List<Livro> livrosPorId_livro(long id_livro) throws DAOException;
	
	List<Livro> livrosPorPreco(double preco) throws DAOException;
}