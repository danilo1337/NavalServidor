package br.batalha.model;

import java.util.ArrayList;
import java.util.Random;

public class Jogo {
	private int tamanho = 3;
	private Arma tabuleiro[][] = null;
	private ArrayList<Jogador> jogadores = null;
	private int qtdTotalArmas = 0;


	// ,metodo adicionar uma jogasdor -ZZZ
	// metodo de devolver o vencedor quandto o jogo finalizar - ZZZ
	// criar uma copia do tabuleiro que pega o simbolo retornado um simobolo(getSimbolo) - ZZZ

	public void adicionarJogador(int id, String nome) {
		jogadores.add(new Jogador(id,nome));
	}
	public Jogo(int tamanho) throws Exception {
		if (tamanho < 3) throw new Exception("Digite um tamanho maior que 3");
		this.tamanho = tamanho;

		tabuleiro = new Arma[tamanho][tamanho];
		jogadores = new ArrayList<Jogador>();

		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				tabuleiro[i][j] = new Arma();
			}
		}

		definirArmasRandom("PortaAviao", 5, 'P', true, 0.30f);
		definirArmasRandom("Submarino", 5, 'S', true, 0.30f);
		definirArmasRandom("Cruzador", 4, 'C', true, 0.20f);
		definirArmasRandom("Destroyer", 3, 'D', true, 0.20f);

		ArrayList<Jogador> arrayJogador = new ArrayList<>(2);
	}

	private void definirArmasRandom(String descricao, int pontos, char simbolo, boolean situacao, float porcentagem) {
		int linha = 0;
		int coluna = 0;
		Random random = new Random();
		float qtdArmas2 = ((float) (0.60 * (tamanho * tamanho)));
		float qtdArmas = ((float) (porcentagem * qtdArmas2));


		float a = ((float) (qtdArmas));
		int b = ((int) (a));
		a = a - b;

		if (a >= 0.50f) {
			qtdArmas = (int) (porcentagem * qtdArmas2);
			qtdArmas2++;
		} else {
			tabuleiro[linha][coluna].setSimbolo('L');
		}

		while (qtdArmas >= 0) {
			linha = random.nextInt(tamanho);
			coluna = random.nextInt(tamanho);
			if (tabuleiro[linha][coluna].getSimbolo() == 'L') {
				tabuleiro[linha][coluna].setDescricao(descricao);
				tabuleiro[linha][coluna].setPontos(pontos);
				tabuleiro[linha][coluna].setSimbolo(simbolo);
				tabuleiro[linha][coluna].setSituacao(situacao);
				qtdArmas--;
			}
		}
		while (qtdArmas < ((int) (qtdArmas2))) {
			qtdArmas++;
		}
		qtdTotalArmas = (int)(qtdArmas);
	}


	public int receberDisparo(int linha,int coluna) {
		int pontuacao = 0;
		if(tabuleiro[linha][coluna].isSituacao() == true) {
			tabuleiro[linha][coluna].setSituacao(false);
			qtdTotalArmas --;
			pontuacao = tabuleiro[linha][coluna].getPontos();
		}
		return pontuacao;
	}

	public char getSimbolo(int linha,int coluna){
		Arma x[][] = tabuleiro;
		return x[linha][coluna].getSimbolo();
	}
	public int getQtdArmas() {
		return qtdTotalArmas;
	}
}
