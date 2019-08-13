/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

/**
 *
 * @author guilherme
 */
public class Main {
    
    public static void main(String[] args) {
        Person person = new Person.Builder("Moura", "Guilherme", "Paulo", false).streetAddress("Avenida Sacramento").build();
        System.out.println(person.toString());
    }
    
}
