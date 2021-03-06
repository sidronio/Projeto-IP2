package view.controladores;

import exceptions.NegocioException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import negocio.beans.Aluno;
import negocio.controladores.Fachada;
import view.Principal;

public class ControladorTelaCadastroAluno extends  AnchorPane{
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private TextField txtCpf;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private TextField txtSenha;
	
	@FXML
	private TextField txtCurso;
	
	@FXML
	private TextField txtPeriodo;
	
	@FXML
	private TextField txtInstituicao;
	
	@FXML
	private Button btCadastrarAluno;
	
	@FXML
	private Button btVoltar;
	
	public ControladorTelaCadastroAluno(){
		try{
			FXMLLoader loader = new FXMLLoader(ControladorTelaLogin.class.getClass().getResource("/view/fxmls/TelaCadastroAluno.fxml"));
			
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
		
		int periodo;
		try{
			periodo = Integer.valueOf(txtPeriodo.getText());
		}catch(NumberFormatException n){
			periodo = 1;
		}
	
		
		try {
			Aluno aluno = new Aluno(txtNome.getText(),txtCpf.getText(),txtEmail.getText(),txtSenha.getText(),
					txtInstituicao.getText(),txtCurso.getText(),periodo);
			Fachada.getInstance().cadastrarAluno(aluno);
			
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
