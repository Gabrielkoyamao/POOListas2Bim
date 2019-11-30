package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import model.AnimalModel;

public class AnimalController {
	
	public String generoFavorito() throws IOException {
		Map<String, Integer> generoFav = new HashMap<>();
		String genero=null;
		int count;	
		int maior=0;
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaVI.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);

		String texto = brd.readLine();
		AnimalModel animal= new AnimalModel();
		
		while(texto != null) {
			if(texto.split(":")[0].toLowerCase().contains("genero")) {
				if(generoFav.get(texto.split(": ")[1]) != null) {
					count=generoFav.get(texto.split(": ")[1]);
					count++;
					generoFav.replace(texto.split(": ")[1], count);
				}else generoFav.put(texto.split(": ")[1],1);
			}
			texto = brd.readLine();
		}
		brd.close();
		
		// encontra maior
		maior = Collections.max (generoFav.values());
		for (Map.Entry<String, Integer> entry : generoFav.entrySet()) if(entry.getValue() == maior) genero = entry.getKey();

		return genero;
	}
	
	public void getRacaRank() throws IOException {
		Map<String, Integer> racaRanking = new HashMap<>();
		int count;
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaVI.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);

		String texto = brd.readLine();
		AnimalModel animal= new AnimalModel();
		
		while(texto != null) {
			if(texto.split(":")[0].toLowerCase().contains("raca")) {
				if(racaRanking.get(texto.split(": ")[1]) != null) {
					count=racaRanking.get(texto.split(": ")[1]);
					count++;
					racaRanking.replace(texto.split(": ")[1], count);
				}else racaRanking.put(texto.split(": ")[1],1);
			}
			texto = brd.readLine();
		}
		brd.close();
		int i=0;
		racaRanking.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue())
		  .forEach(System.out::println);
		  
	}
	
	public ArrayList<AnimalModel> getAll() throws IOException{
		
		ArrayList<AnimalModel> animallist = new ArrayList<AnimalModel>();
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaVI.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);

		String texto = brd.readLine();
		AnimalModel animal= new AnimalModel();
		
		while(texto != null) {
			if(texto.split(":")[0].toLowerCase().contains("raça") && !texto.split(":")[0].toLowerCase().startsWith("atend")) animal.setRaca(texto.split(": ")[1]);
			if(texto.split(":")[0].toLowerCase().contains("genero")&& !texto.split(":")[0].toLowerCase().startsWith("atend")) animal.setGenero(texto.split(": ")[1]);
			if(texto.split(":")[0].toLowerCase().contains("idade")&& !texto.split(":")[0].toLowerCase().startsWith("atend")) {
				animal.setIdade(texto.split(": ")[1]); 
				animallist.add(animal); 
				animal = new AnimalModel();
			}
			texto = brd.readLine();
		}
		brd.close();
		return animallist;
	}
	
	public void add(AnimalModel animal) throws IOException {
		File arq = new File("C:\\Users\\User\\Desktop\\listaVI.txt");
		FileWriter wr = new FileWriter(arq, true);
		BufferedWriter bwr = new BufferedWriter(wr);
	
		bwr.write("Raça: " + animal.getRaca());
		bwr.newLine();
		bwr.write("Genero: " + animal.getGenero());
		bwr.newLine();
		bwr.write("Idade: " + animal.getIdade());
		bwr.newLine();
		bwr.write("======================================");
		bwr.newLine();
		bwr.close();	
		System.out.println("Cadastrado com sucesso!");
	}
	
	public AnimalModel getObjAnimal() {
		
		Utils getInputText = new Utils();
		AnimalModel anim = new AnimalModel();

		System.out.println("Raça: ");
		anim.setRaca(getInputText.texto());
		
		System.out.println("Idade: ");
		anim.setIdade(getInputText.texto());
		
		System.out.println("Gênero: [M/F]");
		anim.setGenero(getInputText.texto());

		return anim;
	}
	
}
