/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author brunop
 */
public class fileTXT implements ContactsStorageInterface {
    
    private  String file = "contacts.txt";
    
    // Contact Loader
    public List<Contact> loadContacts(){
        
        List<Contact> list = new ArrayList<>();
        Scanner potato = null;
        try{
            File file1 = new File(file);
            potato = new Scanner(new FileInputStream(file1));
            while(potato.hasNextLine()){
                String[] part = potato.nextLine().split("\t");
                Contact contact1 = new Contact(part[0],
                        Integer.parseInt(part[1]), part[2]);
                list.add(contact1);
                
            }
        }
        catch (Exception x){
            System.err.println("Error!!" + x);
        }
        potato.close();
        
        return list;
    }
    
    // Contact Saver
    public boolean saveContacts(List<Contact> list){
        boolean saving = false;
        try{
            File file1 = new File(file);
            PrintWriter potato = new PrintWriter(file1);
            for(Contact y : list){
                potato.printf("%s\t%d\t%s", y.getName(), y.getTelNumber(),
                        y.getAddress());
                potato.println();
            }
            potato.close();
            saving = true;
        }
        catch(Exception x){
            System.err.println("ERROR!" + x);
        }
        
        return saving;
        
    }
    
}
