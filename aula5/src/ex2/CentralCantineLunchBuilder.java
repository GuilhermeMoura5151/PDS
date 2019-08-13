/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author brunop
 * 
 * Builder da CentralCantine
 */
public class CentralCantineLunchBuilder implements LunchBuilder {
    
    private Lunch lunch;
    public CentralCantineLunchBuilder(){
        lunch = new Lunch();
    }
    
    public void buildDrink(){
        // Bebida da Central cantine
        lunch.setDrink("Água");
    }
    
    public void buildMainDish(){
        // Prato principal da Central Cantine
        lunch.setMainDish("Grelhada mista");
    }
    
    public void buildSide(){
        // Acompanhamento da CentralCantine
        lunch.setSide("Queijo fresco");
    }
    
    public Lunch getMeal(){
        return lunch;
    }
    
}
