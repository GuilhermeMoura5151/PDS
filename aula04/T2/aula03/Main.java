

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Rua street = new Rua();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("> ");
		String input = sc.nextLine();
		
		while(!input.toLowerCase().equals("quit")) {
			String[] div = input.split(" ");
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
			}else if(div[0].toLowerCase().equals("help")){
					System.out.println("Comandos: Load, Map, Add, Remove, List, Lookup, Clear, Quit");
			}else {
				System.out.println("Comando Invalido");
				System.out.println("Digite 'Help' para obter ajuda");
			}
			System.out.print("> ");
			input = sc.nextLine();
		}
		sc.close();
	}

}
