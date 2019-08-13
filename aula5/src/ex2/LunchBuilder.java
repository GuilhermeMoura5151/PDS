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

public interface LunchBuilder{
    public void buildDrink();
    public void buildMainDish();
    public void buildSide();
    public Lunch getMeal();

}
