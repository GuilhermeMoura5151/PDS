/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex9_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author guilherme
 * @param <E>
 */
public class CollectionReceiver<E> {
    
    private Collection<E> collection;
    private Collection<E> previousCollection;
    
    public CollectionReceiver(Collection<E> collection){
        this.collection=this.previousCollection=collection;
    }
    
    public void add(E element){
        
        saveState(); // Internet
        collection.add(element);
    }
    
    public void remove(E element){
        
        saveState(); // Internet
        collection.remove(element);
    }    
    
    public void undo(){
        if (previousCollection == null) {
            throw new IllegalStateException("...");
        }
        
        collection=previousCollection;
        previousCollection=null;
        
    }
    
    public String toString(){
        return collection.toString();
    }
    
    // Internet
    
    private void saveState(){
        previousCollection=cloneCollection();
    }
    
    private Collection<E> cloneCollection(){
        Collection<E> tmp = new ArrayList<>();
        for(Iterator<E> it = collection.iterator();it.hasNext();){
            tmp.add(it.next());
        }
        return tmp;
    }

}
