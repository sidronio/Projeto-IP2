package negocio.controladores;

import negocio.beans.Usuario;

public class Contexto {
	
	private static Contexto instance;
	private Usuario usuarioLogado;

	
	private Contexto(){
		
	}
	public static Contexto getIntance(){
		if(instance == null)
			instance = new Contexto();
		return instance;
	}
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	

}
