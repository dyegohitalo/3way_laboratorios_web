package data.dao;

import java.util.List;
import data.dao.exception.DAOException;
import data.model.Livro;

public interface ProjecoesLivro {
	
	List<Livro> livrosCadastrados() throws DAOException;
}