package data.dao;

import data.dao.exception.DAOException;

public interface Dao<ModelType> {
	
	ModelType create(ModelType modelo) throws DAOException;
	
	ModelType recuperar(long codigo) throws DAOException;
	
	ModelType update(long codigo, String chave, String valor) throws DAOException;
	
	ModelType delete(ModelType modelo) throws DAOException;

}