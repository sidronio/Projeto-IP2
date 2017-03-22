package negocio.beans;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cargo;
	
	public Administrador(String nome, String cpf, String email, String senha,String cargo) {
		super(nome, cpf, email, senha);
		this.setCargo(cargo);
		
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	

}
