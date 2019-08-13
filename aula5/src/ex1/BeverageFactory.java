/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author guilherme
 */
public class BeverageFactory {
    
    public static Commodity createBeverage(Temperature t){
        if(t==Temperature.WARM)return new Milk();
        else return new FruitJuice("Orange");
    }
    
}
