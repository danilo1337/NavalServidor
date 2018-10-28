package br.batalha.model;

public class teste {
	
	// essa vai ser o nosso teste ....
	public static void main(String[] args) {
		try {
			Jogo a = new Jogo(6);
			System.out.println(a.getSimbolo(3, 2));
			System.out.println(a.getQtdArmas());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
}
