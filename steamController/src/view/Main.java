package view;

import java.io.IOException;

import controller.SteamController;

public class Main {

	public static void main(String[] args) {

		String path = "C:\\FATEC\\SO\\steamController\\arquivosExer";
		String nome = "SteamCharts.csv";
		SteamController cont = new SteamController(path, nome);
		try {
			cont.leitor();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}