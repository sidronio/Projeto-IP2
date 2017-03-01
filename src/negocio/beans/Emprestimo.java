package negocio.beans;

import java.io.Serializable;
import java.util.Calendar;

public class Emprestimo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private Aluno aluno;
	private Livro livro;
	private Calendar dataAluguel;
	private Calendar dataEntrega;
	private boolean atrasado;
	private float multa;
	
	public Emprestimo(Aluno aluno,Livro livro,Calendar dataAluguel,Calendar dataEntrega){
		
		this.setAluno(aluno);
		this.setDataAluguel(dataAluguel);
		this.setDataEntrega(dataEntrega);
		this.setLivro(livro);
		
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public Livro getLivro() {
		return livro;
	}


	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	public Calendar getDataAluguel() {
		return dataAluguel;
	}


	public void setDataAluguel(Calendar dataAluguel) {
		this.dataAluguel = dataAluguel;
	}


	public Calendar getDataEntrega() {
		return dataEntrega;
	}


	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}


	public boolean isAtrasado() {
		return atrasado;
	}


	public void setAtrasado(boolean atrasado) {
		this.atrasado = atrasado;
	}


	public float getMulta() {
		return multa;
	}


	public void setMulta(float multa) {
		this.multa = multa;
	}
	
	public float calcularMulta(){
		int dias = (this.dataEntrega.DAY_OF_YEAR - this.dataAluguel.DAY_OF_YEAR) 
				/ (24 * 60 * 60 * 1000);
		return (2*dias);
	}
}
