/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author brunop
 */
public class Bloco implements Component {
    
    private List<Component> component;
    private String name;
    
    // Constructor

    public Bloco(String name) {
        component = new ArrayList<>();
        this.name = name;
    }
    
    // Getter
    public String getName() {return name;}
    
    // Adder
    public boolean add(Component compon){return component.add(compon);} 
    
    // toString

    @Override
    public void draw() {
        System.out.println("Window " + name);
        for(Component x : component){
            System.out.print("\t");
            x.draw();
        }
    
    }
}
