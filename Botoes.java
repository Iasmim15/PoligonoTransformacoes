package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.concurrent.Flow;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

public class Botoes extends JPanel {
	
	JSlider sliderTX = new JSlider(-300, 300, 0);
	JSlider sliderTY = new JSlider(-300, 600, 0);
	
	JSlider sliderSX = new JSlider(1, 5, 1);
	JSlider sliderSY = new JSlider(1, 5, 1);
	
	double rFator = 100;
	JSlider sliderR = new JSlider(0, (int)(2*Math.PI*rFator), 0);
	
	JSlider sliderSHX = new JSlider(-3, 3, 0);
	JSlider sliderSHY = new JSlider(-3, 3, 0);
	
	JSpinner spinnerLados = new JSpinner(new SpinnerNumberModel(4, 3, 100, 1));
	JButton centralizarPoligono = new JButton ("Centralizar Poligono");
	JButton resetar = new JButton ("Resetar");
	
	//Construtor da classe Botoes. Este método configura a interface gráfica dos controles.
	public Botoes() {
		setLayout(new BorderLayout());
		
		//Painel para os sliders
		JPanel painelSliders= new JPanel();
		painelSliders.setLayout(new BoxLayout(painelSliders, BoxLayout.PAGE_AXIS));
		
		painelSliders.add(new Label("Translada em X"));
		painelSliders.add(sliderTX);
		painelSliders.add(new Label("Translada em Y"));
		painelSliders.add(sliderTY);
		painelSliders.add(new Label("Escala em X"));
		painelSliders.add(sliderSX);
		painelSliders.add(new Label("Escala em Y"));
		painelSliders.add(sliderSY);
		painelSliders.add(new Label("Rotação"));
		painelSliders.add(sliderR);
		painelSliders.add(new Label("Cisalhamento em X"));
		painelSliders.add(sliderSHX);
		painelSliders.add(new Label("Cisalhamento em Y"));
		painelSliders.add(sliderSHY);
		
		//Painel inferior
		JPanel painelInferior= new JPanel();
		painelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		painelInferior.add(new Label("Quantidade de Lados"));
		painelInferior.add(spinnerLados);
		painelInferior.add(centralizarPoligono);
		painelInferior.add(resetar);
		
		add(painelSliders, BorderLayout.CENTER);
		add(painelInferior, BorderLayout.SOUTH);
		
	}
	
	
	public int getValorSlideTX() {
		return sliderTX.getValue();
	}
	
	public int getValorSlideTY() {
		return sliderTY.getValue();
	}
	
	public int getValorSlideSX() {
		return sliderSX.getValue();
	}
	
	public int getValorSlideSY() {
		return sliderSY.getValue();
	}
	
	public double getValorSlideR() {
		return (double)sliderR.getValue()/(double)rFator;
	}
	
	public int getValorSlideSHX() {
	    return sliderSHX.getValue();
	}

	public int getValorSlideSHY() {
	    return sliderSHY.getValue();
	}
	
	public int getValorLados() {
	    return (int) spinnerLados.getValue();
	}
	
	//Método que add Listener aos Slides e ao Spinner. Será notificado sempre que algum desses componentes for alterado.
	public void adicionaListenerSlide(ChangeListener cl) {
		sliderTX.addChangeListener(cl);
		sliderTY.addChangeListener(cl);
		sliderSX.addChangeListener(cl);
		sliderSY.addChangeListener(cl);
		sliderR.addChangeListener(cl);
		sliderSHX.addChangeListener(cl);
		sliderSHY.addChangeListener(cl);
		spinnerLados.addChangeListener(cl);
	}
	
	//Método que zera os Slider de translação.
	public void zerarSlidersCentraliza() {
	    sliderTX.setValue(0);
	    sliderTY.setValue(0);
	}
	 //Método que todos os Sliders menos os de translação.
	public void zerarSlidersTotal() {
	    sliderR.setValue(0);
	    sliderSX.setValue(0);
	    sliderSY.setValue(0);
	    sliderSHX.setValue(0);
	    sliderSHY.setValue(0);
	}
	
	//Adiciona a ação ao botão de centralizar o polígono.
	public void adicionaAcaoCentralizar(Runnable acao) {
	    centralizarPoligono.addActionListener(e -> acao.run());
	}
	
	//Adiciona a ação ao botão de resetar o polígono.
	public void adicionaAcaoReset(Runnable acao) {
	    resetar.addActionListener(e -> acao.run());
	}

}