package view.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import view.Principal;

public class ControladorTelaLogin extends AnchorPane {
		
	@FXML
	private TextField tfCpf;
	
	@FXML
	private PasswordField pfSenha;
	
	@FXML
	private Button btLogin;
	
	public ControladorTelaLogin(){
		try{
			FXMLLoader loader = new FXMLLoader(ControladorTelaLogin.class.getClass().getResource("/view/fxmls/TelaLogin.fxml"));
			//loader.setRoot(null);
			//loader.setRoot(this);
			loader.setController(this);
			
			this.getChildren().add(loader.load());
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	 	
	}
	
	@FXML
	public void logar(){
		Principal.mudarTela(new ControladorTelaLogadoAdm());
	}
	

}
