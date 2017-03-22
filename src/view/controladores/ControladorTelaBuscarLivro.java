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

public class ControladorTelaBuscarLivro extends AnchorPane{
	
	private Livro livroSelecionado;
	
	@FXML
	private TextField txtTitulo;
	
	@FXML
	private TextField txtAutor;
	
	@FXML
	private TextField txtEditora;
	
	@FXML
	private TextField txtExemplares;
	
	public ControladorTelaBuscarLivro(){
		try{
			FXMLLoader loader = new FXMLLoader(ControladorTelaLogin.class.getClass().getResource("/view/fxmls/TelaBuscarLivro.fxml"));
			
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
				this.txtExemplares.setText(String.valueOf(livro.getExemplares()));
				this.txtAutor.setText(livro.getAutor());
				this.txtEditora.setText(livro.getEditora());
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
	private void remover(){
		Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
		dialogo.setHeaderText(null);
		if(livroSelecionado != null){
			try {
				Fachada.getInstance().removerLivro(livroSelecionado);
				livroSelecionado = null;
				this.txtTitulo.setText("");
				this.txtAutor.setText("");
				this.txtEditora.setText("");
				this.txtExemplares.setText("");
				dialogo.setAlertType(Alert.AlertType.INFORMATION);
				dialogo.setContentText("Livro removido do sistema!");
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
			dialogo.setContentText("Nenhum livro selecionado!");
			dialogo.show();
		}
		
	}
	@FXML
	private void alterar(){
		Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
		dialogo.setHeaderText(null);
		if (livroSelecionado != null) {
			
			int exemplares;
			try {
				exemplares = Integer.valueOf(this.txtExemplares.getText());
			} catch (NumberFormatException n) {
				exemplares = 0;
			}

			try {
				this.livroSelecionado.setAutor(this.txtAutor.getText());
				this.livroSelecionado.setEditora(this.txtEditora.getText());
				this.livroSelecionado.setExemplares(exemplares);
				Fachada.getInstance().alterarLivro(livroSelecionado);
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
