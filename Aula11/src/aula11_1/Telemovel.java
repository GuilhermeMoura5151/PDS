/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11_1;

import java.util.Random;

/**
 *
 * @author brunop
 */
public class Telemovel {
    
    private double memoria;
    private double preco;
    private double processador;
    private double camera;
    
    // Cosntructors
    public Telemovel(double memoria, double preco, 
            double processador, double camera) {
        this.memoria = memoria;
        this.preco = preco;
        this.processador = processador;
        this.camera = camera;
    }
    
    public static Telemovel buildRandomCellPhone() {
        return new Telemovel(getRandomNumber(), getRandomNumber(),
                getRandomNumber(), getRandomNumber());
    }

    // Getter & Setter
    
    public static double getRandomNumber() {
        Random r = new Random();
        return (50 + (700 - 50) * r.nextDouble());
    }

    public double getMemoria() {
        return memoria;
    }

    public void setMemoria(double memoria) {
        this.memoria = memoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getProcessador() {
        return processador;
    }

    public void setProcessador(double processador) {
        this.processador = processador;
    }

    public double getCamera() {
        return camera;
    }

    public void setCamera(double camera) {
        this.camera = camera;
    }
    
    // Methods
    @Override
    public String toString() {
        return "Telemovel{" + "memoria=" + memoria + ", preco=" + preco + 
                ", processador=" + processador + ", camera=" + camera + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.memoria) ^
                (Double.doubleToLongBits(this.memoria) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.preco) ^
                (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.processador) ^
                (Double.doubleToLongBits(this.processador) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.camera) ^ 
                (Double.doubleToLongBits(this.camera) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telemovel other = (Telemovel) obj;
        if (Double.doubleToLongBits(this.memoria) != 
                Double.doubleToLongBits(other.memoria)) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != 
                Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (Double.doubleToLongBits(this.processador) != 
                Double.doubleToLongBits(other.processador)) {
            return false;
        }
        if (Double.doubleToLongBits(this.camera) != 
                Double.doubleToLongBits(other.camera)) {
            return false;
        }
        return true;
    }
    
}
