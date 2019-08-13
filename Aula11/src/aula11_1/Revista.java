/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 *
 * @author brunop
 */
public class Revista {
    
    private List<Telemovel> telemovel;
    private String revista;

    // Cosntructor
    
    public Revista(String revista) {
        telemovel = new ArrayList<>();
        this.revista = revista;
    }

    // Getter & Setter
    public List<Telemovel> getpreco(StrategySort strategy) {
        return strategy.sort(telemovel, new Comparator<Telemovel>() {
            @Override
            public int compare(Telemovel o1, Telemovel o2) {
                return (int) (o1.getPreco() - o2.getPreco());
            }
        });
    }

    public List<Telemovel> getmemoria(StrategySort strategy) {
        return strategy.sort(telemovel, new Comparator<Telemovel>() {
            @Override
            public int compare(Telemovel o1, Telemovel o2) {
                return (int) (o1.getMemoria() - o2.getMemoria());
            }
        });
    }

    public List<Telemovel> getprocessador(StrategySort strategy) {
        return strategy.sort(telemovel, new Comparator<Telemovel>() {
            @Override
            public int compare(Telemovel o1, Telemovel o2) {
                return (int) (o1.getProcessador() - o2.getProcessador());
            }
        });
    }

    public List<Telemovel> getcamera(StrategySort strategy) {
        return strategy.sort(telemovel, new Comparator<Telemovel>() {
            @Override
            public int compare(Telemovel o1, Telemovel o2) {
                return (int) (o1.getCamera() - o2.getCamera());
            }
        });
    }

    public void addTelemovel(Telemovel telemoveis) {
        telemovel.add(telemoveis);
    }

    void setRevista(List<Telemovel> telemoveis) {
        this.telemovel = telemovel;
    }

    
    // Methods
    @Override
    public String toString() {
        return "Revista{" + "telemovel=" + telemovel + ", revista=" + revista + '}';
    }
    
}
