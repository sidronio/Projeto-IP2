package negocio.controladores;

import java.util.ArrayList;

import dados.InterfaceCRUD;
import dados.RepositorioLivros;
import exceptions.NegocioException;
import negocio.beans.Livro;

public class ControladorLivro {
	private InterfaceCRUD<Livro,Integer> repositorio;
	
	public ControladorLivro(){
		this.repositorio = new RepositorioLivros();
	}
	
	public void cadastrarLivro(Livro livro) throws NegocioException{
		if(repositorio.existe(livro) == null){
			this.repositorio.cadastrar(livro);
		}
		else
			throw new NegocioException("O livro j� est� cadastrado");
			
	}
	public void remover(Livro livro) throws NegocioException{
		if(repositorio.existe(livro) != null){
			this.repositorio.remover(livro);
		}
		else
			throw new NegocioException("O livro n�o existe");
		
	}
	public void atualizar(Livro livro) throws NegocioException{
		if(repositorio.existe(livro) != null){
			this.repositorio.atualizar(livro);
		}
		else
			throw new NegocioException("O livro n�o existe");
		
	}
	public ArrayList<Livro> listar() throws NegocioException{
		if(this.repositorio.listar().isEmpty()){
			throw new NegocioException("N�o existem livros cadastrados");
		}
		else
			return this.repositorio.listar();
	}
}
