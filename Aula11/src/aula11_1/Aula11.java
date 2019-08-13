/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11_1;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author brunop
 */
public class Aula11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Revista rev = new Revista("Revista de Telemoveis");
        List<Telemovel> telemoveis = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            telemoveis.add(Telemovel.buildRandomCellPhone());
        }
        System.out.println(telemoveis);
        
        rev.setRevista(telemoveis);
        System.out.println(rev.toString());
        System.out.println("Telemoveis com InsertSort");
        System.out.println(rev.getpreco(new InsertSort()));

        System.out.println("Telemoveis SelectSort");
        System.out.println(rev.getprocessador(new SelectSort()));

        System.out.println("Telemoveis com BubbleSort");
        System.out.println(rev.getmemoria(new BubbleSort()));
    }
}
    

