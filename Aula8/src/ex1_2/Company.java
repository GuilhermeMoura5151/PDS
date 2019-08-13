/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1_2;

import ex1.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author guilherme
 */
public class Company {
    
    public static User user;
    private List<Employee> emps = new ArrayList<>();
    
    public void admitEmployee(Person person, double salary){
        Employee e = new Employee(person, salary);
        emps.add(e);
    }
    
    public void paySalaries (int month){
        for(Employee e : emps){
            e.paySalary();
        }
    }
    
    public List<Employee> employees(){
        return Collections.unmodifiableList(emps);
    }
}
