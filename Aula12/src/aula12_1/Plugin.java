/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula12_1;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author guilherme
 */

abstract class PluginManager 
{
	public static IPlugin load(String name) throws Exception 
	{
		Class<?> c = Class.forName(name);
		return (IPlugin) c.newInstance();
	}
}

public class Plugin {
    
    public static void main(String[] args) throws Exception{
        
        File proxyList = new File("src/aula12_1/Plugins");
        ArrayList<IPlugin> plgs = new ArrayList<IPlugin>();
        
        for(String f: proxyList.list()){
            System.out.println(f);
            try{
                
                plgs.add(PluginManager.load("aula12_1.Plugins." + f.substring(0,f.lastIndexOf('.'))));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        Iterator<IPlugin> it = plgs.iterator();
        while(it.hasNext()){
            it.next().fazQualquerCoisa();
        }
    }
    
}
