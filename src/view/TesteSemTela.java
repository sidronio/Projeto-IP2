package view;

import negocio.beans.Administrador;
import negocio.beans.Aluno;
import negocio.beans.Livro;
import negocio.controladores.Fachada;

public class TesteSemTela {

	public static void main(String[] args) {
		
		try{
			Administrador adm = new Administrador("admin","08015415497","nsrv@gmail.com","novaSenha","chefe");
			Livro livro = new Livro(37564,"pacto do pescoço cortado","editora Dezembro","Machado de aziz",56);
			Aluno aluno = new Aluno("Renelson","10870298488","renealon@arrober.com","senha","universida da Igreja Universal água santa","BCC",6);
			Fachada.getInstance().cadastraradministrador(adm);
			Fachada.getInstance().cadastrarLivro(livro);
			Fachada.getInstance().cadastrarAluno(aluno);
			
			for(int i = 0;i< 1;i++){
				System.out.println(Fachada.getInstance().listarLivros().get(i));
			}
			
			for(int i = 0;i< 1;i++){
				System.out.println(Fachada.getInstance().listarAdministrador().get(i));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
