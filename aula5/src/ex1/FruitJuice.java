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
public class FruitJuice implements Commodity{
    
    String fruit;
    
    public FruitJuice(String fruit){
        this.fruit=fruit;
    }
    
    public Temperature getTemperature(){
        return Temperature.COLD;
    }
    
    public State getState(){
        return State.Liquid;
    }
    
    public String toString(){
        return " [commodity = FruitJuice" + "fruit=" + fruit + ", Temperature()= " + getTemperature() + ", State()=" + getState() + "]";
    }
}
