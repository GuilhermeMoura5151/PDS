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
public class AddCommand<E> implements Command{

    private E addElement;
    private CollectionReceiver<E> receiver;
    
    public AddCommand(CollectionReceiver<E> receiver, E element){
        this.addElement=element;
        this.receiver=receiver;
    }
    
    @Override
    public void execute() {
        //To change body of generated methods, choose Tools | Templates.
        receiver.add(addElement);
        
    }
    
    public E getElement(){
        return addElement;
    }
    
}
