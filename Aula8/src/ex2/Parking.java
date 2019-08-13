/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author brunop
 */

public class Parking {
    
    private List<Employee> person;
    
    // Constructor
    public Parking(){
        person = new ArrayList<>();
    }
    
    // Getter & Setter
    
    public List<Employee> getPerson(){return person;}

    // Methods
    
    public void allow(Employee x){person.add(x);}  
    
}
