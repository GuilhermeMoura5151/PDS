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
public class Produto {
    
    private int productCode = 1;
    private String descricao;
    private double preco;
    public static ProdutoState state = ProdutoState.STOCK;
    
    public Produto(String descricao, double precoBase){
        this.descricao=descricao;
        this.preco=precoBase;
        productCode++;
    }
    
    public ProdutoState getState(){
        return state;
    }
    
    public double getActualPrice(){
        return preco;
    }
    
    public void updatePrice(double bet){
        preco=bet;
    }
    
    public void changeProductState(ProdutoState change){
        state=change;
    }
    
    @Override
    public String toString(){
        return "Produto: Code:"+productCode+", "+(descricao != null ? "Descricao:" + descricao + ", " : "")
                + "Preco:" + preco + "]";
    }
    
}
