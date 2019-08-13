/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author guilherme
 */
public class Aula10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Produto jordans = new Produto("Sapatilhas Jordan 2k16",300);
        Produto cap = new Produto("Chapeu dos Limp Bizkit(Fred Durst)",550);
        
        Cliente c1 = new Cliente("Bruno Pinto");
        Cliente c2= new Cliente("Guilherme Moura");
        Cliente c3= new Cliente("Andre Ribas");
        
        Gestor g1= new Gestor("Prof. Moreira");
        
        cap.changeProductState(ProdutoState.LEILAO);
        Leilao l1= new Leilao(g1,cap);
        
        l1.startLeilao(g1);
        l1.receiveBet(c3, 600);
        l1.receiveBet(c1, 590);
        l1.closeBet(g1);
    }
    
}
