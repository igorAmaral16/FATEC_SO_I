package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cruzar extends Thread {
	private String sentido;
	private Semaphore semaforoCruza;
	
	public Cruzar(Semaphore _semaforo) {
		semaforoCruza = _semaforo;
		sentido = getRandomSentido();
	}
	
	public void run() {
		try {
			semaforoCruza.acquire();
			atravessar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoCruza.release();
		}
	}
	
	private void atravessar() {
		System.out.println("carro #" + getId() + " atravessando no sentido: " + sentido);

	}
	
	private static String getRandomSentido() {
		String sentido[] = {"cima", "baixo", "direita", "esquerda"};
	    int rnd = new Random().nextInt(sentido.length);
	    return sentido[rnd];
	}
}