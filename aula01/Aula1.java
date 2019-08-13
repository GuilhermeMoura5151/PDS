/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula1;

/**
 *
 * @author guilherme
 */

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Aula1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Puzzle sopa = new Puzzle(); // criamos um objeto da classe
		
                // Puzzle
		sopa.readPuzzle(); // Construir a sopa de letras
		sopa.readWords(); // Palavras chave
		
                
                // Contar tempo a correr
		float startTime = System.nanoTime();
		sopa.wordResolver();
		float endTime = System.nanoTime();
                
                // Resultado
		System.out.printf("\n Running Time (sec) " + (endTime - startTime) / 1000000000);
        
    }
    
}
