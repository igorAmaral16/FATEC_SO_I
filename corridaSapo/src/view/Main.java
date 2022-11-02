package view;
import controller.PuloSapo;

public class Main {
	public static void main(String [] args) {
		int distancia = 9;
		int puloMaximo = 3;
		System.out.println("Distância da corrida: " + distancia + " cm. Pulo máximo: " + puloMaximo + " cm.");
		for(int i=0; i < 5; i++)
			new PuloSapo(puloMaximo, distancia).start();
	}
}