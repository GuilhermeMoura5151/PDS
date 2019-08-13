

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Rua {
	
	//Atributos
	private ArrayList<Familia> familiasNaRua;
	
	//Construtores
	public Rua() {
		this.familiasNaRua = new ArrayList<>();
	}
	
	public void adicionarPessoa (int numeroInicial,int numeroFinal,String nome) {
		
		Pessoa novaPessoa;
		try {
            novaPessoa = new Pessoa(nome);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }
		
		for(Familia familia : familiasNaRua) {
            //Verificar a existência de um membro
            if(familia.checarPessoa(novaPessoa)){
                System.out.println(" O membro já existe!");
                return;
            }
		}
	}
	
	public void removerPessoa (String nome){
        Pessoa novaPessoa;
        try {
            novaPessoa = new Pessoa(nome);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }
         
        //Procurar uma pessoa em cada uma das familías 
        for (Familia familia : familiasNaRua) {
            
            //Verificar se a pessoa pertence a família e se sim elimina-a.
            if(familia.checarPessoa(novaPessoa)){
                familia.removerPessoa(novaPessoa);
                return;
            }
        }
        System.out.println("O nome da pessoa não foi encontrado!");        
    }
}
