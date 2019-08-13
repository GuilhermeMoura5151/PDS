/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilherme
 */
public class Leilao implements LeilaoInterface {
    
    private Cliente bestOffer;
    private Gestor referee;
    private double currentBet;
    private Produto sale;
    private List<Produto> vendas;
    
    public Leilao(Gestor referee, Produto sale){
        this.referee=referee;
        this.sale=sale;
        vendas=new ArrayList<>();
        checkProductState();
    }
    
    public void checkProductState(){
        if(Produto.state != ProdutoState.LEILAO)
            throw new IllegalStateException("Estado do produto invalido.");
    }

    @Override
    public void startLeilao(Gestor gestor) {
        System.out.println("Inicio do Leilao!!!");
        System.out.println("Para hoje temos: ");
        System.out.println("\t"+sale.toString());
    }

    @Override
    public void receiveBet(Cliente cliente, double bet) {
        if(sale.getActualPrice()>=bet)
            System.out.println("Valor inferior/igual 'a aposta actual!");
        else{
            sale.updatePrice(bet);
            bestOffer=cliente;
            System.out.println("Preco Actualizado! - "+bestOffer);
            System.out.println(sale.toString());
        }
    }

    @Override
    public void closeBet(Gestor gestor) {
        System.out.println("E vai uma! E vao duas! Fim do leilao!!!");
        System.out.println("Leilao ganho por: " + bestOffer +"!!");
        System.out.println("Produto vendido por: "+sale.getActualPrice());
    }
    
    
    
}
