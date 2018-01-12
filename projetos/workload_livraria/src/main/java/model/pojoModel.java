package model;

import java.io.Serializable;

public class pojoModel implements Serializable{

	private static final long serialVersionUID = 8982198782797245834L;

	//Atributos
	private Long codigo;
	private String titulo;
	private String autor;
	private String descricao;
	private double preco;
	private String imagem;


	//Construtor Padrão
	public pojoModel() {

	}

	//Construtor com Parâmetros
	public pojoModel(Long codigo, String titulo, String autor, String descricao, 
			double preco, String imagem) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.descricao = descricao;
		this.preco = preco;
		this.imagem = imagem;

	}

	//Getters e Setters
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	//Sobrescritas de java.lang.Object
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof pojoModel){
			pojoModel pojo = (pojoModel) obj;

			if (pojo.codigo != null && this.codigo != null){
				return pojo.getCodigo().equals(codigo);
			}
		}

		return false;
	}

	@Override
	public int hashCode() {

		return this.codigo != null ? this.codigo.hashCode():0;
	}

	@Override
	public String toString() {

		return this.codigo + ", " + this.titulo + ", " + this.autor + ", " + this.descricao + ", " 
				+ this.preco + ", " + this.imagem;

	}

}

