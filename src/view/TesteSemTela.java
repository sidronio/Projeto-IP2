package view;

import exceptions.NegocioException;
import negocio.beans.Administrador;
import negocio.beans.Aluno;
import negocio.beans.Livro;
import negocio.controladores.Fachada;

public class TesteSemTela {

	public static void main(String[] args) {
		Aluno aluno = new Aluno("Garga","10870298488","renealon@arrober.com","senha","universida da Igreja Universal água santa","Militância Petista");
		Livro livro = new Livro(37564,"pacto do pescoço cortado","editora Dezembro","Machado de aziz",56);
		Administrador adm = new Administrador("admin","08015415497","nsrv@gmail.com","novaSenha");
		try {
			Fachada.getInstance().cadastrarAluno(aluno);
			Fachada.getInstance().cadastrarLivro(livro);
			Fachada.getInstance().cadastraradministrador(adm);
			
			for(int i = 0;i< 1;i++){
				System.out.println(Fachada.getInstance().listarAlunos().get(i));
			}
			for(int i = 0;i< 1;i++){
				System.out.println(Fachada.getInstance().listarAdministrador().get(i));
			}
			for(int i = 0;i< 1;i++){
				System.out.println(Fachada.getInstance().listarLivros().get(i));
			}
		} catch (NegocioException e) {
			e.printStackTrace();
		}
	}

}
