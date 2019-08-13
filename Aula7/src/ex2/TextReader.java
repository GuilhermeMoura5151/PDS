/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author brunop
 */
public class TextReader implements Reader {
    
    Scanner potato = new Scanner(System.in);
    
    // Constructor
    public TextReader(String file_name) throws FileNotFoundException {
        File file1 = new File(file_name);
        potato = new Scanner(file1);
        potato.useDelimiter("(\\.)(\\s?)(\n)");
    }

    public TextReader(File file1) throws FileNotFoundException {
        potato = new Scanner(file1);
    }

    @Override
    public boolean hasNext() {
        return potato.hasNext();
    }

    @Override
    public String next() {
        return potato.next();
    }
        
    
    
    
    
    
    
    
}
