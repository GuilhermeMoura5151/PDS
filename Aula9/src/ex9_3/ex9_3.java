/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex9_3;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author guilherme
 */
public class ex9_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<String> commands = new ArrayList<>();
        commands.add("create");
        commands.add("recover");
        commands.add("refresh");
        commands.add("create");
        commands.add("delete");
        commands.add("refresh");
        commands.add("delete");

        List<String> elems = new ArrayList<>();
        elems.add("1");
        elems.add("2");
        elems.add("3");
        elems.add("4");
        elems.add("5");
        elems.add("6");
        elems.add("7");
        elems.add("8");
        elems.add("9");
        elems.add("0");
        
        Chain chain = new Create(new Recover(new Refresh(new Delete())));
        for (String txt : commands) {
            chain.useCommand(txt, elems);
        }
        System.out.println("Elementos atualizados: " + elems);
    }
 }
    
