package view;

import java.awt.BorderLayout;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.event.ChangeListener;

import desenho.Desenho;
import desenho.Ponto;

//Classe responsável por criar e gerenciar a janela principal do programa.
//Ela organiza a interface gráfica contendo a área de desenho (tela) e os botões de interação.
public class Janela extends JFrame {
	
	Tela tela;
	Botoes botoes = new Botoes();
	
	public Janela(Desenho desenho) {
		super("Janela");
		
		// Criação da tela de desenho com o objeto Desenho.
		tela = new Tela(desenho);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		tela.setPreferredSize(new Dimension(620, 620));
		
		add(tela, BorderLayout.CENTER);
		add(botoes, BorderLayout.EAST);
		
		setVisible(true);
		pack();
		
	}
	
	public void adicionaListenerSlide(ChangeListener cl) {
		botoes.adicionaListenerSlide(cl);
	}
	
	 public Tela getTela() {
	        return tela;
	    }
	 
	 public Botoes getBotoes() {
		    return botoes;
		}
	
	public void atualiza(Desenho desenho) {
		tela.atualiza(desenho);
	}
	
	public Ponto getValorSlideT() {
		return new Ponto(
				botoes.getValorSlideTX(), 
				botoes.getValorSlideTY());
	}
	
	public Ponto getValorSlideS() {
		return new Ponto(
				botoes.getValorSlideSX(), 
				botoes.getValorSlideSY());
	}

	public double getValorSlideR() {
		return botoes.getValorSlideR();
	}
	
	public Ponto getValorSlideSH() {
	    return new Ponto(
	        botoes.getValorSlideSHX(), 
	        botoes.getValorSlideSHY()
	    );
	}
	
	public int getValorLados() {
	    return botoes.getValorLados();
	}
	
	public void adicionaAcaoCentralizar(Runnable acao) {
	    botoes.adicionaAcaoCentralizar(acao);
	}
	
	public void adicionaAcaoReset(Runnable acao) {
	    botoes.adicionaAcaoReset(acao);
	}
	
}