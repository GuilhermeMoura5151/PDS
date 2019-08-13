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
public abstract class Chain {
    private Chain succ;
    
    // Getter & Setter
    public Chain getSucessor() {
		return succ;
	}
	
    public void setSucessor(Chain succ) {
            this.succ = succ;
    }
    
    public void useCommand(String txt, List<String> elems) {
	if(getSucessor() != null){
            getSucessor().useCommand(txt, elems);
        }else{
            System.err.println("not found");
	}
    }
    
    public boolean validCommand(String txt, String comm) {
            return txt.equalsIgnoreCase(comm);
    }

    abstract void write();
}
    
    
