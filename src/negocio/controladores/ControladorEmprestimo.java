package negocio.controladores;

import java.util.ArrayList;
import java.util.Calendar;

import dados.InterfaceCRUD;
import dados.RepositorioEmprestimos;
import dados.RepositorioLivros;
import exceptions.NegocioException;
import negocio.beans.Emprestimo;
import negocio.beans.Livro;

public class ControladorEmprestimo {
	
	private InterfaceCRUD<Emprestimo,Integer> repositorio;
	private InterfaceCRUD<Livro,Integer> repositorioLivros;
	
	public ControladorEmprestimo(){
		this.repositorio = RepositorioEmprestimos.getInstance();
		this.repositorioLivros = RepositorioLivros.getInstance(); 
	}
	
	public void cadastrar(Emprestimo emprestimo) throws NegocioException{
		if(repositorio.existe(emprestimo) == null){
			if(emprestimo.getLivro().getExemplares() > 0){
				Calendar dataEntrega = Calendar.getInstance();
				dataEntrega.add(Calendar.DATE, 15);
				emprestimo.setDataAluguel(Calendar.getInstance());
				emprestimo.setDataEntrega(dataEntrega);
				emprestimo.getLivro().setExemplares(emprestimo.getLivro().getExemplares() -1);
				repositorioLivros.atualizar(emprestimo.getLivro());
				this.repositorio.cadastrar(emprestimo);
			}else
				throw new NegocioException("N�o existem exemplares do livro dispon�veis");
		}
		else
			throw new NegocioException("O Emprestimo j� est� cadastrado");
			
	}
	public void remover(Emprestimo emprestimo) throws NegocioException{
		if(repositorio.existe(emprestimo) != null){
			this.repositorio.remover(emprestimo);
		}
		else
			throw new NegocioException("O Emprestimo n�o existe");
		
	}
	public void atualizar(Emprestimo emprestimo) throws NegocioException{
		if(this.repositorio.existe(emprestimo) != null)
			this.repositorio.atualizar(emprestimo);
		else
			throw new NegocioException("O empr�stimo n�o est� cadastrado");
	}
	public ArrayList<Emprestimo> listar() throws NegocioException{
		if(this.repositorio.listar().isEmpty()){
			throw new NegocioException("N�o existem empr�stimos cadastrados");
		}
		else
			return this.repositorio.listar();
	}
	public ArrayList<Emprestimo> listar(String cpf){
		ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		for(Emprestimo e : this.repositorio.listar()){
			if(e.getAluno().getCpf().equals(cpf)){
				emprestimos.add(e);
				
			}
		}
		return emprestimos;
	}
	
	
	
}
