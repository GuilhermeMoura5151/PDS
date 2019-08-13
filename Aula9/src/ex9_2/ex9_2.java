/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex9_2;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author guilherme
 */
public class ex9_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<String> stringList = new ArrayList<>();
        CollectionReceiver<String> collection = new CollectionReceiver<>(stringList);
        
        RemoteControl controler = new RemoteControl();
        Command addHello = new AddCommand<String>(collection, "Um Pinto");
        Command addWorld = new AddCommand<String>(collection, "Dois Pintos");
        Command undo = new UndoCommand<>(collection);
        
        // Add Hello
        controler.setCommand(addHello);
        controler.executeCommand();
        
        // Add World
        controler.setCommand(addWorld);
        controler.executeCommand();
        
        System.out.println(collection);
        
        controler.setCommand(undo);
        controler.executeCommand();
        System.out.println(collection);
        
    }
    
}
