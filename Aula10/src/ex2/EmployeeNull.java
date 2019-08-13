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
public class EmployeeNull extends Employee {
    private String nameReturn;
	
    static private EmployeeNull instance = null; 

    // Constructor
    private EmployeeNull(String name) {
            this.nameReturn = name;
    }

    static public synchronized EmployeeNull getInstance() {
            if (instance == null)
                    instance = new EmployeeNull("No one");

            return instance;
    }

    @Override
    public String getName() {return nameReturn;}
    
}
