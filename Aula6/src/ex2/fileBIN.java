/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brunop
 */
public class fileBIN implements ContactsStorageInterface {
    
    private String file = "contacts.bin";
    
    // Contact Loader
    public List<Contact> loadContacts() {
        List<Contact> list = new ArrayList<>();
        try {
            FileInputStream file1 = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(file1));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                Contact contact1 = new Contact(parts[0], 
                        Integer.parseInt(parts[1]), parts[2]);
                list.add(contact1);
            }
            file1.close();
        } catch (Exception x) {
            System.err.println("ERROR!" + x);
        }
        return list;
    }
    
    //Contact Saver
    public boolean saveContacts(List<Contact> list) {
        // TODO Auto-generated method stub
        boolean saving = false;
        try {
            FileOutputStream file1 = new FileOutputStream(file);
            for (Contact lista : list) {
                String v = String.format("%s\t%d\t%s\n", lista.getName(), lista.getTelNumber(), lista.getAddress());
                file1.write(v.getBytes());
            }
            file1.close();
            saving = true;
        } catch (Exception x) {
            System.err.println("ERROR!" + x);
        }
        return saving;

    }
    
}
