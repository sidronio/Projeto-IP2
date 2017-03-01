package negocio.beans;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrador(String nome, String cpf, String email, String senha) {
		super(nome, cpf, email, senha);
		
	}
	
	
	

}
