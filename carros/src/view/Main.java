package view;

import java.util.concurrent.Semaphore;

import controller.Cruzar;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforoCruza = new Semaphore(1);
		
		for(int i=0; i < 4; i++)
			new Cruzar(semaforoCruza).run();
	}
}