package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import desenho.Desenho;
import desenho.Ponto;

//Classe responsável pela área de desenho, onde o polígono é exibido.
public class Tela extends JPanel {
	
	 // Objeto Desenho que contém os pontos do polígono a ser desenhado
	Desenho desenho;
	
	//Inicializa a Tela com um objeto Desenho.
	public Tela(Desenho desenho) {
		this.desenho = desenho;
	}
	
	public void atualiza(Desenho desenho) {
		this.desenho = desenho;
		repaint();
	}
	public Desenho getDesenho() {
	    return desenho;
	}
	
	
	//Método responsável por desenhar o polígono na tela. As cores das linhas são alteradas com base na enumeração Cores.
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		this.setBackground(new Color(230, 230, 230));
		
		g2d.setStroke(new BasicStroke(15));
		
		List<Ponto> pontos = desenho.getPontos(); 
		
		if(pontos==null) {
			System.out.println("Desenho eh nulo");
			return;
		}
		
		Ponto pontoAnterior = pontos.get(pontos.size()-1);
		Cores cor = Cores.values()[0];
		for(Ponto pontoAtual: pontos) {
			g2d.setColor(cor.getCor());
			g2d.drawLine(
					(int)pontoAnterior.x, (int)pontoAnterior.y, 
					(int)pontoAtual.x,    (int)pontoAtual.y);
			
			cor = cor.next();
			pontoAnterior = pontoAtual;
			
		}
		
	}

}
