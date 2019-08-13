
import java.util.*;

public class Familia {
	private List<String> nomes;
	private Map<String, List<String>> familia=new TreeMap<>();

	public Familia() {
		
	}
	
	public void checkFamily(String num, String nome) {
		if(familia.containsKey(num)) {
			familia.get(num).add(nome);
		}else {
			nomes=new ArrayList<>();
			nomes.add(nome);
			familia.put(num, nomes);
		}
	}
	
	public void removeMember(String nome) {
		for (Map.Entry<String,List<String>> entry : familia.entrySet()) {
			if(entry.getValue().contains(nome)) {
				familia.get(entry.getKey()).remove(nome);
			}
		}
	}

	public Map<String, List<String>> getFamilia() {
		return familia;
	}
}
