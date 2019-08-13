/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author guilherme
 */
public abstract class Container {
    
    protected Commodity commodity;
    
    public boolean placeCommodity(Commodity c){
        this.commodity=c;
        return true;
    }
    
    @Override
    public String toString(){
        return commodity.toString();
    }
    
}
