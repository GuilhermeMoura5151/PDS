/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11_1;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author brunop
 */
public class BubbleSort implements StrategySort {
    
    @Override
    public List<Telemovel> sort(List<Telemovel> telemovel, 
            Comparator<Telemovel> comparator) {
        for (int i = 0; i < telemovel.size() - 1; i++) {
            for (int j = i + 1; j < telemovel.size(); j++) {
                if (comparator.compare(telemovel.get(i), 
                        telemovel.get(j)) > 0) {
                    Telemovel tmp = telemovel.get(i);
                    telemovel.set(i, telemovel.get(j));
                    telemovel.set(j, tmp);
                }
            }
        }
        return telemovel;
    }
    
}
