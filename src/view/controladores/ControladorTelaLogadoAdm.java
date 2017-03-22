package view.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import negocio.controladores.Contexto;

public class ControladorTelaLogadoAdm extends AnchorPane{
	
	
	@FXML
	private Label lbUser;
	
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

}
