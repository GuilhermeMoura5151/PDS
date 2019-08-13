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
public class Tuna implements Commodity{
    
    public Temperature getTemperature(){
        return Temperature.COLD;
    }
    
    public State getState(){
        return State.Solid;
    }
    
    public String toString(){
        return " [commodity = Tuna" + ", Temperature()= " + getTemperature() + ", State()=" + getState() + "]";
    }
}
