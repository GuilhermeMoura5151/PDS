/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex9_2;

/**
 *
 * @author guilherme
 * @param <E>
 */
public class UndoCommand<E> implements Command {
    
    private CollectionReceiver<E> receiver;
    
    public UndoCommand(CollectionReceiver<E> receiver){
        this.receiver=receiver;
    }

    @Override
    public void execute() {
        //To change body of generated methods, choose Tools | Templates.
        receiver.undo();        
    }
    
    
    
}
