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
public interface EstadoLivro {
    
    public void registar(Livro livro);
    public void requisitar(Livro livro);
    public void reservar(Livro livro);
    public void cancelaReserva(Livro livro);
    public void devolver(Livro livro);
    
}
