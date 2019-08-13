/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.List;

/**
 *
 * @author guilherme
 */
public class Aula6 {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Inserir Empregados em Registos:");
        //Empregados
        Empregado e1 = new Empregado("guilherme","moura",1,1000);
        Empregado e2 = new Empregado("bruno","pinto",1,1000);
        //Inserir na base de dados registo
        Registos r=new Registos();
        r.insere(e1);
        r.insere(e2);
        
        //Imprimir
        List<Empregado> listE=r.listaDeEmpregados();
        
        for(int i=0;i<listE.size();i++)
            System.out.println("Empregado: "+listE.get(i).toString());
        
        r.remove(1);
        
        System.out.println("\nInserir Empregados na Database:");
        
        Database d = new Database();
        Employee d1=new Employee("bruno",1,1500);
        Employee d2=new Employee("guilherme",2,1600);
        
        d.addEmployee(d1);
        d.addEmployee(d2);
        
        Employee[] empList=d.getAllEmployees();
        
        for(int i=0;i<empList.length;i++)
            System.out.println("Empregado: "+empList[i].toString());
        
        d.deleteEmployee(1);
        
        System.out.println("\nInserir Empregados com NewDatabase(Adaptador):");
        
        NewDatabase nd = new NewDatabase();
        nd.setLegacyDatabase(r);
        
        nd.addEmployee(d1);
        nd.addEmployee(d2);
        
        Employee[] empListND=nd.getAllEmployees();
        for(int i=0;i<empListND.length;i++)
            System.out.println("Empregado: "+empListND[i].toString());
        
       
        
        
        
    }
    
}
