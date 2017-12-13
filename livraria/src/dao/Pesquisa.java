package dao;

import java.util.Optional;
import dao.LivroDao;

public class Pesquisa {
    public static void main(String[] args) {

        LivroDao dao = new LivroDao();

        List <livro> livros = livroDao.consultar("A");

        for(Livro livro: livros) {
            System.out.println("Codigo:" + livro.getCodigo());
            System.out.println("Titulo:" + livro.getTitulo());
            System.out.println("Descrição:" + livro.getDescricao());
            System.out.println("Imagem:" + livro.getImagem());
            System.out.println("Preço:" + livro.getPreco());
        }
    }
}