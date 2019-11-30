package model;

public class PessoaModel {
	
	protected String nome;
	protected String telefone;
	protected String endereco;
	protected String cpf;
	protected AnimalModel animal;

	public AnimalModel getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalModel animal) {
		this.animal = animal;
	}

	public String toString() {
		return (	"Nome: " + nome + "\n" + 
				"Telefone: " + telefone + "\n" +  
				"Endereco: " + endereco + "\n" +  
				"Cpf: " + cpf + "\n" );
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
