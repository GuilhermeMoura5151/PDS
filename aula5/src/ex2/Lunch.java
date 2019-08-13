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
public class Lunch {
    private String drink;
    private String mainDish;
    private String side;
    
    
    // Getters & Setters
    public String getDrink() {return drink;}
    public void setDrink(String drink) {this.drink = drink;}
    
    public String getMainDish() {return mainDish;}
    public void setMainDish(String mainDish) {this.mainDish = mainDish;}
    
    public String getSide() {return side;}
    public void setSide(String side) {this.side = side;}
    
    @Override
    public String toString() {
            return "Lunch [drink=" + drink + ", mainCourse=" + mainDish
                            + ", side=" + side + "]";
    }


    
    
}
