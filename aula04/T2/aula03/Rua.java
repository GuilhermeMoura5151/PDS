

import java.io.*;
import java.util.*;

public class Rua {
	private int maior;
	private List<List<String>> nomes;
	private Map<Integer,List<List<String>>> rua;
	private Map<String,List<String>> rua_info = new TreeMap<>();
	private Map<String,String> pessoa_info = new TreeMap<>();
	private Verify ver=new Verify();
	private Familia family=new Familia();
	private Pessoa person = new Pessoa();
	
	public Rua() {}
	
	public void Clear() {
		rua.clear();
		rua_info.clear();
	}
	
	public void load(String filename) throws IOException {
		BufferedReader buff= new BufferedReader(new FileReader(filename));	
		String linha = buff.readLine();
		while(linha!=null) {
			if(linha.charAt(0)!='>'){
				
				construcao_rua(linha);
			}
			linha = buff.readLine();
		}
		System.out.println("Sucesso!");
		update();
		buff.close();
	}
	
	public void construcao_rua(String info){
		String[] info2 = info.split(" ");
		if(ver.verifica(info2[1])) {
			family.checkFamily(info2[0], info2[1]);	
			person.checkPessoa(info2[1], info2[0]);
		}
	}
	
	public void update() {
		rua = new TreeMap<>();
		rua_info=family.getFamilia();
		maior=0;
		for (Map.Entry<String,List<String>> entry : rua_info.entrySet()) {
			String[] divisao = entry.getKey().split("-");
			int i;
			for(i = Integer.parseInt(divisao[0]); i <= Integer.parseInt(divisao[1]); i++) {
				if(rua.containsKey(i)) {
					rua.get(i).add(entry.getValue());
				}else {
					nomes=new ArrayList<>();
					nomes.add(entry.getValue());
					rua.put(i, nomes);
				}
				if(i>maior) {
					maior=i;
				}
			}
		}
	}
	
	public void add(String nome, int x1, int x2) {
		if(!ver.verifica(nome)) {
			System.out.println("Nome ja se encontra na rua!");
		}else {
			String num = x1+"-"+x2;
			family.checkFamily(num,nome);
			person.checkPessoa(nome, num);
			update();
			
		}
	}
	
	public void remove(String nome) {
		if(ver.verifica(nome)) {
			System.out.println("Nome nao se encontra na rua!");
		}else {
			family.removeMember(nome);	
			person.removePessoa(nome);
			update();
		}
	}
	
	public void print() {
		if(rua.isEmpty()) {
			System.out.println("Nao existem dados");
		}else {
			for(int f = 1; f<=maior;f++) {
				if(rua.containsKey(f)) {
					int i = 1;
				    System.out.print(f + " : " );
				    for(List<String> lista_imp_1: rua.get(f)) {
				    	
				    	for(String lista_imp_2: lista_imp_1) {
					    	System.out.print(lista_imp_2 + " ");
					    }
				    	if(i<rua.get(f).size())
				    		System.out.print(": ");
				    	i++;
				    }
				    System.out.println("");
	
				}else {
					System.out.println(f);
				}
			}
		}
	}
	
	public void look(String nome) {
		for (Map.Entry<String,List<String>> entry : rua_info.entrySet()) {
			if(entry.getValue().contains(nome)) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
	}
	
	public void list() {
		pessoa_info=person.getPessoa();
		for (Map.Entry<String,String> entry : pessoa_info.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
