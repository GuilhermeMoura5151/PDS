/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import ex1.*;
import ex1_2.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author brunop
 */
public class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>();
    private Map<EmployeeCard, Employee> cards = new HashMap<>();
    private EmployeeManagerFacade facade = new EmployeeManagerFacade(new SocialSecurity(), new Insurance(), new Parking(), cards, emps);

    public void admitEmployee(Person person, double salary) {
        Employee e = new Employee(person, salary);
        emps.add(e);
    }

    public List<Employee> personsAllowedToPark() {
        return facade.personsAllowedToPark();
    }

    public void paySalaries(int month) {
        for (Employee e : emps) {
            e.paySalary();
        }
    }
    
    public double getAverageSalary() {
        return facade.averageSalary();
    }

    public List<Employee> employees() {
        return Collections.unmodifiableList(emps);
    }
    
    
}
