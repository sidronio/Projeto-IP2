package negocio.controladores;

import java.util.ArrayList;

import exceptions.NegocioException;
import negocio.beans.Administrador;
import negocio.beans.Aluno;
import negocio.beans.Emprestimo;
import negocio.beans.Livro;
import negocio.beans.Usuario;

public class Fachada {
	private ControladorAluno alunos;
	private ControladorAdministrador administradores;
	private ControladorLivro livros;
	private ControladorEmprestimo emprestimos;
	
	private static Fachada instance;
	
	private Fachada(){
		this.alunos = new ControladorAluno();
		this.livros = new ControladorLivro();
		this.administradores = new ControladorAdministrador();
		this.emprestimos = new ControladorEmprestimo();
	}
	
	public static Fachada getInstance(){
		if(instance == null){
			instance = new Fachada();
		}
		return instance;
	}
	public Usuario autenticar(String cpf, String senha) throws NegocioException{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try{
			usuarios.addAll(this.administradores.listar());
			usuarios.addAll(this.alunos.listar());
		}catch(NegocioException e){
		
		}
		for(Usuario a : this.administradores.listar()){
			if(a.getCpf().equals(cpf)){
				if(a.getSenha().equals(senha))
					return a;	
				else
					throw new NegocioException("Senha incorreta");
			}
		}
		throw new NegocioException("CPF não cadastrado");
		
	}
	public void cadastrarAluno(Aluno aluno) throws NegocioException{
		this.alunos.cadastrar(aluno);
	}
	public void cadastraradministrador(Administrador administrador) throws NegocioException{
		this.administradores.cadastrar(administrador);
	}
	public void cadastrarLivro(Livro livro) throws NegocioException{
		this.livros.cadastrarLivro(livro);
	}
	public void cadastrarEmpréstimo(Emprestimo emprestimo) throws NegocioException{
		this.emprestimos.cadastrar(emprestimo);
	}
	public void alterarAluno(Aluno aluno) throws NegocioException{
		this.alunos.atualizar(aluno);
	}
	public void alterarAdministrador(Administrador administrador) throws NegocioException{
		this.administradores.atualizar(administrador);
	}
	public void alterarLivro(Livro livro) throws NegocioException{
		this.livros.atualizar(livro);
	}
	public void alterarEmprestimo(Emprestimo emprestimo) throws NegocioException{
		this.emprestimos.atualizar(emprestimo);
	}
	public void removerAluno(Aluno aluno) throws NegocioException{
		this.alunos.cadastrar(aluno);
	}
	public void removerAdministrador(Administrador administrador) throws NegocioException{
		this.administradores.remover(administrador);
	}
	public void removerLivro(Livro livro) throws NegocioException{
		this.livros.remover(livro);
	}
	public ArrayList<Aluno> listarAlunos() throws NegocioException{
		return this.alunos.listar();
	}
	public ArrayList<Administrador> listarAdministrador() throws NegocioException{
		return this.administradores.listar();
	}
	public ArrayList<Livro> listarLivros() throws NegocioException{
		return this.livros.listar();
	}
	
}
