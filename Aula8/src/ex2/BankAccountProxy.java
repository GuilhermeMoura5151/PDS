/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import ex1.*;
import ex1_2.*;

/**
 *
 * @author brunop
 */
public class BankAccountProxy extends BankAccountImpl {
    public BankAccountProxy(String bank, double initialDeposit){
        super(bank,initialDeposit);
    }

    @Override
    public boolean withdraw(double amount){
        if(ex1.Company.user == ex1.User.OWNER)
            return super.withdraw(amount);
        else
            throw new UnsupportedOperationException("Company não tem acesso a contas de employees");
    }
    
    @Override
    public double balance(){
        if(ex1.Company.user==ex1.User.OWNER)
            return super.balance();
        else
            throw new UnsupportedOperationException("Company não tem acesso a contas de employees");
    }
    
    
}
