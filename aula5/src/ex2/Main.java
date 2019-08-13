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
public class Main {
    
    public static void main(String[] args) {
        LunchBuilder lunch = new CrastoLunchBuilder();
        LunchDirector mealDirector = new LunchDirector(lunch);
        mealDirector.constructMeal();
        Lunch meal = mealDirector.getMeal();
        
        System.out.println("Ana's meal is: " + meal);
        mealDirector = new LunchDirector(new SnackLunchBuilder());
        mealDirector.constructMeal();
        meal = mealDirector.getMeal();
        
        System.out.println("Rui's meal is: " + meal);
        mealDirector = new LunchDirector(new CentralCantineLunchBuilder());
        mealDirector.constructMeal();
        meal = mealDirector.getMeal();
        System.out.println("My meal is: " + meal);
}
    
}
