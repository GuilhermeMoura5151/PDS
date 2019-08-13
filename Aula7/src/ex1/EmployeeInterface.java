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
public interface EmployeeInterface {
    
    public void start(Date dataS);
    public void terminate(Date dataT);
    public void work();
    
}
