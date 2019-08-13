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
public class Person {
    
    private final String lastName;
    private final String firstName;
    private final String midleName;
    private final String salutation;
    private final String suffix;
    private final String streetAddress;
    private final String city;
    private final String state;
    private final boolean isFemale;
    private final boolean isEmployed;
    private final boolean isHomeOwner;
    
    //Construtor privado
    private Person(Builder builder){
        
        lastName = builder.lastName;
        firstName = builder.firstName;
        midleName = builder.midleName;
        salutation = builder.salutation;
        suffix = builder.suffix;
        streetAddress = builder.streetAddress;
        city = builder.city;
        state = builder.state;
        isFemale = builder.isEmployed;
        isHomeOwner = builder.isHomewOwner;
        isEmployed = builder.isEmployed;
    }
    
    public static class Builder{
        
        // Atributos
        private final String lastName;
        private final String firstName;
        private final String midleName;
        private final boolean isFemale;
        private String salutation;
        private String suffix;
        private String streetAddress;
        private String city;
        private String state;
        private boolean isEmployed;
        private boolean isHomewOwner;
        
        public Builder(String lastName, String firstName, String midleName, boolean isFemale){
            this.lastName=lastName;
            this.firstName=firstName;
            this.midleName=midleName;
            this.isFemale=isFemale;
        }
        
        public Builder salutation(String salutation){
            this.salutation=salutation;
            return this;
        }
        
        public Builder suffix(String suffix){
            this.suffix=suffix;
            return this;
        }
        
        public Builder streetAddress(String streetAddress){
            this.streetAddress=streetAddress;
            return this;
        }
        
        public Builder state(String state){
            this.state=state;
            return this;
        }
        
        public Builder employed(boolean isEmployed){
            this.isEmployed=isEmployed;
            return this;
        }
        
        public Builder isHomeOwner(boolean isHomeOwner){
            this.isHomewOwner=isHomeOwner;
             return this;
        }
        
        public Person build(){
            return new Person(this);
        }
        
    }
    
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return midleName;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public boolean isHomeOwner() {
        return isHomeOwner;
    }
    
    @Override
    public String toString() {
        return "Person{" + "lastName=" + lastName + ", firstName=" + firstName + ", middleName=" + midleName + ", salutation=" + salutation + ", suffix=" + suffix + ", streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ", isFemale=" + isFemale + ", isEmployed=" + isEmployed + ", isHomewOwner=" + isHomeOwner + '}';
    }
    
}
