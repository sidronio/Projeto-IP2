package negocio.controladores;

import java.util.ArrayList;

import dados.InterfaceCRUD;
import dados.RepositorioAdministradores;
import exceptions.NegocioException;
import negocio.beans.Administrador;

public class ControladorAdministrador {
	
	private InterfaceCRUD<Administrador,String> repositorio;
	
	public ControladorAdministrador(){
		this.repositorio = new RepositorioAdministradores();
	}
	public Administrador autenticar(String login,String senha) throws NegocioException{
		Administrador resultado = null;
		for(Administrador a: this.repositorio.listar()){
			if(a.getCpf().equals(login))
				resultado = a;
		}	
		if(resultado != null){
			if(resultado.getSenha().equals(senha))
				return resultado;
			else
				throw new NegocioException("Senha incorreta");
		}
		else
			throw new NegocioException("Login invalido");
		
	}
	public void cadastrar(Administrador administrador) throws NegocioException{
		if(Validadores.validaCPF(administrador.getCpf())){
			if(Validadores.validaSenha(administrador.getSenha())){
				if(this.repositorio.existe(administrador) == null)
					this.repositorio.cadastrar(administrador);
				else
					throw new NegocioException("O Administrador já está cadastrado");
			}
				
			else
				throw new NegocioException("Senha inválida");
		}
		else
			throw new NegocioException("Cpf inválido");
	}
	
	public void remover(Administrador administrador) throws NegocioException{
		if(this.repositorio.existeCodigo(administrador.getCpf()))
			this.repositorio.remover(administrador);
		else
			throw new NegocioException("O Administrador não está cadastrado");
	}
	public void atualizar(Administrador administrador) throws  NegocioException{
		if(this.repositorio.existeCodigo(administrador.getCpf()))
			this.repositorio.atualizar(administrador);
		else
			throw new NegocioException("O Administrador não está cadastrado");
		
	}
	public ArrayList<Administrador> listar()throws NegocioException{
		if(this.repositorio.listar().isEmpty())
			throw new NegocioException("Não esistem Administradores cadastrados");
		else
			return this.repositorio.listar();
	}

}
