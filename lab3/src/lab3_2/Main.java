/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author brunop
 * The main class
 */
public class Main {
    
    // Initiate the scanner
    static Scanner sc = new Scanner(System.in);
    
    // Instantiate a map
    static Street map = new Street();
    
    public static void main(String[] args) throws FileNotFoundException{
        
        // Reads a file and parses it 
        
        if (args.length > 0) {
            Scanner ptt = new Scanner(new File(args[0]));
            while (ptt.hasNextLine()) {
                String[] commandParsed = ptt.nextLine().split(" ");
                try {
                    menuParse(commandParsed);
                } catch ( ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input!");
                }
            }
            ptt.close();
        }
        
        // The menu
        // shows available commands for input

        while (true) {
            System.out.println("Available commands: Load, Map, Add, Remove, List, Lookup, Clear, Quit");
            String input = sc.nextLine().toLowerCase();
            String[] parsedInput = input.split(" ");
            try {
                menuParse(parsedInput);
            } catch ( FileNotFoundException e ) {
                    System.out.println("File was not found!");
            } catch (ArrayIndexOutOfBoundsException e  ) {
                    System.out.println("Invalid input!");
            } catch (NumberFormatException e ) {
                    System.out.println("Invalid input!");
            }

        }   
    }
    
    // The function with the method call for wich input that was got
    // from the parser array
    
    public static void menuParse(String[] parsedInput) throws FileNotFoundException {
        switch (parsedInput[0]) {
        case "load":
                loadFile(parsedInput[1]);
                System.out.println("==============================");
                break;
        case "map":
                System.out.println("==============================");
                map.showMap();
                System.out.println("==============================");
                break;
        case "add":
                generateFamily(Integer.parseInt(parsedInput[2]), Integer.parseInt(parsedInput[3]), parsedInput[1]);
                System.out.println("==============================");
                break;
        case "remove":
                map.removeFromFamily(parsedInput[1]);
                System.out.println("==============================");
                break;
        case "list":
                System.out.println("==============================");
                map.listPeople();
                System.out.println("==============================");
                break;
        case "lookup":
                System.out.println("==============================");
                map.lookupPerson(parsedInput[1]);
                System.out.println("==============================");
                break;
        case "clear":
                map.clear();
                System.out.println("==============================");
                break;
        case "quit":
                System.exit(0);
                break;
        default:
                System.out.println("Command not found");
                System.out.println("==============================");
                break;
        }
    }
    
    /* Validates a name    
    * Receives the name as @param for validation
    * The name must be unique, must contain only letters(Lower and Uppercase
    * numbers and the symbols _.@
    * The name also must start with a letter, must have a max length of 40
    * characters and must start with a letter.
    * Return true if successful
    */
    
    public static boolean validateName(String name) {
        if(!name.matches("^[A-Za-z].*[\\w_.@].*[\\w]$") || name.length() > 40) {
            return false;
        }
        return true;
    }
    
    /* Generates a family
    * Receives x1, x2 and name as @param
    */
    
    public static void generateFamily(int x1, int x2, String name) {
        if(!validateName(name)) {
            System.out.println("Invalid name!");
            return;
        }
        Family personFam = map.findFamily(x1, x2); //Returns a new family if it can't find one with the same range
        personFam.addPerson(name);
        map.addFamily(personFam);
        map.addPerson(name, x1, x2);
        for (int i = x1; i <= x2; i++) map.famToList(i, personFam);
    }
    
    /* Loads a file and creates a family using the generate Family funct
    * Receives as @param the family name
    */
    
    public static void loadFile(String fileName) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));

        
        file.nextLine();
        String[] parsedLine;
        while (file.hasNextLine()) {
            parsedLine = file.nextLine().split(" |-");
            generateFamily(Integer.parseInt(parsedLine[0]), 
                    Integer.parseInt(parsedLine[1]), parsedLine[2]);
        }
        System.out.println("Sucesso!");
    }
}
    

