/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 *
 * @author guilherme
 */
public class Aula11_3 {
    
    static Scanner sc= new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<Livro> livros = new ArrayList();

        livros.add(new Livro("Tio Patinhas fica rico!", 1234, 2000, new Autor("Disney")));
        livros.add(new Livro("Tio Patinhas fica mais rico!", 1235, 2002, new Autor("WaltDisney")));
        livros.add(new Livro("Tio Patinhas vira Joe Berardo!",1236, 2019,new Autor("Caixa Geral de Depositos")));

        while(true){
            int[] op=menu(livros);
            Livro escolha = livros.get(op[0]-1);
            try{
                switch(op[1]){
                    case 1:
                        escolha.registar();
                        break;
                    case 2:
                        escolha.requisitar();
                        break;
                    case 3:
                        escolha.reservar();
                        break;
                    case 4:
                        escolha.devolver();
                        break;
                    case 5:
                        escolha.cancelaReserva();
                        break;
                    default:
                        System.out.println("NUMERO INVALIDO");
                        System.exit(1);
                }
                } catch(IllegalStateException e){
                    System.err.println("Argumento Invalido.");
                }
            }
        }

            private static int[] menu(List<Livro> livros){

                int[] op= new int[2];
                System.out.println("Biblioteca.");
                livros.forEach(b -> System.out.printf("%d %s %s\n",b.getISBN(),b.getTitulo(),b.getEstado().toString()));
                System.out.println(">> livro <livro>, <operacao>: (1) Registar; (2) Requisitar; (3) Reservar; (4) Devolver; (5) Cancelar");
                String[] line=sc.nextLine().split(",");
                op[0]=Integer.parseInt(line[0]);
                op[1]=Integer.parseInt(line[1]);
                
                return op;
            }
    }
    
