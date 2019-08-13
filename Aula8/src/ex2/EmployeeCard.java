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
public class EmployeeCard {
    
    private int id;
    private String name;
    private int code;

    // Constructor
    public EmployeeCard(int id, String name) {
        this.id = id;
        this.name = name;
        this.code = name.hashCode() * id;
    }

    // Getter & Setter
    
    public int getId() {return id;}

    public String getName() {return name;}

    public int getCode() {return code;}
}
