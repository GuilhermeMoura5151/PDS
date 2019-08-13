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

import java.util.Date;

public class Employee implements EmployeeInterface {
    
    private String name;
    private Date dataStart;
    private Date dataTerm;
    
    public Employee(String name){
        this.name = name;	
    }

    @Override
    public void start(Date dataS) {
        dataStart=dataS;
    }

    @Override
    public void terminate(Date dataT) {
        dataTerm=dataT;
    }

    @Override
    public void work() {
        System.out.print(name + " works ");
    }
    
    
    
}
