/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex9_1;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *
 * @author brunop
 */
public class VectorGeneric<T> {
    
    private T[] vec;
    private int nElem;
    private final static int ALLOC = 50;
    private int dimVec = ALLOC;

    // Constructor
    @SuppressWarnings("unchecked")
    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }

    public boolean addElem(T elem) {
        if (elem == null){
            return false;
        }   
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }

    private void ensureSpace() {
        if (nElem>=dimVec) {
            dimVec += ALLOC;
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[dimVec];
            System.arraycopy(vec, 0, newArray, 0, nElem );
            vec = newArray;
        }
    }

    public boolean removeElem(T elem) {
        for (int i = 0; i < nElem; i++) {
            if (vec[i].equals(elem)) {
                if (nElem-i-1 > 0){ // not last element
                    System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
                }
                vec[--nElem] = null; // libertar último objecto para o GC
                return true;
                }
            }
        return false;
    }
    
    public int totalElem() {
        return nElem;
    }

    public T getElem(int i) {
        return (T) vec[i];
    }
    
    public Iterator<T> iterator(){
        return new VectorIterator<>();
    }
    
    public VectorListIterator<T> listIterator(){
        return new VectorListIterator<>(0);
    }
    
    public VectorListIterator<T> listIterator(int idx){
        return new VectorListIterator<>(idx);
    }
    
    private class VectorIterator<E> implements Iterator<E> {
        private int idx = 0;
    
        @Override
        public boolean hasNext(){
            return(idx < nElem);
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public E next(){
            if(hasNext()){
                return (E) vec[idx++];
            }
            throw new NoSuchElementException("Empty");
        }
    }
    
    private class VectorListIterator<E> implements ListIterator<E>{
        private int next_idx, prev_idx;
        
        // Constructor
        public VectorListIterator(int idx){
            next_idx = idx;
            prev_idx = nElem - idx - 1;
        }
        
        @Override
        public boolean hasNext(){
            return(next_idx < nElem);
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public E next(){
            if(hasNext()){
                return (E) vec[next_idx++];
            }
            throw new NoSuchElementException("Empty");
        }
  
        @Override
        public boolean hasPrevious() {return(prev_idx >= 0);}
        
        @SuppressWarnings("unchecked")
        @Override
        public E previous(){
            if (hasPrevious()) {
                return (E) vec[prev_idx--];
            }
            throw new NoSuchElementException("Vazio");
        
        }

        @Override
        public int nextIndex() {return next_idx + 1;}

        @Override
        public int previousIndex() {return prev_idx + 1;}

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void set(E arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void add(E arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
   
