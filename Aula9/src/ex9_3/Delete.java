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
public class Delete extends Chain {
    
    // Constructor
    public Delete(){
        
    }
    
    public void useCommand(String txt, List<String> elems) {
        if (validCommand(txt, getClass().getSimpleName())) {
            elems.remove(elems.size() - 1);
            write();
        } else {
            super.useCommand(txt, elems);
        }
    }

    @Override
    protected void write() {System.out.println("Delete!");}
    
}
