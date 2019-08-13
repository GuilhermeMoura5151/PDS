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
public class ContainerFactory {
    
    public static Container createContainerFor(Commodity c){
        
        if(c.getState()==State.Liquid){
            if(c.getTemperature()==Temperature.WARM) return new TermicBottle();
            else return new PlasticBottle();
        }
        else if(c.getTemperature()==Temperature.WARM) return new Tupperware();
        else return new PlasticBag();
        }
}
