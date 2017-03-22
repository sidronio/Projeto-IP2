package view.controladores;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import negocio.controladores.Contexto;
import view.Principal;

public class ControladorTelaLogadoAluno extends AnchorPane{
	@FXML
	private Label lbUser;
	
	
	
	
	public ControladorTelaLogadoAluno(){
		try{
			FXMLLoader loader = new FXMLLoader(ControladorTelaLogin.class.getClass().getResource("/view/fxmls/TelaLogadoAluno.fxml"));
			
			loader.setController(this);
			this.getChildren().add(loader.load());
			
			
			this.lbUser.setText("Usuário: " + Contexto.getIntance().getUsuarioLogado().getNome());
		}catch(Exception e){
			e.printStackTrace();
		}
	 	
	}
	@FXML
	private void sobre(){
		Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
		dialogo.setContentText("Livraria SEBO V2.8b  Esse software foi desenvolvido com muito carinho por "
				+ "nossa equipe, dúvidas, sugestões, envie-nos um email para vanelson@gmail.com");
		dialogo.setHeaderText(null);
		dialogo.show();
	}
	
	@FXML
	private void buscarLivro(){
		Principal.mudarTela(new ControladorTelaAlugarLivro());
	}
	@FXML
	private void sair(){
		Alert dialogo = new Alert(Alert.AlertType.CONFIRMATION);
		dialogo.setContentText("tem certeza que deseja sair?");
		dialogo.setHeaderText(null);
		Optional<ButtonType> result = dialogo.showAndWait();
		if(result.get() == ButtonType.OK){
			Principal.mudarTela(new ControladorTelaLogin());
			Contexto.getIntance().setUsuarioLogado(null);
		}
		
	}
}
