package dao;
import model.Livro;
public interface Dao<ModelType> {
    //CRUD = Criar , Recuperar, Alterar e Delete.
    ModelType criar (ModelType modelo);
    ModelType recuperar (ModelType modelo);
    ModelType alterar (ModelType modelo);
    ModelType delete (ModelType modelo);
}
