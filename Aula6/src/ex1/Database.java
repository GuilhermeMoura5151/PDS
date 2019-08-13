/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.Vector;

/**
 *
 * @author guilherme
 */
public class Database { // Data elements
    
    private Vector<Employee> employees; // Stores the employees

    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        // Code to add employee
        
        if(!employees.contains(employee))
            return employees.add(employee);
        
        return false;
    }

    public boolean deleteEmployee(long emp_num) { // mudado para boolean
        // Code to delete employee
        
        for(Employee emp : employees){
            if(emp.getEmpNum()==emp_num){
                employees.remove(emp);
                return true;
            }
        }
        
        return false;
    }

    public Employee[] getAllEmployees() {
        // Code to retrieve collection
        
        return employees.toArray(new Employee[employees.size()]);
        
    }
    
    
}
