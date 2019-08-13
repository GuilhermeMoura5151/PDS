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
public class Cliente {
    
    private String nome;
    
    public Cliente(String nome){
        this.nome=nome;
    }
    
    @Override
    public String toString() {
        return "Cliente: "+ nome;
    }
    
}
