package desenho;

import java.util.ArrayList;
import java.util.List;

import model.Transformacoes;

public class Desenho {
	
	List<Ponto> pontosInicial;
	List<Ponto> pontos;
	
	public Desenho(List<Ponto> pontosIniciais) {
		this.pontosInicial = pontosIniciais;
	}
	
	//Retorna a lista de pontos que compõem o polígono.
	public List<Ponto> getPontos(){
		return pontos;
	}
	
	//Método que reseta o desenho à forma original sem nenhuma das transformações.
	public void reset() {
		pontos = new ArrayList<>(pontosInicial);
	}
	
	//Calcula e retorna o ponto central do polígono.
	public Ponto getPontoCentral() {
		Ponto pontoMedio = new Ponto(0, 0);
		for(Ponto p: pontos) {
			pontoMedio.x += p.x;
			pontoMedio.y += p.y;
		}
		pontoMedio.x /= pontos.size();
		pontoMedio.y /= pontos.size();
		
		return pontoMedio;
	}
	
	//Método que faz a transformação de translação em x e em y
	public void makeTransladar(double tX, double tY) {
		List<Ponto> pontosResultantes = new ArrayList<>();
		for(Ponto p: pontos) {
			Ponto novoPonto = new Ponto(p.x+tX, p.y+tY);
			pontosResultantes.add(novoPonto);
		}
		this.pontos = pontosResultantes;
	}
	
	//Método que faz a transformação da escala em x e em y
	public void makeEscala(double sX, double sY) {
	    List<Ponto> pontosResultantes = new ArrayList<>();
	    Ponto pontoCentral = getPontoCentral();

	    for (Ponto p : pontos) {
	        Ponto novoPonto = p.copy();
	        
	        novoPonto = Transformacoes.translada(novoPonto, -pontoCentral.x, -pontoCentral.y);
	        novoPonto = Transformacoes.escala(novoPonto, sX, sY);
	        novoPonto = Transformacoes.translada(novoPonto, pontoCentral.x, pontoCentral.y);

	        pontosResultantes.add(novoPonto);
	    }

	    this.pontos = pontosResultantes;
	}
	
	//Método que faz a transformação da rotação
	public void makeRotacao(double r) {
		List<Ponto> pontosResultantes = new ArrayList<>();
		Ponto pontoCentral = getPontoCentral();
		for(Ponto p: pontos) {
			Ponto novoPonto = new Ponto(p.x, p.y);
			novoPonto = Transformacoes.translada(novoPonto, -pontoCentral.x, -pontoCentral.y);
			novoPonto = Transformacoes.rotacao(novoPonto, r);
			novoPonto = Transformacoes.translada(novoPonto, pontoCentral.x, pontoCentral.y);
			pontosResultantes.add(novoPonto);
		}
		this.pontos = pontosResultantes;
	}
	
	//Método que faz a transformação do cisalhamento
	public void makeCisalhamento(double shX, double shY) {
	    List<Ponto> pontosResultantes = new ArrayList<>();
	    Ponto pontoCentral = getPontoCentral();
	    
	    for (Ponto p : pontos) {
	        Ponto novoPonto = p.copy();

	        novoPonto = Transformacoes.translada(novoPonto, -pontoCentral.x, -pontoCentral.y);
	        novoPonto = Transformacoes.cisalhamento(novoPonto, shX, shY);
	        novoPonto = Transformacoes.translada(novoPonto, pontoCentral.x, pontoCentral.y);

	        pontosResultantes.add(novoPonto);
	    }

	    this.pontos = pontosResultantes;
	}

}
