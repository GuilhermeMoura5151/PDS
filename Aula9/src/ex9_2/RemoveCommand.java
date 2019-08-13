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
public class RemoveCommand<E> implements Command{
    
    private E removeElement;
    private CollectionReceiver<E> receiver;
    
    public RemoveCommand(CollectionReceiver<E> receiver, E element){
        this.removeElement=element;
        this.receiver=receiver;
    }

    @Override
    public void execute() {
      //To change body of generated methods, choose Tools | Templates.
      receiver.remove(removeElement);
    }
    
    public E getElement(){
        return removeElement;
    }
    
}
