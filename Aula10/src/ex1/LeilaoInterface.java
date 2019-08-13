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
public interface LeilaoInterface {
    
    public void startLeilao(Gestor gestor);
    public void receiveBet(Cliente cliente, double bet);
    public void closeBet(Gestor gestor);
    
}
