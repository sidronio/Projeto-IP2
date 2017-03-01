package negocio.controladores;

import java.util.ArrayList;
import java.util.Calendar;

import dados.InterfaceCRUD;
import dados.RepositorioEmprestimos;
import exceptions.NegocioException;
import negocio.beans.Aluno;
import negocio.beans.Emprestimo;
import negocio.beans.Livro;

public class ControladorEmprestimo {
	
	private InterfaceCRUD<Emprestimo,Integer> repositorio;
	
	public ControladorEmprestimo(){
		this.repositorio = new RepositorioEmprestimos();
	}
	
	public void cadastrar(Emprestimo emprestimo) throws NegocioException{
		if(repositorio.existe(emprestimo) == null){
			Calendar dataEntrega = Calendar.getInstance();
			dataEntrega.add(Calendar.DATE, 15);
			emprestimo.setDataAluguel(Calendar.getInstance());
			emprestimo.setDataEntrega(dataEntrega);
			this.repositorio.cadastrar(emprestimo);
		}
		else
			throw new NegocioException("O Emprestimo já está cadastrado");
			
	}
	public void remover(Emprestimo emprestimo) throws NegocioException{
		if(repositorio.existe(emprestimo) != null){
			this.repositorio.remover(emprestimo);
		}
		else
			throw new NegocioException("O Emprestimo não existe");
		
	}
	public void atualizar(Emprestimo emprestimo) throws NegocioException{
		if(this.repositorio.existe(emprestimo) != null)
			this.repositorio.atualizar(emprestimo);
		else
			throw new NegocioException("O empréstimo não está cadastrado");
	}
	public ArrayList<Emprestimo> listar() throws NegocioException{
		if(this.repositorio.listar().isEmpty()){
			throw new NegocioException("Não existem empréstimos cadastrados");
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
