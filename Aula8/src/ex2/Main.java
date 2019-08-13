/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import ex1.*;
import ex1_2.*;
import java.util.List;

/**
 *
 * @author guilherme
 */
public class Main {
    public static void main(String[] args) {
        
        Person[] persons = {new Person("Maria Silva"),
            new Person("Manuel Pereira"),
            new Person("Aurora Machado"),
            new Person("Augusto Lima")
        };
        Company shark = new Company();
        Company.user = User.COMPANY;
        shark.admitEmployee(persons[0], 1000);
        shark.admitEmployee(persons[1], 900);
        shark.admitEmployee(persons[2], 1200);
        shark.admitEmployee(persons[3], 1100);
        List<Employee> sharkEmps = shark.employees();
        for (Employee e : sharkEmps)
            // "talking to strangers", but this is not a normal case
            System.out.println(e.getSalary());
        shark.paySalaries(1);
        List<Employee> emps = shark.personsAllowedToPark();
        System.out.println("Average of salaries: " + shark.getAverageSalary());
        System.out.println("Employees allowed to park");
        for (Employee e : emps) {
            System.out.println("Name: " + e.getName() + ", Salary: " 
                    + e.getSalary());
       

        }
    }
}
   