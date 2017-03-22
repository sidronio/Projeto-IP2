package view.controladores;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ControladorTelaLogadoAdm extends AnchorPane{
	
	
	public ControladorTelaLogadoAdm(){
		try{
			FXMLLoader loader = new FXMLLoader(ControladorTelaLogin.class.getClass().getResource("/view/fxmls/TelaLogadoAdm.fxml"));
			
			loader.setController(this);
			this.getChildren().add(loader.load());
		}catch(Exception e){
			e.printStackTrace();
		}
	 	
	}

}
