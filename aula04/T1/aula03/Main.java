

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		Rua rua = new Rua();
		
		BufferedReader br = new BufferedReader(new FileReader("exemplo1.txt"));
		String line;
		br.close();
		File file = new File("exemplo1.txt");
		
		Scanner fileInput;
		
		while (fileInput.hasNextLine()){
		  //Ler linha a linha do ficheiro
          String[] command = fileInput.nextLine().split(" ");
          String mainCommand = command[0].toUpperCase();
          Menu(sc, rua, command, mainCommand);	//Será criado um menu para esta função funcionar
		}
	
		sc.close();
	}
}
