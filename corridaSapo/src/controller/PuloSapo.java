package controller;

public class PuloSapo extends Thread{
	private int salto_maximo;
	private int distancia_maxima;
	private int posicao_atual;
	private static int colocacao = 0;
	public PuloSapo(int salto_maximo, int distancia_maxima) {
		this.salto_maximo = salto_maximo;
		this.distancia_maxima = distancia_maxima;
		this.posicao_atual = 0;
	}
	
	public void run() {
		while (!(posicao_atual >= distancia_maxima)) {
			saltar();
		}
		colocacao++;
		System.out.println(colocacao + "° colocado - Sapo: " + getId() + ".");
	}
	
	private void saltar() {
		int salto_atual = (int) (Math.random() * (salto_maximo+1));
		posicao_atual += salto_atual;
		System.out.println("O sapo " + getId() + " saltou " + salto_atual + "cm e percorreu " + posicao_atual + " cm.");
	}
	
}