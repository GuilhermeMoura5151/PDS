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
public class SelectSort implements StrategySort{
    
    @Override
    public List<Telemovel> sort(List<Telemovel> telemovel, 
            Comparator<Telemovel> comparator) {
        for (int i = 0; i < telemovel.size(); i++) {
            int index = i;
            for (int j = i + 1; j < telemovel.size(); j++) {
                if (comparator.compare(telemovel.get(j), 
                        telemovel.get(index)) < 0) {
                    index = j;
                }
            }
            Telemovel tmp = telemovel.get(index);
            telemovel.set(index, telemovel.get(i));
            telemovel.set(i, tmp);
        }
        return telemovel;
    }
    
}
