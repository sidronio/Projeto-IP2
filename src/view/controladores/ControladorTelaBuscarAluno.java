package view.controladores;

import exceptions.NegocioException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import negocio.beans.Aluno;
import negocio.controladores.Fachada;
import view.Principal;

public class ControladorTelaBuscarAluno extends AnchorPane {
	
	private Aluno alunoSelecionado;
	
	@FXML
	private TableView listaAlugueis;
	
	@FXML
	private Button btAlterar;
	
	@FXML
	private Button btRemover;
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private TextField txtCpf;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private TextField txtCurso;
	
	@FXML	
	private TextField txtPeriodo;
	
	@FXML
	private TextField txtInstituicao;
	
	@FXML
	private ImageView imgBuscar;
	
	
	public ControladorTelaBuscarAluno(){
		try{
			FXMLLoader loader = new FXMLLoader(ControladorTelaLogin.class.getClass().getResource("/view/fxmls/TelaBuscarAluno.fxml"));
			
			loader.setController(this);
			
			this.getChildren().add(loader.load());
			
			/*
			TableColumn colunaLivro = new TableColumn("Livro");
	        TableColumn colunaDataA = new TableColumn("Data de aluguél");
	        TableColumn colunaDataE = new TableColumn("Data de entrega");
	        this.listaAlugueis.getColumns().clear();
	        this.listaAlugueis.getColumns().addAll(colunaLivro,colunaDataA,colunaDataE);
	        */
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	@FXML
	private void buscar(){

		try{
		for(Aluno aluno: Fachada.getInstance().listarAlunos()){
			if(aluno.getCpf().equals(txtCpf.getText())){
				this.alunoSelecionado = aluno;
				this.txtNome.setText(aluno.getNome());
				this.txtEmail.setText(aluno.getEmail());
				this.txtCurso.setText(aluno.getCurso());
				this.txtPeriodo.setText(String.valueOf(aluno.getPeríodo()));
				this.txtInstituicao.setText(aluno.getInstituicaoEnsino());
				//this.listaAlugueis.getItems().addAll(Fachada.getInstance());
				break;	
			}
		}
		if(alunoSelecionado == null){
			Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
			dialogo.setHeaderText(null);
			dialogo.setAlertType(Alert.AlertType.ERROR);
			dialogo.setContentText("Nenhum aluno encontrado");
			dialogo.show();
		}
		}catch(NegocioException e){
			Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
			dialogo.setHeaderText(null);
			dialogo.setAlertType(Alert.AlertType.ERROR);
			dialogo.setContentText(e.getMessage());
			dialogo.show();
		}
		
	}
	@FXML
	private void remover(){
		Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
		dialogo.setHeaderText(null);
		if(alunoSelecionado != null){
			try {
				Fachada.getInstance().removerAluno(alunoSelecionado);
				alunoSelecionado = null;
				this.txtNome.setText("");
				this.txtEmail.setText("");
				this.txtCurso.setText("");
				this.txtPeriodo.setText("");
				this.txtInstituicao.setText("");
				dialogo.setAlertType(Alert.AlertType.INFORMATION);
				dialogo.setContentText("Aluno removido do sistema!");
			} catch (NegocioException e) {
				dialogo.setAlertType(Alert.AlertType.ERROR);
				dialogo.setContentText(e.getMessage());
			}
			finally{
				dialogo.show();
			}
		}
		else{
			dialogo.setAlertType(Alert.AlertType.ERROR);
			dialogo.setContentText("Nenhum Aluno selecionado!");
			dialogo.show();
		}
	}
	@FXML
	private void alterar(){
		Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
		dialogo.setHeaderText(null);
		if (alunoSelecionado != null) {
			
			int periodo;
			try {
				periodo = Integer.valueOf(this.txtPeriodo.getText());
			} catch (NumberFormatException n) {
				periodo = 1;
			}

			try {
				this.alunoSelecionado.setNome(this.txtNome.getText());
				this.alunoSelecionado.setEmail(this.txtEmail.getText());
				this.alunoSelecionado.setCurso(this.txtCurso.getText());
				this.alunoSelecionado.setPeríodo(periodo);
				Fachada.getInstance().alterarAluno(alunoSelecionado);
				dialogo.setAlertType(Alert.AlertType.INFORMATION);
				dialogo.setContentText("Alterado com sucesso!");

			} catch (NegocioException e) {

				dialogo.setAlertType(Alert.AlertType.ERROR);
				dialogo.setContentText(e.getMessage());
			} finally {
				dialogo.show();
			}
		}
		else{
			dialogo.setAlertType(Alert.AlertType.ERROR);
			dialogo.setContentText("Nenhum livro selecionado!");
			dialogo.show();
		}
		
	}
	@FXML
	private void voltar(){
		Principal.mudarTela(new ControladorTelaLogadoAdm());
	}
}
