package controller;

public class ThreadVetor extends Thread{
	private int valor_numerico;
	private int[] vetor;
	
	public ThreadVetor(int[] vetor, int valor) {
		this.valor_numerico = valor;
		this.vetor = vetor;
	}
	
	public void run() {
		double elapsed_time;
		
		if( (valor_numerico % 2) == 0 ) {
			double start_time = System.nanoTime();
			for(int i = 0; i < vetor.length; i++);
			elapsed_time = (System.nanoTime() - start_time) / Math.pow(10, 9);
			System.out.printf("Número Par - Tempo: %f segundos.\n", elapsed_time);
		}
		
		else {
			double start_time = System.nanoTime();
			for(int i: vetor);
			elapsed_time = (System.nanoTime() - start_time) / Math.pow(10, 9);
			System.out.printf("Número ímpar - Tempo: %f segundos.\n", elapsed_time);
		}
	}
}