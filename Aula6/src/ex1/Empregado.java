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
public class Empregado {
    
    private String nome;
    private String apelido;
    private int codigo;
    private double salario;

    public Empregado(String nome, String apelido, int codigo, double salario) {
        this.nome = nome;
        this.apelido = apelido;
        this.codigo = codigo;
        this.salario = salario;
    }

    public String apelido() {
        return apelido;
    }

    public String nome() {
        return nome;
    }

    public int codigo() {
        return codigo;
    }

    public double salario() {
        return salario;
    }
    
     @Override
     public String toString(){
		 
		 return "Nome: " + this.nome + ", Apelido: " + this.apelido + ", Codigo: " + this.codigo + ", Salario: " + this.salario;
     }
    
}
