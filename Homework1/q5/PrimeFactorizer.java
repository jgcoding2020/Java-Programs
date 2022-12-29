/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q5;

import java.util.ArrayList;

/**
 * class
 * PrimeFactorizer class
 * @author jgard
 */
public class PrimeFactorizer {
    
  private int n;
  /** 
   * constructor
   * Initialize the object with target number n. 
   * @param num
   */
  public PrimeFactorizer(int num) {
      n = num;
  } 
  
  /**
   * member method
   * Return n, the target number.
   * @return 
   */
  public int getN() {
      return n;
  }
  
  /**
   * member method 
   * Computes factorization
   */
  public void compute() {
      
        int temp = n; // store original value of object n
        ArrayList<Integer> primes = new ArrayList<Integer>(); // creates primes array list
        ArrayList<Integer> exponents = new ArrayList<Integer>(); // creates exponents array list
        int count = 0; // create prime power counter variable
        
        //condition where n = 1
        if (n == 1){
            System.out.println("1");
            primes.add(1);
            exponents.add(1);
        }
        
        // displays quantity of 2s that divide n
        while (n % 2 == 0) {
            count++;
            System.out.print(2 + " ");
            n /= 2;
        }
        
        if (count > 0){
            primes.add(2); // add prime to array list
            exponents.add(count); // add power to exponent list
        }
        
        count = 0; // reset power count to 0
        int prime = 0; // initialize prime number variable
        int key = 0; // key is variable for prime comparison
       
        // n is odd skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            
            // While i divides n, print i and divide n
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
                key = i; // sets key to i for comparison to prime
                
                // evaluates whether key is a new prime to add to list
                if (prime != key){
                    prime = key;
                    primes.add(prime);
                    count = 0;
                }
                // increments power count
                if (prime == key)
                    count++;
            }
            // adds power to exponent list before reseting to 0 in inner while loop
            if (count > 0)
                exponents.add(count);
        }
 
        // condition where n is a prime number greater than 2
        if (n > 2) {
            System.out.print(n);
            primes.add(n);
            exponents.add(1);
        }
        
        n = temp; // returns n to original state
        getFactorsAndExponents(temp, primes, exponents); // function call
  }
  
  /**
   * member method 
   * Return the factors and exponents in two array lists.
   * @param n
   * @param primes
   * @param exponents
   */
  public void getFactorsAndExponents(int n, ArrayList<Integer> primes, ArrayList<Integer> exponents) {
      System.out.println("\nThe prime factors and their powers have been split into two array lists:");
      System.out.println("primes: " + primes + " exponents: " + exponents);
  }
  
  
  /**
   * member method
   * Returns a string with the "pretty" representation of the prime factorization.
   */
  public String toString() {
      
        int temp = n; // store original value of object n
        ArrayList<Integer> primes = new ArrayList<Integer>(); // creates primes array list
        ArrayList<Integer> exponents = new ArrayList<Integer>(); // creates exponents array list
        int count = 0; // create prime power counter variable
        
        // displays quantity of 2s that divide n
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }
        
        if (count > 0){
            primes.add(2); // add prime to array list
            exponents.add(count); // add power to exponent list
        }
        
        count = 0; // reset power count to 0
        int prime = 0; // initialize prime number variable
        int key = 0; // key is variable for prime comparison
       
        // n is odd skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            
            // While i divides n, print i and divide n
            while (n % i == 0) {
                n /= i;
                key = i; // sets key to i for comparison to prime
                
                // evaluates whether key is a new prime to add to list
                if (prime != key){
                    prime = key;
                    primes.add(prime);
                    count = 0;
                }
                // increments power count
                if (prime == key)
                    count++;
            }
            // adds power to exponent list before reseting to 0 in inner while loop
            if (count > 0)
                exponents.add(count);
        }
 
        // condition where n is a prime number greater than 2
        if (n > 2) {
            primes.add(n);
            exponents.add(1);
        }
        
        n = temp; // returns n to original state
        
        System.out.print("The prime factorization of " + n + " = ");
        for (int i = 0; i < primes.size(); i++){
            System.out.print(primes.get(i) + "^");
            System.out.print(exponents.get(i));
            
            if (i < primes.size() - 1){
                System.out.print(" * ");
            }
        }
        return "";
  }
}
