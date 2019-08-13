/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *

 * @author guilherme
 */

public class JGaloEngine implements JGaloInterface {
    
    private char [][] board;
    private char actualPlayer;
    private int nPlays;
    private static final int total_plays = 9;
    private char winner;
    
    public JGaloEngine(char initialPlayer){
        
        if(initialPlayer!='X' && initialPlayer!='x' && initialPlayer!='O' && initialPlayer!='o'){
            throw new IllegalArgumentException("Jogador Invalido");
        }
        actualPlayer=Character.toUpperCase(initialPlayer);
        changePlayer();
        board = new char[3][3];
        nPlays=0;
    
    }

    @Override
    public char getActualPlayer() { // muda o jogador e retorna o jogador actual
        changePlayer();
        nPlays++;
        
        return actualPlayer;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setJogada(int lin, int col) {
        
        lin--;
        col--;
        if(lin>board.length-1 || lin<0 || col>board[lin].length || col<0 || board[lin][col]!=0)return false;
        
        board[lin][col]=actualPlayer;
        
        return true;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFinished() {
        
        if(searchWinner()){
            winner=actualPlayer;
            return true;}
        else{
            if(nPlays==total_plays){
                winner=' ';
                return true;
            }
        }
        
        return false;
        
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char checkResult() {
        return winner;
        //To change body of generated methods, choose Tools | Templates.
    }

    private void changePlayer() {
        if(actualPlayer=='X'){
            actualPlayer='O';}
        else{actualPlayer='X';}
    //To change body of generated methods, choose Tools | Templates.
    }

    private boolean searchWinner() { // Verficiar se a jogada resulta na jogada vencedora, na vertical/horizontal/diagonal
        
        String diagonalRight = "";
        String diagonalLeft = "";
        String horizontal = "";
        String vertical = "";
        
        for(int col=0;col<board[0].length;col++){
            
            for(int lin=0;lin<board.length;lin++){
                vertical+=board[lin][col];
                horizontal= new String(board[lin]);
                if(checkWin(horizontal))return true;
            }
            
            diagonalRight+=board[col][col];
            diagonalLeft+=board[col][(board.length-1)-col];
            if(checkWin(vertical))return true;
        }
        if(checkWin(diagonalLeft)||checkWin(diagonalRight))return true;
        
        return false;
        }
        

    private boolean checkWin(String seq) {
    
    if(seq.equals("XXX")||seq.equals("OOO"))
        return true;
          
    return false;
    //To change body of generated methods, choose Tools | Templates.
     }

    
}
