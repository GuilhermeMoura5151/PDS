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
 * Builder do Snack
 */
public class SnackLunchBuilder implements LunchBuilder {
    private Lunch lunch;
    public SnackLunchBuilder(){
        lunch = new Lunch();
    }
    
    public void buildDrink(){
        // Bebida do Snack
        lunch.setDrink("Sumo");
    }
    
    public void buildMainDish(){
        // Prato principal do Snack
        lunch.setMainDish("Pão com Panado");
    }
    
    public void buildSide(){
        // Acompanhamento do Snack
        lunch.setSide("Rissol");
    }
    
    public Lunch getMeal(){
        return lunch;
    }
}
