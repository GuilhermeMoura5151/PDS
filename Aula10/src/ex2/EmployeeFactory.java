/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author brunop
 */
public class EmployeeFactory {
    public static final String[] names = { "Mac", "Linux", "Win" };
	
	public static Employee getCustomer(String name) {
	
            for (int i = 0; i < names.length; i++) {
                    if (names[i].equalsIgnoreCase(name)) {
                            return new Programmer(name);
                    }
            }
            return EmployeeNull.getInstance();
	}
    
}
