package view.controladores;

import exceptions.NegocioException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import negocio.beans.Livro;
import negocio.controladores.Fachada;
import view.Principal;

public class ControladorTelaCadastroLivro extends AnchorPane {
		
	
	@FXML
	private TextField txtTitulo;
	
	@FXML
	private TextField txtAutor;
	
	@FXML
	private TextField txtEditora;

	@FXML
	private TextField txtExemplares;
	
	@FXML
	private TextField txtIsbn;
	
	public  ControladorTelaCadastroLivro()
	{
		try{
			FXMLLoader loader = new FXMLLoader(ControladorTelaLogin.class.getClass().getResource("/view/fxmls/TelaCadastroLivro.fxml"));
			
			loader.setController(this);
			
			this.getChildren().add(loader.load());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@FXML
	private void cadastrar(){
		
		Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
		dialogo.setHeaderText(null);
		
		int isbn;
		try{
			isbn = Integer.valueOf(txtIsbn.getText());
		}catch(NumberFormatException n){
			isbn = 1;
		}
		int exemplares;
		try{
			exemplares = Integer.valueOf(txtExemplares.getText());
		}catch(NumberFormatException n){
			exemplares = 0;
		}
	
		
		try {
			Livro livro = new Livro(isbn,txtTitulo.getText(),txtEditora.getText(),txtAutor.getText(),exemplares);
			Fachada.getInstance().cadastrarLivro(livro);
			
			dialogo.setContentText("Cadastrado com sucesso!");
			dialogo.show();
		} catch (NegocioException e) {
			dialogo.setAlertType(Alert.AlertType.ERROR);
			dialogo.setContentText(e.getMessage());
			dialogo.show();
		}

	}
	@FXML
	private void voltar(){
		Principal.mudarTela(new ControladorTelaLogadoAdm());
	}
	
}
