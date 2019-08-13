/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author brunop
 */
public class CodeFilter extends ReaderDecorator{
    
    Scanner sc = new Scanner(System.in);
    private MessageDigest converter;
    
    public CodeFilter(Reader read){
        super(read);
        sc=new Scanner("");
    }
    
    @Override
    public boolean hasNext(){
        if(!sc.hasNext())
            return read.hasNext();
        else
            return true;
    }
    
    @Override
    public String next(){
        String out = new String();
        try{
            converter=MessageDigest.getInstance("SHA-256");
        }
        catch(NoSuchAlgorithmException e){
            System.err.println("Error ciphering word.");
        }
        
        if(!sc.hasNext()){
            sc=new Scanner(read.next());
            byte[] data= converter.digest(sc.next().getBytes());
            out=convertDigest(data);
        }
        else{
            byte[] data= converter.digest(sc.next().getBytes());
            out=convertDigest(data);
        }
        return out;
    }

    private String convertDigest(byte[] data) {
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;1<data.length;i++)
            sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        
        return sb.toString();
        }
    }

    

