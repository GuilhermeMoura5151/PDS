/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.List;
        
/**
 *
 * @author brunop
 * Class Street
 */
public class Street {
    
    // Map with a gives a door (integer) to a list of families
    
    private Map<Integer, Set<Family>> doorMap = new  TreeMap<>();
    
    // List of persons and families that live in the street
    
    private Set<Person> personList = new TreeSet<Person>();
    private Set<Family> familyList = new HashSet<Family>();

    private int highestNumber = 0;
    
    /* Adds a family to the family list
    * Receives a family as @param to add it to the lis
    */
    
    public void addFamily(Family f) {familyList.add(f);}
    
    /* Adds a family from the family list into a doornumber
    * Receives x as the position wich the family is added
    * Receives a family to be added
    */
    
    public void famToList(int x, Family f) {
	if(!doorMap.containsKey(x)) {doorMap.put(x, new HashSet<>());}
	doorMap.get(x).add(f);
    }
    
    /*Adds a member to the list
    * Receives the name of the member and x1, x2 for the range
    */
    
    public void addPerson(String name, int x1, int x2) {
	this.personList.add(new Person(name, x1, x2));
    }
    
    /* Removes a person from a family
    * Receives the name of the person as @param
    */
    
    public void removeFromFamily(String name) {
	Person newPerson = new Person(name,0,0);
	for(Family f : familyList) {
            if(f.findPerson(newPerson)); {f.removePerson(newPerson);}
	}
    }
    
    /* Searches for a family
    * If it's not in the list, it creates one
    * Receives x1 and x2 as @param for placing the family
    * in a position in the list
    * Returns the family
    */
    
    public Family findFamily(int x1, int x2) {
        Family newFamily = new Family(x1, x2);
        for(Family f : familyList) {
            if(f.equals(newFamily)) return f;
        }
        if(highestNumber < x2)highestNumber = x2;
        return newFamily;
    }
    
    // Lists every person Alphabetically
    
    public void listPeople() {
	for(Person p : personList) {
	String ptt = p.toString() + " ";
	for(int i = p.getX1() ; i <= p.getX2(); i++) ptt += i + " ";
        System.out.println(ptt);
	}
    }
    
    // Looks up a person
    
    public void lookupPerson(String name) {
	for(Family f : familyList) {
            if(f.findPerson(new Person(name,0,0))) {
		System.out.println(f.getX1() + " " + 
                        f.getX2() + " : " + f.toString());
		return;
		}
            }
	System.out.println("Not found");
    }
    
    // The map of the street
    
    public void showMap() {
        String ptt = "";
        for(int i = 1; i <= highestNumber; i++) {
            ptt += i + " : ";
            if(doorMap.containsKey(i)) {
                List<Family> famList = doorMap.get(i).stream()
                    .sorted(Comparator.comparing((Family::getRange))
                    .reversed())
                    .collect(Collectors.toList());
            Iterator<Family> it = famList.iterator();
            if(it.hasNext()) ptt +=it.next();
            while(it.hasNext()) ptt += " : " + it.next();
                        
            }

            ptt += "\n";
        }
        System.out.println(ptt);
    }
    
    // Map clearing
    
    public void clear() {
        doorMap = new TreeMap<>();
        familyList = new HashSet<Family>();
        personList = new TreeSet<Person>();
        highestNumber = 0;
    }
    
    
}
