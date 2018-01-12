package dao;

public interface Dao<ModelType> {
	
	// CRUD = Create, Recuperar, Update, Delete
	
	ModelType criar(ModelType modelo);
	
	ModelType recuperar(Long codigo);
	
	ModelType update(ModelType modelo);
	
	ModelType delete(Long codigo);	

}
