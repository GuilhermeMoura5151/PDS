/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1_2;

import ex1.*;

/**
 *
 * @author guilherme
 */
public class BankAccountImpl implements BankAccount{
    
    private String bank;
    private double balance;

    public BankAccountImpl(String bank, double initialDeposit) {
        this.bank=bank;
        this.balance=initialDeposit;
    }
    

    public String getBank(){
        return bank;
    }
    
    @Override
    public void deposit(double amount) {
        //To change body of generated methods, choose Tools | Templates.
        balance+=amount;
    }

    @Override
    public boolean withdraw(double amount) {
        //To change body of generated methods, choose Tools | Templates.
        if(amount>balance)
            return false;
        balance-=amount;
        
        return true;
    }

    @Override
    public double balance() {
        //To change body of generated methods, choose Tools | Templates.
        return balance;
    }
    
    
}
