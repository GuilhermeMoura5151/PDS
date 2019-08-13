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
public class Livro{
    
    private String titulo;
    private Autor autor;
    private int ISBN;
    private int ano;
    private EstadoLivro estado;
    
    public Livro(String titulo,int isbn,int ano, Autor autor){
        titulo=this.titulo;
        isbn=this.ISBN;
        ano=this.ano;
        autor=this.autor;
        estado=new Inventario();

    }

    public EstadoLivro getEstado(){
        return estado;
    }

    public void setEstado(EstadoLivro estado){
        this.estado=estado;
    }

    public Autor getAutor(){
        return autor;
    }
    
    public String getTitulo(){
        return titulo;
    }

    public int getISBN(){
        return ISBN;
    }

    public int getAno(){
        return ano;
    }

    public void registar(){
        estado.registar(this);
    }

    public void devolver(){
        estado.devolver(this);
    }

    public void requisitar(){
        estado.requisitar(this);
    }

    public void cancelaReserva(){
        estado.cancelaReserva(this);
    }
    
    public void reservar(){
        estado.reservar(this);
    }
    
    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", ISBN=" + ISBN + ", ano=" + ano + ", primeiroAutor=" + autor + ", estadoAtual=" + estado + '}';
    }

}
    

