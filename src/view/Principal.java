package view;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.controladores.ControladorTelaLogin;

public class Principal extends Application{
	
	private static Stage estagioPrincipal;

	@Override
	public void start(Stage arg0) throws Exception {
		estagioPrincipal = new Stage();
		estagioPrincipal.setResizable(false);
		//currentStage.initStyle(StageStyle.UNDECORATED);
		//estagioPrincipal.getIcons().add(new Image("/imagens/Main Icon.png"));
		estagioPrincipal.setTitle("Livraria SEBO");
		mudarTela(new ControladorTelaLogin());
		
	}
	public static void mudarTela(Parent painel){
		estagioPrincipal.setScene(new Scene(painel));
		//estagioPrincipal.getScene().setFill(Color.BLACK);
		estagioPrincipal.centerOnScreen();
		estagioPrincipal.show();
	}
	public static void main(String args[]){
		launch();
	}

}
