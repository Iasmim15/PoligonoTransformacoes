package model;

import java.util.ArrayList;

import java.util.List;

import desenho.Desenho;
import desenho.Ponto;

public class Model {
	
	//Inicializa o desenho do polígono
	static List<Ponto> pontos = new ArrayList<>();
	{
		pontos.add(new Ponto(250, 250));
		pontos.add(new Ponto(350, 250));
		pontos.add(new Ponto(350, 350));
		pontos.add(new Ponto(250, 350));
	};
	
	Desenho desenho = new Desenho(pontos);
	
	public Model() {
	}
	
	//Atualiza a quantidade de lados do polígono e redefine os pontos de acordo com a nova quantidade.
	public void atualizaLados(int qtdLados) {
	    pontos.clear();

	    double centroX = 300;
	    double centroY = 300;
	    double raio = 100;

	    for (int i = 0; i < qtdLados; i++) {
	        double angulo = 2 * Math.PI * i / qtdLados;
	        double x = centroX + raio * Math.cos(angulo);
	        double y = centroY + raio * Math.sin(angulo);
	        pontos.add(new Ponto(x, y));
	    }

	    desenho = new Desenho(pontos);
	}
	
	//Método que aplica três transformações geométricas ao polígono, translação, escala e rotação
	public void makeTransformacoes(Ponto t, Ponto s, double r, Ponto sh) {
		desenho.reset();
		desenho.makeTransladar(t.x, t.y);
		desenho.makeEscala(s.x, s.y);
		desenho.makeRotacao(r);
		desenho.makeCisalhamento(sh.x, sh.y);
	}
	
	// Método que centraliza o polígono considerando a área disponível
	public void centralizarPoligono(int larguraPainel, int alturaPainel) {

	        // Calcula o centro da área 
	        int centroX = larguraPainel / 2;
	        int centroY = alturaPainel / 2;

	        // Calcula o centro atual do polígono
	        double centroPoligonoX = 0;
	        double centroPoligonoY = 0;
	        for (int i = 0; i < desenho.getPontos().size(); i++) {
	            centroPoligonoX += desenho.getPontos().get(i).x;
	            centroPoligonoY += desenho.getPontos().get(i).y;
	        }
	        centroPoligonoX /= desenho.getPontos().size();
	        centroPoligonoY /= desenho.getPontos().size();

	        // Calcula o deslocamento necessário para centralizar o polígono
	        double deslocamentoX = centroX - centroPoligonoX;
	        double deslocamentoY = centroY - centroPoligonoY;

	        // Aplica o deslocamento a todos os pontos do polígono
	        for (int i = 0; i < desenho.getPontos().size(); i++) {
	            Ponto ponto = desenho.getPontos().get(i);
	            ponto.x += deslocamentoX;
	            ponto.y += deslocamentoY;
	        }
	    }
	
	public void resetDesenho(int larguraPainel, int alturaPainel) {
		desenho.reset();
	}
	
	public Desenho getDesenho() {
		return desenho;
	}

}
