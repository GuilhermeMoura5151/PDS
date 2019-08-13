/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1_2;

import ex1.*;

/**
 *
 * @author guilherme
 */
public class BankAccountProxy extends BankAccountImpl{
    
    public BankAccountProxy(String bank, double initialDeposit){
        super(bank,initialDeposit);
    }

    @Override
    public boolean withdraw(double amount){
        if(Company.user == User.OWNER)
            return super.withdraw(amount);
        else
            throw new UnsupportedOperationException("Company não tem acesso a contas de employees");
    }
    
    @Override
    public double balance(){
        if(Company.user==User.OWNER)
            return super.balance();
        else
            throw new UnsupportedOperationException("Company não tem acesso a contas de employees");
    }
    
    
}
