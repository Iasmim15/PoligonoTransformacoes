package model;

import desenho.Ponto;

public class Transformacoes {
	
	//Faz a transalação dos pontos
	static public Ponto translada(Ponto p, double tX, double tY) {
		Ponto pRes = new Ponto(0, 0);
		pRes.x = p.x + tX;
		pRes.y = p.y + tY;
		return pRes;
	}
	
	//Aplica escala aos pontos
	static public Ponto escala(Ponto p, double sX, double sY) {
		double[][] m1 = {{p.x, p.y}};
		double[][] m2 = 
			{{sX,  0},
			 { 0, sY}};
		double[][] res = multiplica(m1, m2);
		return new Ponto(res[0][0], res[0][1]);
	}
	
	//Aplica uma rotação a um ponto em torno da origem.
	static public Ponto rotacao(Ponto p, double r) {
		double[][] m1 = {{p.x, p.y}};
		double[][] m2 = 
			{{ Math.cos(r), Math.sin(r)},
			 {-Math.sin(r), Math.cos(r)}};
		double[][] res = multiplica(m1, m2);
		return new Ponto(res[0][0], res[0][1]);
	}
	
	//Aplica um cisalhamento a um ponto
	public static Ponto cisalhamento(Ponto p, double shX, double shY) {
	    double[][] m1 = {{p.x, p.y}};
	    double[][] m2 = 
	        {{1, shX},
	         {shY, 1}};
	    double[][] res = multiplica(m1, m2);
	    return new Ponto(res[0][0], res[0][1]);
	}
	
	//Multiplica duas matrizes, retornando o resultado da operação.
	static public double[][] multiplica(double[][] m1, double[][] m2) {
		int lin_m1 = m1.length;
		int col_m1 = m1[0].length;
		int lin_m2 = m2.length;
		int col_m2 = m2[0].length;
		double[][] res = new double[lin_m1][col_m2];
		for(int i=0; i<lin_m1; i++) {
			for(int j=0; j<col_m2; j++) {
				double soma = 0;
				for(int k=0; k<col_m1; k++) {
					soma += m1[i][k]*m2[k][j];
				}
				res[i][j] = soma;
			}
		}
		return res;

	}
	

	
}
