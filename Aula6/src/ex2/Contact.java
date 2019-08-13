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
public class Contact {
    
    // Atributes
    private String name;
    private int telnumber;
    private String address;
    
    // Constructor
    public Contact(String name, int telnumber, String address){
        this.name = name;
        this.telnumber = telnumber;
        this.address = address;
    }
    
    // Getters

    public String getName() {
        return name;
    }

    public int getTelNumber() {
        return telnumber;
    }

    public String getAddress() {
        return address;
    }
    
    // ToString

    @Override
    public String toString() {
        return "Contact{" + "name=" + name + ", telnumber=" + telnumber + ", address=" + address + '}';
    }
    
}
