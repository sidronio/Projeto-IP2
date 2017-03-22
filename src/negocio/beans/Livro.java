package negocio.beans;

import java.io.Serializable;

public class Livro implements Serializable {
	
	private long isbn;
	private String titulo;
	private String editora;
	private String autor;
	private int exemplares;
	
	public Livro(int isbn, String titulo, String editora, String autor,int exemplares) {
		super();
		this.setIsbn(isbn);
		this.setAutor(autor);
		this.setEditora(editora);
		this.setTitulo(titulo);
		this.setExemplares(exemplares);
	}
	
	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getExemplares() {
		return exemplares;
	}

	public void setExemplares(int exemplares) {
		this.exemplares = exemplares;
	}
	
	@Override
	public String toString(){
		return this.getTitulo();
	}
	
	
	

}
