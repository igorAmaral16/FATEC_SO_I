package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class SteamController {

	private String path;
	private String nome;
	private double mpeak = 0;
	private String nomea = "";
	private String nomeemedia;
	
	public SteamController(String path, String nome) {
		this.nome = nome;
		this.path = path;
	}

	public void leitor() throws IOException{
		
		
		File arq = new File(path, nome);
		if(arq.exists()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader Buffer = new BufferedReader(leitor);
			String linha = Buffer.readLine();
			linha = Buffer.readLine();
			
			String ano = JOptionPane.showInputDialog("Digite o ano: ");
			String mes = JOptionPane.showInputDialog("Digite o mês: ");
			
			while(linha != null) {
				
				String[] array = linha.split(",");
				
				if(linha.contains(ano)) {
					if(linha.contains(mes)) {
						
						String info = analizador(array[0], array[3], array[1], array[2]);
						print(path, "nome.csv", info);
						
					}
				
				}
				linha = Buffer.readLine();
			}
			Buffer.close();
			leitor.close();
			fluxo.close();
		}
	}

	public String analizador(String nome, String peak, String ano, String mes) {
		double apeak = Double.parseDouble(peak);
		
		
		if (apeak > mpeak) {
			
			mpeak = apeak;
			
		}
		
		
		if(nome.equals(nomea)) {
			
			
		}else {
			nomea = nome;
			 
			nomeemedia += nome +";"+ mpeak+"\n";
			System.out.println(nomea + "\t"+ mpeak);
			
			mpeak = 0;
		}
		
		return nomeemedia;
	}


	public void print(String path, String nome, String info) throws IOException {
		
		File file = new File(path, nome);
		FileWriter openfile = new FileWriter(file, false);
		PrintWriter writer = new PrintWriter(openfile);
		writer.write(info);
		writer.flush();
		writer.close();
		openfile.close();
				
	}

}