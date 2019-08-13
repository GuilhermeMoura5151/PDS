/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.util.List;
import java.util.Map;

/**
 *
 * @author brunop
 */
public class EmployeeManagerFacade {
    
    private SocialSecurity security;
    private Insurance insurance;
    private Parking park;
    private Map<EmployeeCard, Employee> card;
    private List<Employee> emps;

    // Constructor
    public EmployeeManagerFacade(SocialSecurity security, Insurance insurance, 
            Parking park, Map<EmployeeCard, Employee> card, List<Employee> emps) {
        this.security = security;
        this.insurance = insurance;
        this.park = park;
        this.card = card;
        this.emps = emps;
    }
    
    // Methods
    public void registEmployee(Person person, double salary) {

        Employee x = new Employee(person, salary);
        security.regist(x);
        insurance.regist(x);
        if (salary > averageSalary()) {
            park.allow(x);
        }
        emps.add(x);
        EmployeeCard employeeCard = new EmployeeCard(card.size(), x.getName());
        card.put(employeeCard, x);
    }

    public double averageSalary() {

        int numberEmps = emps.size();
        double sum = 0;
        for (Employee e : emps) {
            sum += e.getSalary();
        }
        return sum / numberEmps;
    }

    public List<Employee> personsAllowedToPark() {

        return park.getPerson();
    }
    
}
