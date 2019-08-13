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
public class Gestor {
    
    private String name;
    private List<Produto> stockProduto;
    
    public Gestor(String name){
        this.name=name;
        stockProduto = new ArrayList<>();
    }
    
    public void addProductList(Produto p){
        
        if(p.getState()==ProdutoState.STOCK)
            stockProduto.add(p);
    }
    
}
