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
public class Insurance {
    private List<Employee> person;
    
    // Constructor
    public Insurance(){
        person = new ArrayList<>();
    }
    
    // Methods
    
    public void regist(Employee x){person.add(x);}
    
    
}
