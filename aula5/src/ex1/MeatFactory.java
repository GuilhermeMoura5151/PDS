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
public class MeatFactory {
    
    public static Commodity createMeat(Temperature t){
        if(t==Temperature.WARM) return new Pork();
        else return new Tuna();
    }
    
}
