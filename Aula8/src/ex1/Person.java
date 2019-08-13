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
public class Person {
    
    private String name;
    private BankAccount bankAccount;
    
    public Person(String n){
        name=n;
        bankAccount=new BankAccountProxy("PeDeMeia",0);
    }
    
    public String getName(){
        return name;
    }
    
    public BankAccount getBankAccount(){
        return bankAccount;
    }
    
}
