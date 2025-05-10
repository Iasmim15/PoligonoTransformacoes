package controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import desenho.Ponto;
import model.Model;
import view.View;

//Inicializa o modelo e a visualização, adiciona listeners e define ações para os botões.
public class Controller {
	
	View view;
	Model model;
	
	public Controller() {
		model = new Model();
		view = new View(model.getDesenho());
		
		view.adicionaListenerSlide(new MudaSlide());
		view.adicionaListenerSlide(new MudaLados());
		
		//Centraliza o polígono no painel e reseta os sliders de translação.
		view.adicionaAcaoCentralizar(() -> {
			int largura = view.getLarguraPainel();
		    int altura = view.getAlturaPainel();
		    model.centralizarPoligono(largura, altura);
		    view.atualiza(model.getDesenho());
		    view.zerarSlidersCentraliza();
		    
		});
		
		//Reseta todos os sliders para o estado inicial e atualiza o desenho.
		view.adicionaAcaoReset(() -> {
			view.zerarSlidersTotal();
		    view.atualiza(model.getDesenho());
		    
		});
		
	}
	
	//Captura os novos valores sempre que um slider é movimentado, aplica as transformações no polígono e atualiza a tela para refletir as mudanças.
	class MudaSlide implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			int qtdLados = view.getValorLados();
	        model.atualizaLados(qtdLados);
	        
			Ponto t = view.getValorT();
			double r = view.getValorR();
			Ponto s = view.getValorS(); 
			Ponto sh = view.getValorSH();
			
			model.makeTransformacoes(t, s, r, sh);
			view.atualiza(model.getDesenho());
			
		}
		
	}
	
	// Listener para o controle de quantidade de lados do polígono. Ele atualiza a quantidade de lados no modelo e redesenha o polígono na view.
	class MudaLados implements ChangeListener {

	    @Override
	    public void stateChanged(ChangeEvent e) {
	        int qtdLados = view.getValorLados();
	        model.atualizaLados(qtdLados);
	        view.atualiza(model.getDesenho());
	    }
	}

}
