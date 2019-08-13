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
 * Builder da cantina do Crasto
 */
public class CrastoLunchBuilder implements LunchBuilder {
    private Lunch lunch;
    public CrastoLunchBuilder(){ 
        lunch = new Lunch();
    }
    
    public void buildDrink(){
        // Bebida do Crasto
        lunch.setDrink("Vinho Tinto");
    }
    
    public void buildMainDish(){
        // Prato principal do Crasto
        lunch.setMainDish("Bacalhau à lagareiro");
    }
    
    public void buildSide(){
        // Acompanhamento do Craso
        lunch.setSide("Broa");
    }
    
    public Lunch getMeal(){
        return lunch;
    }
    
    
}
