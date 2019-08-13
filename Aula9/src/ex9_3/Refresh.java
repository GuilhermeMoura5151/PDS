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
public class Refresh extends Chain {
    
    // Constructor
    public Refresh(Chain succ) {
        this.setSucessor(succ);
    }

    public void useCommand(String txt, List<String> elems) {
        if (validCommand(txt, getClass().getSimpleName())) {
            String value = elems.get(elems.size() - 1);
            elems.remove(elems.size() - 1);
            elems.add(value + " Refreshed");
            write();
        } else {
            super.useCommand(txt, elems);
        }
    }
    
    @Override
    protected void write() {System.out.println("Refresh!");}
    
}
