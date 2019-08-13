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
public class Pork implements Commodity{
    
    public Temperature getTemperature(){
        return Temperature.WARM;
    }
    
    public State getState(){
        return State.Solid;
    }
    
    public String toString(){
        return " [commodity = Pork" + ", Temperature()= " + getTemperature() + ", State()=" + getState() + "]";
    }
    
}
