

import java.io.*;
import java.util.*;

public class Solver {
	
	//Contador usado para fazer separacao no ficheiro entre puzzle e lista de palavras
	private int count = 0;
	
	//Tamanho da grelha altura/largura
	private int size;
	
	//Array bidimensional para guardar puzzle por coordenadas
	private char[][] puzzle;
	
	//ArrayList para guardar as palavras que temos de encontrar
	private List<String> words = new ArrayList<String>(); 
	

	public void readPuzzle() {

		try (BufferedReader br = new BufferedReader(new FileReader("sdl_01.txt"))) {
			String line = br.readLine(); // Estamos a ler a primeira linha do ficheiro
			
			size = line.length() - 1 ; // Ver tamanho da sopa de letras
			
			if (size > 60) { // Size nao pode ser maior que 60
				System.out.println("O tamanho maximo e 60*60");
				System.exit(1);
			}

			puzzle = new char[size][size]; // Definimos o tamanho do nosso array bidimensional declarado anteriormente

			
			// Nestes dois ciclos for estamos a preencher o nosso array bidimensional
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					puzzle[i][j] = line.charAt(j);
				}
				line = br.readLine();
			}
			
			
		} // Exceptions Handler
		catch (FileNotFoundException e) {
			System.out.println("File was not found!");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IO Error!");
			System.exit(2);
		}
			
	}

	public void readWords() {
		
		try (BufferedReader br = new BufferedReader(new FileReader("sdl_01.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				count++;
				if (count > size) {// So ler a partir do fim da grelha, do seu tamanho portanto
					String[] str = line.split("[, ;]+"); // Delimitacao por , ; ou espaco
					for (int i = 0; i < str.length; i++) {
						String palavra = str[i].trim().toUpperCase(); // Ver se a palavra esta em maiusculas para poder comparar com as letras da sopa
						if (palavra.length() > 1 && palavra.matches("[A-Z]+"))
							words.add(palavra); // Adicionamos palavras com pelo menos 2 caracteres
					}
				}
			}
		} // Exceptions Handler
		catch (FileNotFoundException e) {
			System.out.println("File was not found!");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IO Error!");
			System.exit(2);
		}

	}

	public void printWork() {
		
		//Funcao responsavel pelo trigger da pesquisa
		int n_palavra = 0;
		for (int i = 0; i < words.size(); i++) {
			//Selecionamos cada palavra
			String palavra = words.get(i);
			//Procura do primeiro caracter no puzzle
			gridWalker(palavra, palavra.charAt(0), palavra.length(), n_palavra);
			n_palavra++;
		}

	}
	
	public boolean gridWalker(String palavra, char letra, int tamanho, int n_palavra) {
		boolean c;
		int posicao;
		//A sopa de letras e percorrida char a char
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				//Procuramos a primeira letra da palavra na sopa
				if (puzzle[i][j] == letra) {
					//Guardamos as coordenadas
					Ponto point = new Ponto(i,j);
					posicao = 1;
					//Chamamos a funcao que procura pela palavra em todas as direcoes a partir a primeira letra
					c = searchDirections(point, palavra, tamanho, posicao, n_palavra);
					if (c == true) {
						return true;
					}

				}
			}
		}
		return false;
	}

	public boolean searchDirections(Ponto point, String palavra, int tamanho, int posicao, int n_palavra) {
		boolean a = false;
		//Left(x-1)
		if (searchLeft(point, palavra, tamanho, posicao, n_palavra) == false) {
			//Right(x+1)
			if (searchRight(point, palavra, tamanho, posicao, n_palavra) == false) {
				//Up(y-1)
				if (searchUp(point, palavra, tamanho, posicao, n_palavra) == false) {
					//Down(y+1)
					if (searchDown(point, palavra, tamanho, posicao, n_palavra) == false) {
						//DownRight(y+1,x+1)
						if (searchDownRight(point, palavra, tamanho, posicao, n_palavra) == false) {
							//DownLeft(y+1 ,x-1)
							if (searchDownLeft(point, palavra, tamanho, posicao, n_palavra) == false) {
								//UpLeft(y-1,x-1)
								if (searchUpLeft(point, palavra, tamanho, posicao, n_palavra) == false) {
									//UpRight(y-1,x+1)
									if (searchUpRight(point, palavra, tamanho, posicao, n_palavra) == false) {
										a = false;
									} else
										a = true;
								} else
									a = true;
							} else
								a = true;
						} else
							a = true;
					} else
						a = true;
				} else
					a = true;
			} else
				a = true;
		} else
			a = true;

		return a;
	}

	public boolean searchLeft(Ponto point, String palavra, int tamanho, int posicao, int n_palavra) {
		boolean b = false;
		if (point.getY() > 0 || posicao == (tamanho - 1)) {
			if (palavra.charAt(posicao) == puzzle[point.getX()][point.getY() - 1]) {
				Directions direction;
				point.setY(point.getY() - 1); // Atualizamos o valor do y
				if (posicao == (tamanho - 1)) { // Quando chegar ao fim da palavra
					direction = Directions.LEFT;
					//saveCoordinates(point.getX() + 1, point.getY() + (tamanho), direction, n_palavra);
					printWords(point.getX()+1,point.getY()+tamanho,direction,palavra);
					b = true;
				} else {
					posicao++; // Atualizamos a posicao onde estamos
					return searchLeft(point, palavra, tamanho, posicao, n_palavra); // Chamar recursivamente
				}
			}
		}
		return b;
	}

	public boolean searchRight(Ponto point, String palavra, int tamanho, int posicao, int n_palavra) {
		boolean b = false;
		if (point.getY() < (size - 1) || posicao == (tamanho - 1)) {
			if (palavra.charAt(posicao) == puzzle[point.getX()][point.getY() + 1]) {
				Directions direction;
				point.setY(point.getY() + 1); // Atualizamos o valor do y
				if (posicao == (tamanho - 1)) { // Quando chegar ao fim da palavra
					direction = Directions.RIGHT;
					printWords(point.getX() + 1, point.getY() + (tamanho), direction, palavra);
					b = true;
				} else {
					posicao++; // Atualizamos a posicao onde estamos
					return searchRight(point, palavra, tamanho, posicao, n_palavra); // Chamar recursivamente
				}
			}
		}
		return b;
	}

	public boolean searchUp(Ponto point, String palavra, int tamanho, int posicao, int n_palavra) {
		boolean b = false;
		if (point.getX() > 0 || posicao == (tamanho - 1)) {//elimina casos fora do puzzle
			if (palavra.charAt(posicao) == puzzle[point.getX() - 1][point.getY()]) {
				Directions direction;
				point.setX(point.getX() - 1); // atualizamos o valor do X
				if (posicao == (tamanho - 1)) { // qd chegarmos ao fim da
												// palavra
					direction = Directions.UP;
					printWords(point.getX() + tamanho, point.getY() + 1, direction, palavra);
					b = true;
				} else {
					posicao++; // atualizamos a posicao onde estamos
					return searchUp(point, palavra, tamanho, posicao, n_palavra); // chamar
																					// recursivamente
				}
			}
		}
		return b;
	}

	public boolean searchDown(Ponto point, String palavra, int tamanho, int posicao, int n_palavra) {
		boolean b = false;
		if (point.getX() < (size - 1) || posicao == (tamanho - 1)) {
			if (palavra.charAt(posicao) == puzzle[point.getX() + 1][point.getY()]) {
				Directions direction;
				point.setX(point.getX() + 1); // atualizamos o valor do X
				if (posicao == (tamanho - 1)) { // qd chegarmos ao fim da
												// palavra
					direction = Directions.DOWN;
					printWords(point.getX() - (tamanho) + 2, point.getY() + 1, direction, palavra);
					b = true;
				} else {
					posicao++; // atualizamos a posicao onde estamos
					return searchDown(point, palavra, tamanho, posicao, n_palavra); // chamar
																					// recursivamente
				}
			}
		}
		return b;
	}

	public boolean searchDownRight(Ponto point, String palavra, int tamanho, int posicao, int n_palavra) {
		boolean b = false;

		if (point.getY() < (size - 1) && point.getX() < (size - 1) || posicao == (tamanho - 1)) {
			if (palavra.charAt(posicao) == puzzle[point.getX() + 1][point.getY() + 1]) {
				Directions direction;
				point.setX(point.getX() + 1); // atualizamos o valor do X
				point.setY(point.getY() + 1);
				if (posicao == (tamanho - 1)) { // qd chegarmos ao fim da
												// palavra
					direction = Directions.DOWNRIGHT;
					printWords(point.getX() - tamanho + 2, point.getY() - tamanho + 2, direction, palavra);
					b = true;
				} else {
					posicao++; // atualizamos a posicao onde estamos (esta e a
								// posicao da palavra)
					return searchDownRight(point, palavra, tamanho, posicao, n_palavra); // chamar
																							// recursivamente
				}
			}
		}
		return b;
	}

	public boolean searchDownLeft(Ponto point, String palavra, int tamanho, int posicao, int n_palavra) {
		boolean b = false;
		if (point.getY() > 0 && point.getX() < (size - 1) || posicao == (tamanho - 1)) {
			if (palavra.charAt(posicao) == puzzle[point.getX() + 1][point.getY() - 1]) {
				Directions direction;
				point.setX(point.getX() + 1); // atualizamos o valor do X
				if (posicao == (tamanho - 1)) { // qd chegarmos ao fim da
												// palavra
					direction = Directions.DOWNLEFT;
					printWords(point.getX() - (tamanho), point.getY() + tamanho, direction, palavra);
					b = true;
				} else {
					posicao++; // atualizamos a posicao onde estamos
					return searchDownLeft(point, palavra, tamanho, posicao, n_palavra); // chamar
																						// recursivamente
				}
			}
		}
		return b;
	}

	public boolean searchUpRight(Ponto point, String palavra, int tamanho, int posicao, int n_palavra) {
		boolean b = false;

		if (point.getY() < (size - 1) && point.getX() > 0 || posicao == (tamanho - 1)) {
			if (palavra.charAt(posicao) == puzzle[point.getX() - 1][point.getY() + 1]) {
				Directions direction;
				point.setX(point.getX() + 1); // atualizamos o valor do X
				point.setY(point.getY() + 1);
				if (posicao == (tamanho - 1)) { // qd chegarmos ao fim da
												// palavra
					direction = Directions.UPRIGHT;
					printWords(point.getX() - tamanho + 2, point.getY() - tamanho + 2, direction, palavra);
					b = true;
				} else {
					posicao++; // atualizamos a posicao onde estamos (esta e a
								// posicao da palavra)
					return searchUpRight(point, palavra, tamanho, posicao, n_palavra); // chamar
																						// recursivamente
				}
			}
		}
		return b;
	}

	public boolean searchUpLeft(Ponto point, String palavra, int tamanho, int posicao, int n_palavra) {
		boolean b = false;
		if (point.getY() > 0 && point.getX() > 0 || posicao == (tamanho - 1)) {
			if (palavra.charAt(posicao) == puzzle[point.getX() - 1][point.getY() - 1]) {
				Directions direction;
				point.setX(point.getX() + 1); // Atualizamos o valor do X
				if (posicao == (tamanho - 1)) { // Quando chegar ao fim da palavra
					direction = Directions.UPLEFT;
					printWords(point.getX() - (tamanho), point.getY() + tamanho, direction, palavra);
					b = true;
				} else {
					posicao++; // Atualizamos a posicao onde estamos
					return searchUpLeft(point, palavra, tamanho, posicao, n_palavra); // Chamar recursivamente
				}
			}
		}
		return b;

	}

	public void printWords(int linha, int col, Directions direction, String palavra){
		
		//Print das palavras e respetiva informacao
		System.out.printf("%s \t%d \t%d,%d \t%s \n",palavra,palavra.length(),linha,col,direction);
		
	}	
}
