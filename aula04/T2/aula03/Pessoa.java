

import java.util.Map;
import java.util.TreeMap;

public class Pessoa {
	private Map<String, String> pessoa= new TreeMap<>();

	public Pessoa() {}
	
	public void checkPessoa(String nome, String num) {
		if(!pessoa.containsKey(nome)) {
			pessoa.put(nome, num);
		}
	}
	
	public void removePessoa(String nome) {
		if(pessoa.containsKey(nome)) {
			pessoa.remove(nome);
		}
	}

	public Map<String, String> getPessoa() {
		return pessoa;
	}

}
