
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class exe2 {

	public static void main(String[] args) {
		
		
		ArrayList<String> palavras = new ArrayList<>(); 
		
		//criar sopa matriz
		char[][] sopa = new char[10][10];
		
		readWords(palavras);
		inserir(palavras,sopa);
		print(sopa);
		
		System.out.println(palavras);
		
		
		
	}

	public static void readWords(ArrayList<String> palavras) {
		
		try (BufferedReader br = new BufferedReader(new FileReader("wordlist_1.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				
				 
					String[] str = line.split("[, ;]+");
					for (int i = 0; i < str.length; i++) {
						String palavra = str[i].trim().toUpperCase();
						if (palavra.length() > 1 && palavra.matches("[A-Z]+"))
							palavras.add(palavra); // Adicionamos palavras com pelo menos 2 caracteres
					}
				}
			}
		// Exceptions Handler
		catch (FileNotFoundException e) {
			System.out.println("File was not found!");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IO Error!");
			System.exit(2);
		}

	}
	
	
	public static void inserir(ArrayList<String> palavras,char[][] sopa)   {

		for (int i = 0; i < sopa.length; i++) {
            for (int j = 0; j < sopa.length; j++) {

                sopa[i][j] = '0';

            }
        }
	
		
		 for (String ss : palavras) {
	            String s = ss.toUpperCase();
	            //System.out.println(s);
	            while (true) {
	                int r1 = ThreadLocalRandom.current().nextInt(0, sopa.length - 1);
	                int r2 = ThreadLocalRandom.current().nextInt(0, sopa.length - 1);
	                //numeros random  entre 0 e o tamanho da sopa - 1
	                if (sopa[r1][r2] == '0') {
	                    String ori = Directions.randomDirection().toString();
	                    if (ori.equals("UP")) {
	                        while (r1 < s.length()) {
	                            r1 = ThreadLocalRandom.current().nextInt(0, sopa.length);
	                        }
	                        for (int c = 0; c < s.length(); c++) {
	                            sopa[r1 - c][r2] = s.charAt(c);
	                            //System.out.printf("%d %d", r1-c,r2);
	                        }
	                        break;

	                    }
	                    if (ori.equals("LEFT")) {
	                        while (r2 < s.length()) {
	                            r2 = ThreadLocalRandom.current().nextInt(0, sopa.length);
	                        }
	                        for (int c = 0; c < s.length(); c++) {
	                            sopa[r1][r2 - c] = s.charAt(c);
	                            //System.out.printf("%d %d", r1,r2-c);
	                        }
	                        break;

	                    }
	                    if (ori.equals("RIGHT")) {
	                        while ((sopa.length - r2) < s.length()) {
	                            r2 = ThreadLocalRandom.current().nextInt(0, sopa.length);
	                        }
	                        for (int c = 0; c < s.length(); c++) {
	                            sopa[r1][r2 + c] = s.charAt(c);
	                            //System.out.printf("%d %d", r1,r2+c);
	                        }
	                        break;

	                    }
	                    if (ori.equals("DOWN")) {
	                        while ((sopa.length - r1) < s.length()) {
	                            r1 = ThreadLocalRandom.current().nextInt(0, sopa.length);
	                        }
	                        for (int c = 0; c < s.length(); c++) {
	                            sopa[r1 + c][r2] = s.charAt(c);
	                            //System.out.printf("%d %d", r1+c,r2);
	                        }
	                        break;

	                    }
	                    if (ori.equals("DOWNRIGHT")) {
	                        while ((sopa.length - r1) < s.length() || (sopa.length - r2) < s.length()) {
	                            r1 = ThreadLocalRandom.current().nextInt(0, sopa.length);
	                            r2 = ThreadLocalRandom.current().nextInt(0, sopa.length);
	                        }
	                        for (int c = 0; c < s.length(); c++) {
	                            sopa[r1 + c][r2 + c] = s.charAt(c);
	                            //System.out.printf("%d %d", r1+c,r2+c);
	                        }
	                        break;
	                    }
	                    if (ori.equals("DOWNLEFT")) {
	                        while ((sopa.length - r1) < s.length() || r2 < s.length()) {
	                            r1 = ThreadLocalRandom.current().nextInt(0, sopa.length);
	                            r2 = ThreadLocalRandom.current().nextInt(0, sopa.length);
	                        }
	                        for (int c = 0; c < s.length(); c++) {
	                            sopa[r1 + c][r2 - c] = s.charAt(c);
	                            //System.out.printf("%d %d", r1+c,r2-c);
	                        }
	                        break;
	                    }
	                    if (ori.equals("UPRIGHT")) {
	                        while (r1 < s.length() || (sopa.length - r2) < s.length()) {
	                            r1 = ThreadLocalRandom.current().nextInt(0, sopa.length);
	                            r2 = ThreadLocalRandom.current().nextInt(0, sopa.length);
	                        }
	                        for (int c = 0; c < s.length(); c++) {
	                            sopa[r1 - c][r2 + c] = s.charAt(c);
	                            //System.out.printf("%d %d", r1-c,r2+c);
	                        }
	                        break;
	                    }
	                    if (ori.equals("UPLEFT")) {
	                        while (r1 < s.length() || r2 < s.length()) {
	                            r1 = ThreadLocalRandom.current().nextInt(0, sopa.length);
	                            r2 = ThreadLocalRandom.current().nextInt(0, sopa.length);
	                        }
	                        for (int c = 0; c < s.length(); c++) {
	                            sopa[r1 - c][r2 - c] = s.charAt(c);
	                            //System.out.printf("%d %d", r1-c,r2-c);
	                        }
	                        break;
	                    }
	                }
	            }
	        }
	

		 
	String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	Random r = new Random();
	int low = 0;
	int high = sopa.length-1;
	
	
	for (int x = 0; x < sopa.length; x++) {
            for (int y = 0; y < sopa.length; y++) {
                if (sopa[x][y] == '0') {
                	int result = r.nextInt(high-low) + low;
                    sopa[x][y] = alfabeto.charAt(result);
                    
                }

            }
        }
	}
	
	public static void print(char[][] sopa) {
		
	int count=0;
	
	
	
	for (int x = 0; x < sopa.length; x++) {
		
        for (int y = 0; y < sopa.length; y++) {
        		System.out.printf("%s",sopa[x][y]);
        		count++;
        		if (count==10) {
        			System.out.print("\n");
        			count=0;
        }
	}
	
	
	}
	}
}
