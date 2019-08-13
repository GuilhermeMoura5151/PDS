/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author brunop
 */
public class TermFilter extends ReaderDecorator {
    
    Scanner potato = new Scanner(System.in);
    
    public TermFilter(Reader read){
        super(read);
        potato = new Scanner("");
    }

    @Override
    public boolean hasNext() {
        if (!potato.hasNext()) {return read.hasNext();} 
        else {return true;}
    }
    
    @Override
    public String next() {
        if (!potato.hasNext()) {
            potato = new Scanner(read.next());
            return potato.next();
        } else {
            return potato.next();
        }
    }
    
    
    
}
