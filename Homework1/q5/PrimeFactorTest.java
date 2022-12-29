/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q5;

import java.util.Scanner;

import java.util.ArrayList;

/**
 * test class PrimeFactorTest with a main() function that reads an int number n
 * from the terminal with the Scanner object, computes its prime factorization with a
 * PrimeFactorizer object, and then displays the factorization
 * to the terminal with System.out.println().
 * @author jgard
 */
public class PrimeFactorTest {
    
    /**
     * main method
     */
    public static void main(String[] args){
        
        // variable to store user number choice
        int myNumber;
        // variable for do while condition
        boolean success;
        
        // loop deterimes if chosen number is within appropriate range or try again
        do {
        Scanner myObj = new Scanner(System.in);  // creates a Scanner object
        System.out.println("Enter number:");
        
        int numberChoice = myObj.nextInt();  // Read user input
        success = rangeTest(numberChoice);
        myNumber = numberChoice;
        } while (success == false);
        
        System.out.println("The number chosen to Prime Factorize is: \n" + myNumber);  // Output user input
        
        PrimeFactorizer numToCalc = new PrimeFactorizer(myNumber); // create object with number chosen
        
        System.out.println("The following numbers multiply to produce n besides 1:");
        numToCalc.compute();// displays numbers multiplied without powers
        
        numToCalc.toString();// function call displays factorization as string presentation
    }
    
    /**
     * rangeTest method
     * checks user's chosen integer to ensure it is > 0
     * @param choice
     * @return
     */
    public static boolean rangeTest(int choice){
        if (choice > 0)
            return true;
        else {
            System.out.println("Try again, lease choose a number greater than 0.");
            return false;
        }
    }
  
}
