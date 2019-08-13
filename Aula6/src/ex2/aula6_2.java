/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;
import java.util.Scanner;

/**
 *
 * @author brunop
 */
public class aula6_2 {

    public static void main(String[] args) {
        ContactsInterface contact = new ContactsStore();
        Scanner potato = new Scanner(System.in);
        System.out.println("Inser your name, telnumber and "
                + "location in this format: name,telnumber,location: ");
        System.out.println("Insert quit for quit: ");
        while (true) {
            String ipt = potato.nextLine();
            if (ipt != "quit") {
                String[] contact1 = ipt.split(",");
                String nome = contact1[0];
                int numero = Integer.parseInt(contact1[1]);
                String endereco = contact1[2];
                Contact cont = new Contact(nome, numero, endereco);
                contact.add(cont);
                
                ContactsStorageInterface file1 = new fileTXT();
                contact.saveAndClose(file1);
                contact.openAndLoad(file1);
                
                ContactsStorageInterface file2 = new fileCSV();
                contact.saveAndClose(file2);
                contact.openAndLoad(file2);
                
                ContactsStorageInterface file3 = new fileBIN();
                contact.saveAndClose(file3);
                contact.openAndLoad(file3);
            }
            if (ipt == "quit") {
                break;
            }
        }

    }
    
}
