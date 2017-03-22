package negocio.beans;

import java.io.Serializable;

public class Aluno extends Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String instituicaoEnsino;
	private String curso;
	private int per�odo;

	public Aluno(String nome, String cpf, String email, String senha,String instituicaoEnsino,String curso,int periodo ) {
		super(nome, cpf, email, senha);
		this.setInstituicaoEnsino(instituicaoEnsino);
		this.setPer�odo(per�odo);
		this.setCurso(curso);
		
	}

	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getPer�odo() {
		return per�odo;
	}

	public void setPer�odo(int per�odo) {
		this.per�odo = per�odo;
	}
	
	

}
