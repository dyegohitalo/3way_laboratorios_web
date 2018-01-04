package dao;
import model.Livro;
public interface Dao<ModelType> {
    //CRUD = Criar , Recuperar, Alterar e Delete.
    ModelType criar (ModelType modelo);
    ModelType recuperar (Long id);
    ModelType alterar (ModelType modelo);
    ModelType delete (Long id);
}
