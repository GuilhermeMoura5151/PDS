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
class Employee extends Person{
    
    private double salary;
    
    public Employee(String n,double s) {
        super(n);
        salary=s;
    }
    
    public double getSalary(){
        return salary;
    }
    
}
