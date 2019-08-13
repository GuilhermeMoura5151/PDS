/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author brunop
 */
public abstract class ReaderDecorator implements Reader {
    
    protected Reader read;
    
    // Constructor
    public ReaderDecorator(Reader read) {
        this.read = read;
    }

    
    @Override
    public boolean hasNext() {
        return read.hasNext();
    }

    @Override
    public String next() {
        return read.next();
    }
    
    
    
}
