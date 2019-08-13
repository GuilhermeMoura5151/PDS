/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex9_1;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author brunop
 */
public class Aula9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        VectorGeneric<Integer> test = new VectorGeneric<>();
        for (int i = 0; i <= 25; i++) {
            test.addElem(i);
        }
        
         for (Iterator<Integer> test1 = test.iterator(); test1.hasNext();) {
            System.out.println("Test1: Iterator: " + test1.next());
        }

        for (ListIterator<Integer> test2 = test.listIterator(0); test2.hasNext();) {
            System.out.println("Test2: ListIterator next:" + test2.next());
        }

        for (ListIterator<Integer> test3 = test.listIterator(5); test3.hasPrevious();) {
            System.out.println("Test3: ListIterator previous:" + test3.previous());
        }
    }
    
}
