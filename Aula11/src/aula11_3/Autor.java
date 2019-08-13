/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11_3;

import aula11_1.*;

/**
 *
 * @author guilherme
 */
public class Autor {
    
    private String nome;
     public Autor(String nome){
         nome=this.nome;
     }
     
    @Override
    public String toString(){
        return "Autor [Nome=]" + nome + "]";
    }
    
}
