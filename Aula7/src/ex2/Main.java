/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.io.FileNotFoundException;

/**
 *
 * @author brunop
 */
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Reader read;
        
        read=new TextReader("exemplo.txt");
        if(!read.hasNext())
            System.out.println("TextReader hasNext(): "+read.hasNext());
        while(read.hasNext())
            System.out.println("TextReader next(): "+read.next());
        
        read=new CodeFilter(new TextReader("exemplo.txt"));
        if(!read.hasNext())
            System.out.println("CodeFilter hasNext(): "+read.hasNext());
        while(read.hasNext())
            System.out.println("CodeFilter next(): "+read.next());
        
        read = new ReverseFilter(new TermFilter(new TextReader("exemplo.txt")));
        if (!read.hasNext()) {
            System.out.println("ReverseFilter hasNext(): " + read.hasNext());
        }
        while (read.hasNext()) {
            System.out.println("ReverseFilter next(): " + read.next());
        }
        
        read = new CodeFilter(new ReverseFilter(new TextReader("exemplo2.txt")));
        if (!read.hasNext()) {
            System.out.println("CoderFilter - ReverseFilter -> hasNext(): " + read.hasNext());
        }
    }
    
}
