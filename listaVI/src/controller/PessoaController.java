package controller;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.AnimalModel;
import model.ClienteEFuncionarioModel;
import model.ClienteModel;
import model.FuncionarioModel;
import model.PessoaModel;

public class PessoaController {
	
	public Boolean checkNomeExists(String nome) throws IOException {
		boolean existe=false;
		File arq = new File("C:\\Users\\User\\Desktop\\listaVI.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);

		String texto = brd.readLine();
		while(texto != null) {
			if(texto.split(":")[0].toLowerCase().contains("nome") && !texto.split(":")[0].toLowerCase().startsWith("atend")) 
				if(texto.split(":")[0].toLowerCase().startsWith("cli") && texto.split(": ")[1].toLowerCase().equals(nome.toLowerCase())) existe=true;				
			texto = brd.readLine();
		}
		brd.close();
		return existe;
	}
	 
	public ArrayList<ClienteEFuncionarioModel> getAll() throws IOException {
		// carrega todos os funcionarios e clientes
		
		ArrayList<ClienteEFuncionarioModel> clientefuncionario = new ArrayList<ClienteEFuncionarioModel>();
		
		
		ClienteModel cm = new ClienteModel();
		FuncionarioModel fm = new FuncionarioModel();
		ClienteEFuncionarioModel cf = new ClienteEFuncionarioModel(); 
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaVI.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);

		String texto = brd.readLine();

		
		while(texto != null) {
			if(texto.split(":")[0].toLowerCase().contains("nome") && !texto.split(":")[0].toLowerCase().startsWith("atend")) {
				if(texto.split(":")[0].toLowerCase().startsWith("cli")) cm.setNome(texto.split(": ")[1]);	
				else fm.setNome(texto.split(": ")[1]);
			}
			
			if(texto.split(":")[0].toLowerCase().contains("telefone")&& !texto.split(":")[0].toLowerCase().startsWith("atend")) {
				if(texto.split(":")[0].toLowerCase().startsWith("cli")) cm.setTelefone(texto.split(": ")[1]);
				else fm.setTelefone(texto.split(": ")[1]);
			}
			if(texto.split(":")[0].toLowerCase().contains("endereco")&& !texto.split(":")[0].toLowerCase().startsWith("atend")) {
				if(texto.split(":")[0].toLowerCase().startsWith("cli")) cm.setEndereco(texto.split(": ")[1]);
				else fm.setEndereco(texto.split(": ")[1]);
			}
			
			if(texto.split(":")[0].toLowerCase().contains("cpf") && !texto.split(":")[0].toLowerCase().startsWith("atend")) {
				if(texto.split(":")[0].toLowerCase().startsWith("cli")) {
					cm.setCpf(texto.split(": ")[1]);
					cf.setCliente(cm);
				}
				else {
					fm.setCpf(texto.split(": ")[1]);
					cf.setFuncionario(fm);
				}
				
				clientefuncionario.add(cf);
				
				cm = new ClienteModel();
				fm = new FuncionarioModel();
				cf = new ClienteEFuncionarioModel();
			}
			texto = brd.readLine();
		}
		brd.close();
		
		return clientefuncionario;
	}
	
	
	public ArrayList<ClienteModel> getAllClientes() throws IOException{
		
		ArrayList<ClienteModel> clientes = new ArrayList<ClienteModel>();
		ClienteModel cm = new ClienteModel();
		AnimalModel am = new AnimalModel();
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaVI.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);

		String texto = brd.readLine();

		
		while(texto != null) {
			
			if(texto.split(":")[0].toLowerCase().startsWith("cli")) {
				
				if(texto.split(":")[0].toLowerCase().contains("nome")) cm.setNome(texto.split(": ")[1]);	
				
				if(texto.split(":")[0].toLowerCase().contains("telefone")) cm.setTelefone(texto.split(": ")[1]);
				
				if(texto.split(":")[0].toLowerCase().contains("endereco")) cm.setEndereco(texto.split(": ")[1]);
				
				if(texto.split(":")[0].toLowerCase().contains("cpf") ) cm.setCpf(texto.split(": ")[1]);
				
				if(texto.split(":")[0].toLowerCase().contains("raca")) am.setRaca(texto.split(": ")[1]);
				
				if(texto.split(":")[0].toLowerCase().contains("genero")) am.setGenero(texto.split(": ")[1]);
				
				if(texto.split(":")[0].toLowerCase().contains("idade")) {
					am.setIdade(texto.split(": ")[1]);
				
					cm.setAnimal(am);
					clientes.add(cm);
					
					cm = new ClienteModel();
					am = new AnimalModel();
				}
			
			}
			
				
			texto = brd.readLine();
		}
		brd.close();
		
		return clientes;
	}
	
	public ArrayList<FuncionarioModel> getAllFuncionarios() throws IOException{
		
		ArrayList<FuncionarioModel> funcionarios = new ArrayList<FuncionarioModel>();
		FuncionarioModel fm = new FuncionarioModel();
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaVI.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);

		String texto = brd.readLine();

		while(texto != null) {
			if(texto.split(":")[0].toLowerCase().startsWith("func")) {
				if(texto.split(":")[0].toLowerCase().contains("nome")) fm.setNome(texto.split(": ")[1]);	
				if(texto.split(":")[0].toLowerCase().contains("telefone")) fm.setTelefone(texto.split(": ")[1]);
				if(texto.split(":")[0].toLowerCase().contains("endereco")) fm.setEndereco(texto.split(": ")[1]);
				if(texto.split(":")[0].toLowerCase().contains("cpf")) {
					fm.setCpf(texto.split(": ")[1]);
					funcionarios.add(fm);
					fm = new FuncionarioModel();
				}
			}
			texto = brd.readLine();
		}
		brd.close();
		
		return funcionarios;
	}
	
	public void add(PessoaModel pessoa, String df) throws IOException {
		String auxDiff = null;
		if(df.toLowerCase().contains("func")) auxDiff = "FUNC"; 
		if(df.toLowerCase().contains("cli")) auxDiff = "CLI";
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaVI.txt");
		FileWriter wr = new FileWriter(arq, true);
		BufferedWriter bwr = new BufferedWriter(wr);
	
		bwr.write(auxDiff+"Nome: " + pessoa.getNome());
		bwr.newLine();
		bwr.write(auxDiff+"Telefone: " + pessoa.getTelefone());
		bwr.newLine();
		bwr.write(auxDiff+"Endereco: " + pessoa.getEndereco());
		bwr.newLine();
		bwr.write(auxDiff+"CPF: " + pessoa.getCpf());
		bwr.newLine();
		
		if(auxDiff.toLowerCase().equals("cli")) {
			bwr.write(auxDiff+"Raca: " + pessoa.getAnimal().getRaca());
			bwr.newLine();
			
			bwr.write(auxDiff+"Genero: " + pessoa.getAnimal().getGenero());
			bwr.newLine();
			
			bwr.write(auxDiff+"Idade: " + pessoa.getAnimal().getIdade());
			bwr.newLine();

		}
		
		bwr.write("======================================");
		bwr.newLine();	
		bwr.close();	
		System.out.println("Cadastrado com sucesso!");
	}
	
	public PessoaModel getObjPessoa(Boolean func) throws IOException {
		
		AnimalController animalCtrl = new AnimalController();
		Utils getInputText = new Utils();
		PessoaModel p = new PessoaModel();

		System.out.println("Nome: ");
		String nm = getInputText.texto();
		while(this.checkNomeExists(nm)) {
			System.out.println("Nome ja existe, tente novamente");
			nm = getInputText.texto();
		}
		p.setNome(nm);
		
		System.out.println("Telefone: ");
		p.setTelefone(getInputText.texto());
		
		System.out.println("Endereco: ");
		p.setEndereco(getInputText.texto());
		
		System.out.println("CPF: ");
		p.setCpf(getInputText.texto());
		
		// se nao fort funcionario cadastra o animal
		if(!func) p.setAnimal(animalCtrl.getObjAnimal());
		
		return p;
	}	
	
//	public ClienteModel getClienteByName(String nome) throws IOException{
//		ClienteModel cm = new ClienteModel();
//		
//		File arq = new File("C:\\Users\\User\\Desktop\\listaVI.txt");
//		FileReader rd = new FileReader(arq);
//		BufferedReader brd = new BufferedReader(rd);
//
//		String texto = brd.readLine();
//
//		
//		while(texto != null) {
//			
//			if(texto.split(":")[0].toLowerCase().startsWith("cli")) {
//				
//				if(texto.split(":")[0].toLowerCase().contains("nome").equals) cm.setNome(texto.split(": ")[1]);	
//				
//				else if(texto.split(":")[0].toLowerCase().contains("telefone")) cm.setTelefone(texto.split(": ")[1]);
//				
//				else if(texto.split(":")[0].toLowerCase().contains("endereco")) cm.setEndereco(texto.split(": ")[1]);
//				
//				else if(texto.split(":")[0].toLowerCase().contains("cpf") ) cm.setCpf(texto.split(": ")[1]);
//				
//				else if(texto.split(":")[0].toLowerCase().contains("raça")) am.setRaca(texto.split(": ")[1]);
//				
//				else if(texto.split(":")[0].toLowerCase().contains("genero")) am.setGenero(texto.split(": ")[1]);
//				
//				else if(texto.split(":")[0].toLowerCase().contains("idade")) am.setIdade(texto.split(": ")[1]);
//					
//				else {
//					cm.setAnimal(am);
//					clientes.add(cm);
//					
//					cm = new ClienteModel();
//					am = new AnimalModel();
//				}
//			
//			}
//			
//				
//			texto = brd.readLine();
//		}
//		brd.close();
//		
//		
//		return cm;
//	}


}
