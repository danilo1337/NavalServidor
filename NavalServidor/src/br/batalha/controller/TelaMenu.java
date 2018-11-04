package br.batalha.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaMenu implements Initializable{
	

    @FXML
    private Button ok;

    @FXML
    public TextField tamanho;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}


    @FXML
    void confirmar(ActionEvent event) throws Exception{
//		TelaJogo a = new TelaJogo();
//		a.setTamanho(10);
		mudarCena(event);
//		a.initialize(null, null);
    }
	
	public void mudarCena(ActionEvent event) throws Exception {
		Stage stage = null;
		Parent root = null;

		// TODO
		try {
			if (event.getSource() == ok) {
				stage = (Stage) ok.getScene().getWindow();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/batalha/view/Jogo.fxml"));
				root = (Parent) loader.load();
				TelaJogo z = loader.getController();
				z.setTamanho(Integer.parseInt(tamanho.getText()));
				z.criarServidor(7777);
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			stage.centerOnScreen();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}





	
	
	
}
