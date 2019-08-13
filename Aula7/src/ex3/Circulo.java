/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

/**
 *
 * @author brunop
 */
public class Circulo implements Component {
    
    private String name;
    
    // Constructor
    public Circulo(String name){
         this.name = name;
     }
    
    // toString
    @Override
    public void draw() {
       System.out.println("\t" + this.getClass().getSimpleName().toString()
               + " " + name);
    }
    
}
