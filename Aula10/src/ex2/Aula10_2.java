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
public class Aula10_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Employee emp = EmployeeFactory.getCustomer ("Mac");
        Employee emp2 = EmployeeFactory.getCustomer ("Janela");
        Employee emp3 = EmployeeFactory.getCustomer ("Linux");
        Employee emp4 = EmployeeFactory.getCustomer ("Mack");
        System.out.println(emp.getName());
        System.out.println(emp2.getName());
        System.out.println(emp3.getName());
        System.out.println(emp4.getName());
        
        
        for (int i = 0; i < 1000; i++)
                EmployeeFactory.getCustomer("Miguel");

    }
    
}
