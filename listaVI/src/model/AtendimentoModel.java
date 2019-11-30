package model;

public class AtendimentoModel {
	private ClienteModel clienteModel;
	private AnimalModel animalModel;
	private FuncionarioModel funcionarioModel;
	
	
	public FuncionarioModel getFuncionarioModel() {
		return funcionarioModel;
	}
	public void setFuncionarioModel(FuncionarioModel funcionarioModel) {
		this.funcionarioModel = funcionarioModel;
	}
	public ClienteModel getClienteModel() {
		return clienteModel;
	}
	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}
	public AnimalModel getAnimalModel() {
		return animalModel;
	}
	public void setAnimalModel(AnimalModel animalModel) {
		this.animalModel = animalModel;
	}
	
	
}
