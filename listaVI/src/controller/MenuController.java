package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.AnimalModel;
import model.AtendimentoModel;
import model.ClienteEFuncionarioModel;
import model.ClienteModel;
import model.FuncionarioModel;
import model.PessoaModel;

public class MenuController {
	
	Utils options;
	
	public void start() {
		System.out.println("======== Menu ========");
		System.out.println("1 - Cadastro");
		System.out.println("2 - Listar");
		System.out.println("3 - Relatórios");
		System.out.println("4 - Histórico de Atendimento");
		System.out.println("5 - Marcar Atendimento");
		System.out.println("0 - Sair");
	}
	
	public void subMenuCadastro() throws IOException {
		System.out.println("======== Cadastro ========");
		System.out.println("1 - Cadastro de funcionario");
		System.out.println("2 - Cadastro de cliente");
		options = new Utils();
		PessoaModel pessoaAux = new PessoaModel();
		PessoaController pc;
		AnimalController ac;
		switch (options.opcao()) {
			case 1:
				pc = new PessoaController();
				pc.add(pc.getObjPessoa(true), "funcionario");
				break;
			case 2:
				ac = new AnimalController();
				pc = new PessoaController();
				pessoaAux = pc.getObjPessoa(false); 
				pc.add(pessoaAux, "cliente");
				
				int length;
				
				options = new Utils();
				System.out.println("Adicionar mais?(Máximo 5) [s/N]");
				if("s".equals(options.texto().toLowerCase())) {
					System.out.println("Quantos?(Pode adicionar mais 4)");
					length = options.opcao();
					while(length > 4) {
						System.out.println("Voce so pode adicionar mais 4");
						options = new Utils();
						length = options.opcao();
					}
					for (int i = 0; i < length; i++) {
						pessoaAux.setAnimal(ac.getObjAnimal());
						pc.add(pessoaAux, "cliente");
					}
					System.out.println("Obrigado");
				}
				break;
			}
		}
	
	public void subMenuListar() throws IOException {
		System.out.println("======== Listar ========");
		System.out.println("1 - Funcionarios");
		System.out.println("2 - Clientes");
		System.out.println("3 - Animais");
		options = new Utils();
		PessoaController pc;
		AnimalController ac;
		switch (options.opcao()) {
			case 1:
				pc = new PessoaController();
				for (ClienteEFuncionarioModel clientefuncionario : pc.getAll()) {
					System.out.println(clientefuncionario.getFuncionario().toString());
				}
				break;
			case 2:
				pc = new PessoaController();
				for (ClienteEFuncionarioModel clientefuncionario : pc.getAll()) {
					System.out.println(clientefuncionario.getCliente().toString());
				}
				break;
			case 3:
				ac = new AnimalController();
				for (AnimalModel animal : ac.getAll()) {
					System.out.println(animal.toString());
				}
				break;
		}
	}
	
	
	public void subMenuRelatorio() throws IOException {
		System.out.println("======== Relatorios ========");
		
		AnimalController animalController = new AnimalController();
		System.out.println("Genero Favorito: " + animalController.generoFavorito()+"\n");
		
		System.out.println("Raças mais populares (ranking): ");
		animalController.getRacaRank();
	}
	
	
	public void subMenuHistorico() throws IOException {
		System.out.println("======== Listando Historico de atendimento ========");
		AtendimentoController ac = new AtendimentoController();
		ac.getHistAtendimento();
	}
	
	
	public void subMenuAtendimento() throws IOException{
		
//		listar todos os clientes para esoclha e funcionarios pra o atendimento e cadsatrar, no hisotorico eu puxo tudo
		
		ArrayList<String> clientesDistinct = new ArrayList<String>();
		
		String auxCliente;
		
		ClienteModel clienteOpt = null;
		FuncionarioModel funcionarioOpt=null;
		AnimalModel animalOpt=null; 
		
		AnimalController ac;
		PessoaController pc;
		AtendimentoController atenc;
		
		System.out.println("Marcar um atendimento: ");

		options = new Utils();
		System.out.println("Qual cliente deseja agendar? ");
		pc = new PessoaController();
	
		for (ClienteModel cliente : pc.getAllClientes())
			if(!clientesDistinct.contains(cliente.getNome())) clientesDistinct.add(cliente.getNome());
		
		for (int i = 0; i < clientesDistinct.size(); i++) System.out.println(i+1 + " - " +clientesDistinct.get(i));
		
		auxCliente = clientesDistinct.get(options.opcao()-1);
		
		options = new Utils();
		System.out.println("Qual animal sera atendido?");
		for (int i = 0; i < pc.getAllClientes().size(); i++) {
			if(pc.getAllClientes().get(i).getNome().toLowerCase().equals(auxCliente.toLowerCase())) {
				System.out.println(i+1 + " - " +pc.getAllClientes().get(i).getAnimal().getRaca());
			}
		}
		int auxEscolha = options.opcao()-1;
		
		clienteOpt = pc.getAllClientes().get(auxEscolha);
		animalOpt = pc.getAllClientes().get(auxEscolha).getAnimal();
		
		options = new Utils();
		System.out.println("Qual funcionario deseja alocar para o atendimento?");
		for (int i = 0; i < pc.getAllFuncionarios().size(); i++) System.out.println(i+1 + " - " +pc.getAllFuncionarios().get(i).getNome());
		funcionarioOpt = pc.getAllFuncionarios().get(options.opcao()-1);
		
		if(clienteOpt == null ||funcionarioOpt==null || animalOpt==null ) {
			System.out.println("Ocorreu algum erro, tente novamente");
		}else {
			atenc = new AtendimentoController();
			atenc.addAtendimento(clienteOpt,animalOpt,funcionarioOpt);
		}
		
	}
}
