package br.batalha.model;

public class Arma {
	
	private String descricao = "Livre";
	private int pontos = 0;
	private char simbolo = 'L';
	private boolean situacao = false;
	
	public Arma(){
		
	}

	
	public String getDescricao() {
		return descricao;
	}
	public int getPontos() {
		return pontos;
	}
	public char getSimbolo() {
		return simbolo;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}
	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
}
