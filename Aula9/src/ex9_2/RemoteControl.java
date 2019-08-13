/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex9_2;

/**
 *
 * @author guilherme
 */
public class RemoteControl {
    
    private Command command;
    
    public Command getCommand(){
        return command;
    }
    
    public void setCommand(Command command){
        this.command=command;
    }
    
    public void executeCommand(){
        command.execute();
    }
    
}
