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
public class Programmer extends Employee {
    
    // Constructor
    public Programmer(String name) {this.name = name;}
    
    // Getter & Setter
    @Override
    public String getName() {return name;}
    
}
