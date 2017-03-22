package view.controladores;

import exceptions.NegocioException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import negocio.beans.Administrador;
import negocio.beans.Usuario;
import negocio.controladores.Contexto;
import negocio.controladores.Fachada;
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
			
			loader.setController(this);
			
			this.getChildren().add(loader.load());
		}catch(Exception e){
			
			e.printStackTrace();
		}
	 	
	}
	
	@FXML
	public void logar(){
		try {
			Usuario usuario = Fachada.getInstance().autenticar(tfCpf.getText(),pfSenha.getText());
			if(usuario != null){
				Contexto.getIntance().setUsuarioLogado(usuario);
				if(usuario instanceof Administrador)
					Principal.mudarTela(new ControladorTelaLogadoAdm());
				else
					Principal.mudarTela(new ControladorTelaLogadoAluno());
			}
		} catch (NegocioException e) {
			Alert dialogo = new Alert(Alert.AlertType.ERROR);
			dialogo.setContentText(e.getMessage());
			dialogo.setHeaderText(null);
			dialogo.show();
		}
			
		
	}
	

}
