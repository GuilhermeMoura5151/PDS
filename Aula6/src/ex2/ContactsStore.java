/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author brunop
 */
public class ContactsStore implements ContactsInterface {
    
    private List<Contact> list = new ArrayList<>();
    
    public void openAndLoad(ContactsStorageInterface store) {
        list = store.loadContacts();
        System.out.println(store.getClass().getSimpleName() + ":" + list);
    }
    
    public void saveAndClose() {
        // TODO Auto-generated method stub
        int rando = 1 + (int) (4 * Math.random());
        boolean store = false;
        switch (rando) {
            case 1:
                store = new fileTXT().saveContacts(list);
                break;
            case 2:
                store = new fileBIN().saveContacts(list);
                break;
            case 3:
                store = new fileCSV().saveContacts(list);
                break;
        }
         
    }
    
    public void saveAndClose(ContactsStorageInterface store) {

        if (!store.saveContacts(list)) {
            // Not implemented
        }
    }
    
    public boolean exist(Contact contact) {
        boolean carrier = false;
        for (Contact contacto : list) {
            if (contacto.getName().equals(contact.getName())) {
                carrier = true;
            }
        }
        return carrier;
    }
    
    public Contact getByName(String name) {
        // TODO Auto-generated method stub
        Contact contact = null;
        for (Contact contact1 : list) {
            if (contact1.getName().equals(name)) {
                contact = contact1;
            }
        }
        return contact;
    }
    
    public boolean add(Contact contact) {
        boolean adder = false;
        if (exist(contact) == false) {
            list.add(contact);
            adder = true;
        }
        return adder;
    }
    
    public boolean remove(Contact contact) {
        boolean remover = false;
        if (exist(contact) == true) {
            list.remove(contact);
            remover = true;
        }
        return remover;
    }
    
}
