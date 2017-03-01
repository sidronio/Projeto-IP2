package negocio.controladores;

import java.util.ArrayList;

import dados.InterfaceCRUD;
import dados.RepositorioAlunos;
import exceptions.NegocioException;
import negocio.beans.Aluno;

public class ControladorAluno {
	
	private InterfaceCRUD<Aluno,String> repositorio;
	
	public ControladorAluno(){
		this.repositorio = new RepositorioAlunos();
	}
	
	
	public void cadastrar(Aluno aluno) throws NegocioException{
		if(Validadores.validaCPF(aluno.getCpf())){
			if(Validadores.validaSenha(aluno.getSenha())){
				if(this.repositorio.existe(aluno) == null)
					this.repositorio.cadastrar(aluno);
				else
					throw new NegocioException("O aluno j� est� cadastrado");
			}	
			else
				throw new NegocioException("Senha inv�lida");
		}
		else
			throw new NegocioException("Cpf inv�lido");
	}
	
	public void remover(Aluno aluno) throws  NegocioException{
		if(this.repositorio.existeCodigo(aluno.getCpf()))
			this.repositorio.remover(aluno);
		else
			throw new NegocioException("O aluno n�o est� cadastrado");
	}
	public void atualizar(Aluno aluno) throws  NegocioException{
		if(this.repositorio.existeCodigo(aluno.getCpf()))
			this.repositorio.atualizar(aluno);
		else
			throw new NegocioException("O aluno n�o est� cadastrado");
		
	}
	public ArrayList<Aluno> listar()throws NegocioException{
		if(this.repositorio.listar().isEmpty())
			throw new NegocioException("N�o esistem Alunos cadastrados");
		else
			return this.repositorio.listar();
	}
	
}
