package model;

public class AnimalModel {
	private String raca;
	private String genero;
	private String idade;
	
	public String toString() {
		return (	"Raça: " + raca+ "\n" + 
				"Gênero: " + genero + "\n" +  
				"Idade: " + idade + "\n" );
	}
	
	public String getRaca() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String nasc) {
		this.idade= nasc;
	}
	
	
}
