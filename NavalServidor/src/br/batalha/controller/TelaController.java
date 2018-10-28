package br.batalha.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.batalha.model.Jogo;
import br.servidor.TCPServer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TelaController implements Initializable {

	@FXML
	private TextField tfTamanho;

	@FXML
	private Font x1;

	@FXML
	private Color x2;

	@FXML
	private Button criar;

	@FXML
	private GridPane grid;

	@FXML
	private Button criarRede;

	@FXML
	private Button pararRede;

	@FXML
	private GridPane tabelaConfig;

	@FXML
	private Font x3;

	@FXML
	private Color x4;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	private void confirmar(ActionEvent event) {
		try {
			int tamanho = Integer.parseInt(tfTamanho.getText());
			Jogo tab = new Jogo(tamanho);
			grid.setVgap(10);
			grid.setHgap(10);
			grid.setMinSize(520, 600);
			grid.setAlignment(Pos.TOP_LEFT);
			Button botao[][] = new Button[tamanho][tamanho];
			
			// For para criar o array de botoes com evento
			for (int i = 0; i < tamanho; i++) {
				for (int j = 0; j < tamanho; j++) {
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
					botao[i][j].setText("" + tab.getSimbolo(i, j));
				}
			}

//			String 
//			resultado = "Descncrição - Simbolo - Pontuação\n";
//			resultado +="Livre 		   'l'	  		0\n";
//			resultado += "Porta Aviao  'P'	  		5\n";
//			resultado +="Submarino - 'S'\n";
//			resultado += "Cruzador - 'C'\n";
//			resultado += "Destroyer - 'D'\n";
//			textoConfigJogo.setText(resultado);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@FXML
	private void criarRede(ActionEvent event) throws IOException {

		TCPServer serv = new TCPServer();
		serv.startServer(6789);
		System.out.println("Aguardando Clientes");
		
		}

	@FXML
	private void pararRede(ActionEvent event) {

	}

	private void testar(String s) {
		System.out.println(s);
	}
}
