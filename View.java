package view;

//Classe responsável pela interface de visualização do desenho, interagindo com a janela e seus componentes.
import javax.swing.event.ChangeListener;

import desenho.Desenho;
import desenho.Ponto;

public class View {
	
	Janela janela;
	
	//Construtor que inicializa a janela com o desenho fornecido.
	public View(Desenho desenho) {
		janela = new Janela(desenho);
	}

	public void atualiza(Desenho desenho) {
		janela.atualiza(desenho);
	}
	
	public void adicionaListenerSlide(ChangeListener cl) {
		janela.adicionaListenerSlide(cl);
	}
	
	public Ponto getValorT() {
		return janela.getValorSlideT();
	}

	public Ponto getValorS() {
		return janela.getValorSlideS();
	}

	public double getValorR() {
		return janela.getValorSlideR();
	}
	
	public Ponto getValorSH() {
	    return janela.getValorSlideSH();
	}
	
	public int getValorLados() {
	    return janela.getValorLados();
	}
	
	public void adicionaAcaoCentralizar(Runnable acao) {
	    janela.adicionaAcaoCentralizar(acao);
	}
	
	public void adicionaAcaoReset(Runnable acao) {
	    janela.adicionaAcaoReset(acao);
	}
	
	public int getLarguraPainel() {
	    return janela.getTela().getWidth();
	}

	public int getAlturaPainel() {
	    return janela.getTela().getHeight();
	}

	public void zerarSlidersCentraliza() {
	    janela.getBotoes().zerarSlidersCentraliza();
	}
	
	public void zerarSlidersTotal() {
	    janela.getBotoes().zerarSlidersTotal();
	}
}