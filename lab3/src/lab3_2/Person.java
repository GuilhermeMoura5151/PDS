/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Objects;

/**
 *
 * @author brunop
 * Class Person
 */
public class Person implements Comparable<Person>{
    
    // Persons Name
    
    private String name;
    
    // First and second position of the interval of the 
    // range of doors that a family can be
    
    private int x1;
    private int x2;
    
    // Constructor of a new Person
    
    public Person(String name, int x1, int x2){
        this.name = name;
        this.x1 = x1;
        this.x2 = x2;
    }
    
    //  Getters of x1 and x2
    
    public int getX1(){return x1;}
    public int getX2(){return x2;}
    
    // ToString
    
    @Override
    public String toString(){return this.name;}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

   /* 
   * For the Alphabetic order method
   */
   
    @Override
   public int compareTo(Person p) {
        return this.name.toLowerCase().compareTo(p.name.toLowerCase());
   }
}
