/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.Date;

/**
 *
 * @author guilherme
 */
public class TeamLeader extends EmployeeDecorator{
    
    public TeamLeader(EmployeeInterface ef){
        super(ef);
    }
    
    @Override
    public void work(){
        ef.work();
        System.out.print(" Team Leader. \n");
    }
    
    @Override
    public void start(Date dataS){
        ef.start(dataS);
    }
    
    @Override
    public void terminate(Date dataT){
        ef.terminate(dataT);
    }
    
    public void plan(){
        System.out.println("Plan.");
    }
    
}
