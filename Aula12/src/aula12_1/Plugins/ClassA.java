/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula12_1.Plugins;

import aula12_1.IPlugin;

/**
 *
 * @author guilherme
 */
public class ClassA implements IPlugin{

    @Override
    public void fazQualquerCoisa() {
        System.out.println("Guilherme");
    }
    
}
