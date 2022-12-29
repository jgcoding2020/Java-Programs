/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1;

import java.util.Scanner;

/**
 *
 * @author jgard
 */

//Fib object with params F(0) and F(1)
public class Fib {
    
    // instance variables store F(0) and F(1):
    private int f0;
    private int f1;

    /**
     * constructor
     * @param f0
     * @param f1
     */
    public Fib(int f0, int f1){
        f0 = 1;
        f1 = 1;
    }
    
  
    

    /**
     * ***iterative*** algorithm to compute Fibonacci number
     * checks parameter and throw exception if n < 0.
     * @param n
     * @return
     */
    public int f(int n){
        
        f0 = f1 = 1;
        
        if(n < 0)
            throw new IllegalArgumentException("n should be greater than or equal to 0");
        if(n == 0){
            return (f0 - 1);
        }
        if(n == 1){
            return f1;
        }
        if(n == 2){
            return (f0 + f1);
        }
        
        int fib1 = f0, fib2 = f1, fibonacci = 1;
        for(int i = 2; i <= n; i++){
           
            //fibonacci number = sum of previous two fibonacci numbers
            fibonacci = fib1 + fib2;             
            fib1 = fib2;
            fib2 = fibonacci;
          
        }
        return fibonacci; //fibonacci number
    }

    /**
     * computes F(n) using the ***recursive*** algorithm, where F(n) = F(n-1) + F(n-2) is the recursive definition.
     * check parameter and throw exception if n < 0. Don't worry about arithmetic overflow.
     * @param n
     * @return
     */
    public int fRec(int n){
        
        f0 = f1 = 1;
        
        if(n < 0)
            throw new IllegalArgumentException("n should be greater than or equal to 0");
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
      
        int fib1 = f0, fib2 = (f0 + f1);
        return fRec(n - fib1) + fRec(n - fib2); //rear recursion
    }
    
    /**
     * Main
     * @param args
     */
    public static void main(String[] args){
        //input to print fibonacci series number
        System.out.println("Enter Fibonacci series number to print: ");
        int number = new Scanner(System.in).nextInt();
      
        System.out.println("Iterative method: Fibonacci series number " + number +" is: ");
        //printing fibonacci number
        
        Fib FibTest = new Fib(1, 1); 
        
        System.out.print(FibTest.f(number) + " "); 
        
        System.out.println("\nRecursive method: Fibonacci series number " + number +" is: ");
        //printing fibonacci number
        
        System.out.print(FibTest.fRec(number) + " ");
    }
};
