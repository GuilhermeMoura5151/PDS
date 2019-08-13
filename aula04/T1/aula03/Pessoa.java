

public class Pessoa {
	
	//Atributos
	private String nome;
	
	//Construtores
	public Pessoa (String nome) throws IllegalArgumentException {
		if (nome.length() < 1 || nome.length() > 40){
			throw new IllegalArgumentException("O nome tem de ter no mínimo 1 e no máximo 40 caracteres!");
		}
		else if (nome.length() == 1 ){
			this.nome = nome;
		}
		else {
			this.nome = nome;
		}
	}
	
	//Getters
	public String getNome() {
		return this.nome;
	}

	//toString
	@Override
	public String toString() {
		return nome;
	}
}
