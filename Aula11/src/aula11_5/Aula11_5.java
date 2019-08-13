/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11_5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.util.Map;

/**
 *
 * @author brunop
 */
public class Aula11_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Path dir = Paths.get("");
        System.out.println("Diretoria atual: " +
                dir.toAbsolutePath().toString());
        SimpleFileVisitor<Path> visitor = new DVisitor();
        try {
            Files.walkFileTree(dir, visitor);
            Map<Path, Map<Path, Integer>> files = 
                (Map<Path, Map<Path, Integer>>) ((DVisitor) visitor).getFiles();
            printFiles(files);
            System.out.println("Tamanho total: " + 
                    ((DVisitor) visitor).getSize() + " bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void printFiles(Map<Path, Map<Path, Integer>> files) {
        for (Path dir : files.keySet()) {
            System.out.println("Diretoria: " + dir);
            for (Map<Path, Integer> file : files.values()) {
                System.out.println("[Ficheiro: " + file.keySet() +
                        " Tamanho: " + file.values() + " bytes]");
            }
        }
    }
}
   
