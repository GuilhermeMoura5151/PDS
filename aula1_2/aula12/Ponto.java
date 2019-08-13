/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author guilherme
 */
public class Ponto{
    
    String word;
    private int x;
    private int y;
    private Directions direction;

    public Ponto(int x, int y, String word, Directions direction) {
            this.x = x;
            this.y = y;
            this.word=word;
            this.direction=direction;
    }

    public int getX() {
            return x;
    }

    public void setX(int x) {
            this.x = x;
    }

    public int getY() {
            return y;
    }

    public void setY(int y) {
            this.y = y;
    }
        
    public Directions getDirection(){
        return direction;
    }
    
    public void setDirection(Directions direction){
        this.direction=direction;
    }
}
