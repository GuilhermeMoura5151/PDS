

import java.util.ArrayList;

public class Verify {
	private ArrayList<String> nomes = new ArrayList<>();
	
	public Verify() {
		
	}
	
	public boolean verifica(String nome) {
		
		if(!nomes.contains(nome)) {
			
			if(nome.matches(".*[A-Za-z0-9_.@].*")) {
				
				if(nome.length()<=40) {
					if(Character.isLetter(nome.charAt(0))) {
						String nome2=new StringBuilder(nome).reverse().toString();
						if(!String.valueOf(nome2.charAt(0)).matches(".*[_.@].*")) {
							nomes.add(nome);
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
}
