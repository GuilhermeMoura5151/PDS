

public class exe1 {
	public static void main(String[] args) {
	
		float startTime = System.nanoTime();
		
		Solver sopa = new Solver();// Criamos um objeto da classe
		
		sopa.readPuzzle(); // Construir a sopa de letras
		sopa.readWords(); // Palavras chave
		sopa.printWork(); 
		
		float endTime = System.nanoTime();
		float FinalTime = (endTime - startTime) / 1000000000; // Medir tempo de execucao
		
		System.out.printf("\nElapsed time (sec) %.3f ", FinalTime);	
	}
}
