/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.Date;

/**
 *
 * @author brunop
 */
public class Main {
    
    public static void main(String[] args){
        
              
        EmployeeInterface e1=new Employee("Guilherme");
        EmployeeInterface e2=new Employee("Bruno");
        
        EmployeeInterface mng=new TeamManager(e2);
        mng.work();
        
        EmployeeInterface leader=new TeamLeader(e1);
        leader.work();
        
        
    }
    
}
