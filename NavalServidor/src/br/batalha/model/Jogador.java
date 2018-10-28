package br.batalha.model;

public class Jogador{
	private int id = 0;
	private String nome = "";
	private int pontos =0;
	
	public Jogador(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public int getPontos() {
		return pontos;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	

}
