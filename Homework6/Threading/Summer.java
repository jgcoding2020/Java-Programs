/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threading;

import java.util.*;

/**
 * Summer class implements Runnable
 * @author jgard
 */
public class Summer implements Runnable{
    
    private double start, finish, partialSum;
    private int total;
    
    /**
     * Summer constructor
     * @param aStart
     * @param aFinish
     */
    public Summer(int aStart, int aFinish){
        start = aStart;
        finish = aFinish;
        total = 0;
        partialSum = 0;
    }
    
    /**
     * method run
     * precondition none
     * post condition none
     */
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }
    
    /**
     * method sum adds k intervals
     * precondition none
     * post condition total += i
     * @param n
     * @param k
     * @return
     */
    public int sum(double n, double k){
        
        for (double i = start; i <= finish; i++){
            total += i;
        }
        
        return total;
    }
    
    /**
     * method partalSum
     * precondition none
     * post condition partialSum += j
     * @param n
     * @param k
     * @return
     */
    public double partialSum(double n, double k){
        
        for (double j = start; j <= finish; j++){
            partialSum += j;
        }
        return partialSum;
    }
    
    /**
     * main method creates threads and adds sums
     * @param args
     */
    public static void main(String[] args){
        // int variables for summer objects
        int n = 5;
        int k = 5;
        int j = 0;
        // Summer object threads
        Summer thread_1 = new Summer(0, n/k);
        Summer thread_2 = new Summer(n/k+1, 2*n/k);
        Summer thread_3 = new Summer(2*n/k+1, 3*n/k);
        Summer thread_4 = new Summer((k-1)*n/k, n);
        Summer thread_5 = new Summer(j*n/k, (j+1)*n/k);
        // adds thread interval sums together and displays them
        double threadSum = thread_1.sum(n, k)+thread_2.sum(n, k)+thread_3.sum(n, k)+thread_4.sum(n, k)+thread_5.partialSum(n, k);
        System.out.println((int)threadSum);
        // tests threads sum against n*(n+1)/2
        int sumTest = n*(n+1)/2;
        System.out.println(sumTest);
    }
}
