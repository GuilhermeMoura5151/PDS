/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex9_3;

import java.util.List;

/**
 *
 * @author brunop
 */
public class Create extends Chain {

    // Constructor
    public Create(Chain succ) {
        this.setSucessor(succ);
    }
    
    public void useCommand(String txt, List<String> elems) {
        if (validCommand(txt, getClass().getSimpleName())) {
            write();
        } else {
            super.useCommand(txt, elems);
        }
    }
    
    @Override
    protected void write() {System.out.println("Create!");}
    
    
}
