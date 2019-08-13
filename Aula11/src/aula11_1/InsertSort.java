/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11_1;

import java.util.List;
import java.util.Comparator;

/**
 *
 * @author brunop
 */
public class InsertSort implements StrategySort {
    
    @Override
    public List<Telemovel> sort(List<Telemovel> telemovel, Comparator<Telemovel> comparator) {
        
        for (int i = 1; i < telemovel.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (comparator.compare(telemovel.get(j), telemovel.get(j - 1)) < 0) {
                    Telemovel tmp = telemovel.get(j);
                    telemovel.set(j, telemovel.get(j - 1));
                    telemovel.set(j - 1, tmp);
                }
            }
        }
        return telemovel;
    }
    
}
