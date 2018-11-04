package br.batalha.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.batalha.model.Jogo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class TelaJogo implements Initializable{
	
    @FXML
    private GridPane grid;

    @FXML
    private AnchorPane janelaPrincipal;
    
    Image portaAviao = new Image("/images/portaAviao.png",50,50,false,false);
    Image cruzador = new Image("/images/cruzador.png",50,50,false,false);
    Image destroyer = new Image("/images/destroyer.png",50,50,false,false);
    Image submarino = new Image("/images/submarino.png",50,50,false,false);
    Image agua = new Image("/images/agua.png",50,50,false,false);
    
	@Override
	public void initialize(URL location, ResourceBundle resources){
	}
	public void gerarTabuleiro(int tamanho) {
		try {
			
			System.out.println(tamanho);
			Jogo tab = new Jogo(tamanho);
			grid.setVgap(10);
			grid.setHgap(10);
			grid.setMinSize(520, 600);
			grid.setAlignment(Pos.TOP_LEFT);
			Button botao[][] = new Button[tamanho][tamanho];
		
			//cor verde
//					botao[i][j].setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
			
			// For para criar o array de botoes com evento
			for (int i = 0; i < tamanho; i++) {
				for (int j = 0; j < tamanho; j++) {
//					botao[i][j] = new Button("",new ImageView(barco));
					botao[i][j] = new Button();
					botao[i][j].setPrefSize(40, 40);
					botao[i][j].setId(i + "-" + j);
					botao[i][j].setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							Button teste = (Button) event.getSource();
							testar(teste.getId());
							
						}

					});
				}
			}
			
			// Coloca a tabela na tela & o simbolo/imagem
			for (int i = 0; i < tamanho; i++) {
				for (int j = 0; j < tamanho; j++) {
					grid.add(botao[i][j], j, i);
//					botao[i][j].setText("" + tab.getSimbolo(i, j));
					if(tab.getSimbolo(i, j) == 'P') {
						botao[i][j].setGraphic(new ImageView(portaAviao));
					}else if(tab.getSimbolo(i, j) == 'D') {
						botao[i][j].setGraphic(new ImageView(destroyer));
					}else if(tab.getSimbolo(i, j) == 'S') {
						botao[i][j].setGraphic(new ImageView(submarino));
					}else if(tab.getSimbolo(i, j) == 'C') {
						botao[i][j].setGraphic(new ImageView(cruzador));
					}else if(tab.getSimbolo(i, j) == 'L') {
						botao[i][j].setGraphic(new ImageView(agua));
					}
					
//					botao[i][j];
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	private void testar(String s) {
		System.out.println(s);
	}
	
	public void setTamanho(int tamanho) {
		gerarTabuleiro(tamanho);
	}
	
	public void criarServidor(int porta) {
	}
}
