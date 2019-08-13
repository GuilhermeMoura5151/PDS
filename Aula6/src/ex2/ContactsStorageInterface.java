/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.util.List;

/**
 *
 * @author brunop
 */
public interface ContactsStorageInterface {
    
    public List<Contact> loadContacts();
    public boolean saveContacts(List<Contact> list);
}
