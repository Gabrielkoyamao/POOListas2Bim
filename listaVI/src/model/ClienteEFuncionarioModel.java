package model;

public class ClienteEFuncionarioModel {
	private ClienteModel cliente;
	private FuncionarioModel funcionario;
	
	public ClienteModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	public FuncionarioModel getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioModel funcionario) {
		this.funcionario = funcionario;
	}
	
	public String toString() {
		return this.cliente.toString() + this.funcionario.toString();
//		System.out.println(this.cliente.toString());
//		System.out.println(this.funcionario.toString());
	}
	
}
