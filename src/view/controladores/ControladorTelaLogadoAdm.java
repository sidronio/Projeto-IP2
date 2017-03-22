package view.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import negocio.controladores.Contexto;
import view.Principal;

public class ControladorTelaLogadoAdm extends AnchorPane{
	
	
	@FXML
	private Label lbUser;
	
	@FXML
	private MenuBar menuOpcoes;
	
	/*
	@FXML
	private MenuItem itemCadastroAluno;
	
	
	
	
	@FXML
	private MenuItem itemCadastroLivro;
	
	@FXML
	private MenuItem itemBuscarAluno;
	@FXML
	private MenuItem itemBuscarLivro;
	@FXML
	private MenuItem itemSobre;

	@FXML
	private MenuItem itemContate;
	
	@FXML
	private MenuItem itemAvalie;
	@FXML
	private MenuItem itemSair;
	
	*/
	
	public ControladorTelaLogadoAdm(){
		try{
			FXMLLoader loader = new FXMLLoader(ControladorTelaLogin.class.getClass().getResource("/view/fxmls/TelaLogadoAdm.fxml"));
			
			loader.setController(this);
			this.getChildren().add(loader.load());
			
			
			this.lbUser.setText("Usuário: " +Contexto.getIntance().getUsuarioLogado().getNome());
		}catch(Exception e){
			e.printStackTrace();
		}
	 	
	}
		
	@FXML
	private void cadastrarAluno(){
		Principal.mudarTela(new ControladorTelaCadastroAluno());
	}
	@FXML
	private void cadastrarLivro(){
		Principal.mudarTela(new ControladorTelaCadastroLivro());
	}
	@FXML
	private void buscarAluno(){
		Principal.mudarTela(new ControladorTelaBuscarAluno());
	}
	@FXML
	private void buscarLivro(){
		Principal.mudarTela(new ControladorTelaBuscarLivro());
	}

}
