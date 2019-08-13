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
public class Disponivel implements EstadoLivro{
    
    @Override
    public void registar(Livro livro){
           
    }

    @Override
    public void requisitar(Livro livro) {
        livro.setEstado(new Emprestimo());
    }

    @Override
    public void reservar(Livro livro) {
        livro.setEstado(new Reserva());
    }

    @Override
    public void cancelaReserva(Livro livro) {
       
    }

    @Override
    public void devolver(Livro livro) {
        
    }

    @Override
    public String toString(){
        return "[DISPONIVEL]";
    }
}
