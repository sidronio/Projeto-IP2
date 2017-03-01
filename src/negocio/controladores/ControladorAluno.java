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
					throw new NegocioException("O aluno já está cadastrado");
			}	
			else
				throw new NegocioException("Senha inválida");
		}
		else
			throw new NegocioException("Cpf inválido");
	}
	
	public void remover(Aluno aluno) throws  NegocioException{
		if(this.repositorio.existeCodigo(aluno.getCpf()))
			this.repositorio.remover(aluno);
		else
			throw new NegocioException("O aluno não está cadastrado");
	}
	public void atualizar(Aluno aluno) throws  NegocioException{
		if(this.repositorio.existeCodigo(aluno.getCpf()))
			this.repositorio.atualizar(aluno);
		else
			throw new NegocioException("O aluno não está cadastrado");
		
	}
	public ArrayList<Aluno> listar()throws NegocioException{
		if(this.repositorio.listar().isEmpty())
			throw new NegocioException("Não esistem Alunos cadastrados");
		else
			return this.repositorio.listar();
	}
	
}
