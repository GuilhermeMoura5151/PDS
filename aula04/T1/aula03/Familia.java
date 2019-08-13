
import java.util.ArrayList;
import java.util.Arrays;

public class Familia {
	
	//Atributos
	//private Pessoa p;
	//private String nome;
	private ArrayList <Pessoa> pessoas;
	private int [] numerosDePortas;
	//int doorRange;
	
	//Construtores
	public Familia (ArrayList<Pessoa> pessoas, int[] numerosDePortas, int numeroFinal, int numeroInicial) {
		this.pessoas = pessoas;
		this.numerosDePortas = new int [] {numeroInicial,numeroFinal};
	}
	
	//Métodos
	public void adicionarPessoa (Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }
	
	public void removerPessoa (Pessoa pessoa) {
		ArrayList <Pessoa> novosMembros = new ArrayList<>();
		for (Pessoa p : this.pessoas ){
			if (!pessoas.equals(pessoa)) {
				novosMembros.add(pessoa);
			}
		}
		this.pessoas = novosMembros;
	}
	
	public boolean checarPessoa (Pessoa pessoa){
		for (Pessoa pessoa1 : this.pessoas ){
			if (pessoa1.equals(pessoa1)){
				return true;
			}
		}
		return false;
	}

	//toString
	@Override
	public String toString() {
		return "Familia [Pessoas =" + pessoas + ", NumDePortas =" + Arrays.toString(numerosDePortas) + "]";
	}
}
