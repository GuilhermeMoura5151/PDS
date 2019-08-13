

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainCommands {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Rua street = new Rua();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira ficheiro de comandos");
		System.out.print("> ");
		String fic = sc.nextLine();
		
		BufferedReader buf = new BufferedReader(new FileReader(fic));
		
		String linha = buf.readLine();
		while(linha!=null) {
			String[] div = linha.split(" ");
			
			if(div[0].toLowerCase().equals("load")) {
				street.load(div[1]);
			}else if(div[0].toLowerCase().equals("map")){
				street.print();
			}else if(div[0].toLowerCase().equals("add")){
				street.add(div[1], Integer.parseInt(div[2]), Integer.parseInt(div[3]));
			}else if(div[0].toLowerCase().equals("remove")){
				street.remove(div[1]);
			}else if(div[0].toLowerCase().equals("clear")){
				street.Clear();
			}else if(div[0].toLowerCase().equals("lookup")){
				street.look(div[1]);
			}else if(div[0].toLowerCase().equals("list")){
				street.list();
			}else if(div[0].toLowerCase().equals("quit")){
				System.exit(0);
			}
			
			linha = buf.readLine();
		}
		
		
		buf.close();
		sc.close();
	}

}
