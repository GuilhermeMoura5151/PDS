/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author brunop
 * Class Family
 */
public class Family {
    
    // List with members of the family
    List<Person> personList = new ArrayList<>();
    
    // First and second position of the interval of the 
    // range of doors that a family can be
    private int x1;
    private int x2;
    
    // Range of door occupied bey the family
    private int range;
    
    // Constructor of a new family
    public Family(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
        this.range = x2 - x1; // Number of doors occupied by the family
    }
    
    //  Getters of x1,x2 and range
    public int getX1(){return x1;}
    public int getX2(){return x2;}
    public int getRange(){return range;}
    
    
    /** To check if a person is part of a family
    * Receives as @param the person you want to find
    * Returns true if the person is part of a family
    */
    
    public boolean findPerson(Person person){
        for(Person p : personList){
            if(p.equals(person)){return true;}
        }
        return false;
    }
    
    /** Creates a new person and adds it to a family
     * Receives as @param the name of the person
     * Must return a error message if the person already exists
     */
    
    public void addPerson(String name){
        Person newPerson = new Person(name,this.x1,this.x2);
        for(Person p : personList){
            if(p.equals(newPerson)){
                System.out.println("Error! The person already exists.");
            }
        }
    personList.add(newPerson);
    }
    
    /** Removes a person from the family
     * Receives as @param the person to remove
     */
    
    public void removePerson(Person p){
        Iterator<Person> itr = personList.iterator();
        while(itr.hasNext()){
            Person x = itr.next();
            if(x.equals(p)){itr.remove();}
        }
    }
    
    /** Getter of the person list
     * Returns the person list
     */
    
    public List<Person> getPersonList(){
        return personList;
    }

    // ToString
    
    @Override
    public String toString() {
        String str = "";
        for(Person p : personList){
            str += p + " ";
        }
        return str;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.personList);
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
        final Family other = (Family) obj;
        if (!Objects.equals(this.personList, other.personList)) {
            return false;
        }
        return true;
    }
}
