package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.AnimalModel;
import model.AtendimentoModel;
import model.ClienteModel;
import model.FuncionarioModel;

public class AtendimentoController {

	public void addAtendimento(ClienteModel pessoa, AnimalModel animal, FuncionarioModel funcionario) throws IOException {
		String auxDiff = "ATEND";
		String funcDiff = "FUNC";
		String cliDiff = "CLI";
		File arq = new File("C:\\Users\\User\\Desktop\\listaVI.txt");
		FileWriter wr = new FileWriter(arq, true);
		BufferedWriter bwr = new BufferedWriter(wr);
		
		// funcionario
		bwr.write(auxDiff+funcDiff+"Nome: " + funcionario.getNome());
		bwr.newLine();
		bwr.write(auxDiff+funcDiff+"Telefone: " + funcionario.getTelefone());
		bwr.newLine();
		bwr.write(auxDiff+funcDiff+"Endereco: " + funcionario.getEndereco());
		bwr.newLine();
		bwr.write(auxDiff+funcDiff+"CPF: " + funcionario.getCpf());
		bwr.newLine();
	
		// cliente
		bwr.write(auxDiff+cliDiff+"Nome: " + pessoa.getNome());
		bwr.newLine();
		bwr.write(auxDiff+cliDiff+"Telefone: " + pessoa.getTelefone());
		bwr.newLine();
		bwr.write(auxDiff+cliDiff+"Endereco: " + pessoa.getEndereco());
		bwr.newLine();
		bwr.write(auxDiff+cliDiff+"CPF: " + pessoa.getCpf());
		bwr.newLine();
		
		// animal
		bwr.write(auxDiff+"Raca: " + animal.getRaca());
		bwr.newLine();
		bwr.write(auxDiff+"Genero: " + animal.getGenero());
		bwr.newLine();
		bwr.write(auxDiff+"Idade: " + animal.getIdade());
		bwr.newLine();
		bwr.write("======================================");
		bwr.newLine();
		bwr.close();	
		System.out.println("Cadastrado com sucesso!");
	}
	
	public ArrayList<AtendimentoModel> getAtendimento() throws IOException {

		ArrayList<AtendimentoModel> atendimentolist = new ArrayList<AtendimentoModel>();
		
		FuncionarioModel fm = new FuncionarioModel();
		ClienteModel cm = new ClienteModel();
		AnimalModel am = new AnimalModel(); 
		AtendimentoModel atendModel = new AtendimentoModel(); 
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaVI.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);

		String texto = brd.readLine();

		while(texto != null) {
			if(texto.split(":")[0].toLowerCase().startsWith("atend")) {
				// animal
				if(texto.split(":")[0].toLowerCase().contains("raca")) am.setRaca(texto.split(": ")[1]);
				if(texto.split(":")[0].toLowerCase().contains("genero")) am.setGenero(texto.split(": ")[1]);
				if(texto.split(":")[0].toLowerCase().contains("idade")) {
					am.setIdade(texto.split(": ")[1]);
					atendModel.setAnimalModel(am);
					am = new AnimalModel();
					atendimentolist.add(atendModel);
					atendModel = new AtendimentoModel();
				}
				
				// funcionario
				if(texto.split(":")[0].toLowerCase().startsWith("func")) {
					if(texto.split(":")[0].toLowerCase().contains("nome")) fm.setNome(texto.split(": ")[1]);
					if(texto.split(":")[0].toLowerCase().contains("telefone")) fm.setTelefone(texto.split(": ")[1]);
					if(texto.split(":")[0].toLowerCase().contains("endereco")) fm.setEndereco(texto.split(": ")[1]);
					if(texto.split(":")[0].toLowerCase().contains("cpf")) {
						fm.setCpf(texto.split(": ")[1]);
						atendModel.setClienteModel(cm);
						fm = new FuncionarioModel();
						atendimentolist.add(atendModel);
						atendModel = new AtendimentoModel();
					}
				}
				
				// cliente
				if(texto.split(":")[0].toLowerCase().startsWith("cli")) {
					if(texto.split(":")[0].toLowerCase().contains("nome")) cm.setNome(texto.split(": ")[1]);
					if(texto.split(":")[0].toLowerCase().contains("telefone")) cm.setTelefone(texto.split(": ")[1]);
					if(texto.split(":")[0].toLowerCase().contains("endereco")) cm.setEndereco(texto.split(": ")[1]);
					if(texto.split(":")[0].toLowerCase().contains("cpf")) {
						cm.setCpf(texto.split(": ")[1]);
						atendModel.setClienteModel(cm);
						cm = new ClienteModel();
						atendimentolist.add(atendModel);
						atendModel = new AtendimentoModel();
					}
				}
			}
			texto = brd.readLine();
		}
		brd.close();
		
		return atendimentolist;
	}
	
	
	public void getHistAtendimento() throws IOException {
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaVI.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);

		String texto = brd.readLine();

		while(texto != null) {
			if(texto.split(":")[0].toLowerCase().startsWith("atend")) {
				
				if(texto.split(":")[0].toLowerCase().contains("func")) {
					if(texto.split(":")[0].toLowerCase().contains("nome")) {
						System.out.println("\nFuncionario: " + texto.split(": ")[1]);
					}
				}
				
				if(texto.split(":")[0].toLowerCase().contains("cli")) {
					if(texto.split(":")[0].toLowerCase().contains("nome")) {
						System.out.println("Cliente: " + texto.split(": ")[1]);
					}
				}
				
				if(texto.split(":")[0].toLowerCase().contains("raca")) {
					System.out.println("Raça: " + texto.split(": ")[1] + "\n\n");
				}
				
			}
			texto = brd.readLine();
		}
		brd.close();
	}
}
