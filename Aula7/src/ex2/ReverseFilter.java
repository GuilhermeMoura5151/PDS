/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;
import java.util.Scanner;
/**
 *
 * @author brunop
 */
public class ReverseFilter extends ReaderDecorator{
    
    Scanner potato = new Scanner(System.in);
    
    // Constructor
    public ReverseFilter(Reader reader){
        super(reader);
        potato = new Scanner("");
    }
    
    // Word Inverter
    private String invertWord(String word) {
        StringBuilder some  = new StringBuilder();
        for(int i = word.length() - 1; i >= 0; i--) {
            some.append(word.charAt(i));
        }
        return some.toString();
    }
    
    @Override
    public boolean hasNext() {
        if (!potato.hasNext()) {return read.hasNext();} 
        else {return true;}
    }
    
    @Override
    public String next() {
            if(!potato.hasNext()) {potato = new Scanner(read.next());}
            return invertWord(potato.next());
    }

    
}
