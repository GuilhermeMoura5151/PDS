/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import ex1.*;
import ex1_2.*;

/**
 *
 * @author brunop
 */
public class Employee {
    private Person person;
    private double salary;
    
    // Costructor
    
    public Employee(Person person, double s) {
        this.person = person;
        salary = s;
    }
    
    // Getter & Setter
    public double getSalary() {return salary;}
    public String getName() {return person.getName();}
    
    // Methods
    public void paySalary(){
        BankAccount bank = person.getBankAccount();
        bank.deposit(salary);
    }
}
