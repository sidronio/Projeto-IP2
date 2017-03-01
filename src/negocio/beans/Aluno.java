package negocio.beans;

import java.io.Serializable;

public class Aluno extends Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String instituicaoEnsino;
	private String curso;
	private int período;

	public Aluno(String nome, String cpf, String email, String senha,String instituicaoEnsino,String curso ) {
		super(nome, cpf, email, senha);
		this.setInstituicaoEnsino(instituicaoEnsino);
		this.setPeríodo(período);
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

	public int getPeríodo() {
		return período;
	}

	public void setPeríodo(int período) {
		this.período = período;
	}
	
	

}
