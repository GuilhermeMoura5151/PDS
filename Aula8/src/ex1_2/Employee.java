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
class Employee {
    
    private double salary;
    private Person person;
    
    public Employee(Person person,double s) {
        this.person=person;
        salary=s;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public String getName(){
        return person.getName();
    }
    
    public void paySalary(){
        BankAccount bank = person.getBankAccount();
        bank.deposit(salary);
    }
    
}
