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
public interface StrategySort {
    public List<Telemovel> sort(List<Telemovel> telemovel, Comparator<Telemovel> comparator);
    
}
