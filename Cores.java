package view;

import java.awt.Color;

//Enumeração que define as cores usadas no desenho do polígono.
public enum Cores {
	
	VERMELHO(Color.RED), 
	AZUL(Color.BLUE), 
	MAGENTA(Color.MAGENTA),
	PRETO(Color.BLACK);
	
	Color cor;
	private Cores(Color cor) {
		this.cor = cor;
	}
	
	public Color getCor() {
		return cor;
	}
	
	public Cores next() {
		return values()[ (ordinal()+1) % values().length ];
	}
	

}