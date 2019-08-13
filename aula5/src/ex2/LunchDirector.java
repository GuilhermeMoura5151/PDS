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
public class LunchDirector {
     private LunchBuilder lunch;
     public LunchDirector(LunchBuilder lunch){
         lunch = lunch;
     }
     
     public void constructMeal(){
         lunch.buildDrink();
         lunch.buildMainDish();
         lunch.buildSide();
     }
     
     public Lunch getMeal(){
         return lunch.getMeal();
     }
    
    
    
    
}
