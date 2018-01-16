package service;

import java.util.ArrayList;
import java.util.List;
import data.dao.DaoLivro;
import data.dao.exception.DAOException;
import data.model.Livro;
import service.exception.ServiceException;

public class LivroService implements LivroServiceInterface {

	@Override
	public List<Livro> listLivros() throws ServiceException {
		List<Livro> livros = new ArrayList<>();
		
		try {
			DaoLivro DaoLivro = new DaoLivro();
			List<Livro> livrosPorPreco = DaoLivro.livrosPorPreco(0);
			if (livrosPorPreco != null) {
				livros = livrosPorPreco;
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Erro no banco ao listar livros: " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Erro desconhecido no banco ao listar livros.");
		}
		
		return livros;
	}

}