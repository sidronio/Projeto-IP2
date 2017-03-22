package view.controladores;

import exceptions.NegocioException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import negocio.beans.Aluno;
import negocio.beans.Emprestimo;
import negocio.beans.Livro;
import negocio.controladores.Contexto;
import negocio.controladores.Fachada;
import view.Principal;

public class ControladorTelaAlugarLivro extends AnchorPane{
	
	private Livro livroSelecionado;
	
	@FXML
	private TextField txtTitulo;
	
	@FXML
	private Label lblAutor;
	
	@FXML
	private Label lblEditora;
	
	@FXML
	private Label lblExemplares;
	
	public ControladorTelaAlugarLivro(){
		try{
			FXMLLoader loader = new FXMLLoader(ControladorTelaLogin.class.getClass().getResource("/view/fxmls/TelaAlugarLivro.fxml"));
			
			loader.setController(this);
			this.getChildren().add(loader.load());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@FXML
	private void buscar(){
		
		try{
		for(Livro livro: Fachada.getInstance().listarLivros()){
			if(livro.getTitulo().equals(txtTitulo.getText())){
				this.livroSelecionado = livro;
				this.lblExemplares.setText("Exemplares: " +String.valueOf(livro.getExemplares()));
				this.lblAutor.setText("Autor: "+livro.getAutor());
				this.lblEditora.setText("Editora: "+livro.getEditora());
				break;	
			}
		}
		if(livroSelecionado == null){
			Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
			dialogo.setHeaderText(null);
			dialogo.setAlertType(Alert.AlertType.ERROR);
			dialogo.setContentText("Nenhum livro encontrado");
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
	public void alugar(){
		Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
		dialogo.setHeaderText(null);
		if(this.livroSelecionado != null ){
			try {
				Fachada.getInstance().cadastrarEmpréstimo(new Emprestimo((Aluno)Contexto.getIntance().getUsuarioLogado()
						, this.livroSelecionado,null,null));
				dialogo.setAlertType(Alert.AlertType.INFORMATION);
				dialogo.setContentText("Você alugou o livro");
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
			dialogo.setContentText("Selecione um livro");
			dialogo.show();
		}
	} 
	@FXML
	private void voltar(){
		Principal.mudarTela(new ControladorTelaLogadoAluno());
	}

}
