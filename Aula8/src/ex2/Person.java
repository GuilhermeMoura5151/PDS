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
public class Person {
    private String name;
    private BankAccount bankAccount;
    
    // Constructor
    public Person(String n) {
    name = n;
    bankAccount = new BankAccountImpl("PeDeMeia", 0);
    }
    
    // Getter & Setter
    public String getName() {
        return name;
    }
    
    
    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
