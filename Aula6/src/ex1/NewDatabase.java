/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class NewDatabase extends Database{
    
    private Registos legacy;
    
    public NewDatabase(){
        super();
    }
    
    public void setLegacyDatabase(Registos legacy){
        this.legacy=legacy;
    }
    
    public boolean addEmployee(Employee e){
        return super.addEmployee(e);
    }
    
    public boolean addEmployee(Empregado e){
        return super.addEmployee(new Employee(e.nome()+" "+e.apelido(), (long) e.codigo(), e.salario() ));
    }
    
    public boolean deleteEmployee(long emp_num){
        super.deleteEmployee(emp_num);
        if(legacy!=null){
            legacy.remove((int) emp_num);
            return true;
        }
        return false;
    }
    
    public boolean exists(long emp_num){
        for(Employee e: super.getAllEmployees()){
            if(e.getEmpNum()==emp_num)
                return true;
        }
        
        return legacy.isEmpregado((int)emp_num);
    }
    
    @Override
    public Employee[] getAllEmployees(){
        ArrayList<Employee> total=new ArrayList<Employee>();
        
        for(Employee e:super.getAllEmployees())
            total.add(e);
        
        for(Empregado e: legacy.listaDeEmpregados())
            total.add(new Employee (e.nome()+" "+e.apelido(),(long)e.codigo(),e.salario()));
        
        Employee[] emp=new Employee[total.size()];
        return total.toArray(emp);
    }
   
}
