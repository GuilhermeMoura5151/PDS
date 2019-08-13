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
public class BankAccountImpl implements BankAccount {
    private String bank;
    private double balance;
    
    // Constructor
    BankAccountImpl(String bank, double initialDeposit) {
        this.bank = bank;
        balance = initialDeposit;
    }
    
    //Getter & Setter
    public String getBank() {
        return bank;
    }
    
    //Methods
    @Override public void deposit(double amount) {
        balance += amount;
    }
    
    @Override public boolean withdraw(double amount) {
        if (amount > balance )
            return false;
        balance -= amount;
        return true;
    }
    
    @Override public double balance() {
        return balance;
    }
}
