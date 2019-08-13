/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author guilherme
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PuzzleCreator{
    
    public static void main(String[] args){
        String inputFile = "wordlist_1.txt";
        String outputFile = "sopa.txt";

        if (args.length == 1) {inputFile = args[0];}
        else if (args.length == 2) {
            inputFile = args[0];
            outputFile = args[1];
        } else if (args.length > 2) {
            System.err.println("Num de argumentos invalido.");
            System.exit(1);
        }
        
        List<String> words = readWordsFromFile(inputFile);
        Puzzle puzzle = new Puzzle(words);
        
        if (outputFile != null) {printInFile(outputFile, puzzle.toString());}
        else {System.out.println(puzzle);}
   
    }
    
    private static void printInFile(String fileName, String puzzle) {
        File file = new File(fileName);
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        printWriter.println(puzzle);
        printWriter.close();
    }
    
    private static List<String> readWordsFromFile(String fileName) {

       
        List<String> words = new ArrayList();
        String line;
        File file = new File(fileName);
        
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                if (line.contains(",")) {
                    String[] split = line.split(",");
                    for (String s : split) { words.add(s.trim().toUpperCase());}
                } else if (line.contains(";")) {
                    String[] split = line.split(";");
                    for (String s : split) { words.add(s.trim().toUpperCase()); }
                } else if (!line.isEmpty()) { words.add(line.trim().toUpperCase());}
            }
            sc.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        return words;
    }
    
}
