/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shop;

import java.util.*;
/**
 *
 * @author jgard
 */
public class Cashier {

    public double total;
    
    /**
     * Cashier class constructor initializes variables
     * @param atotal
     */
    public Cashier(double atotal){
        total = atotal;
    }
    
    /**
     * pressPayButton method displays total price
     */
    public void pressPayButton(){
        System.out.println("Your total is: $" + total + "\n");
    }
}
