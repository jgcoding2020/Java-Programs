/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shop;

import java.util.*;
/**
 * CashRegister class displays product info and receipt
 * @author jgard
 */
public class CashRegister {
    // object variables
    public double total;
    public String[][] products;
    
    /**
     * CashRegister class constructor
     * @param productArray
     * @param count
     */
    public CashRegister(String[][] productArray, int count){
        total = 0;
        // double temp variable for double parse from string
        double d;
        // loop parses products string prices into double for total price sum
        for (int i = 0; i < count; i++){
            d = Double.parseDouble(productArray[i][2]);
            total += d;
        }
        products = productArray;
    }
    
    /**
     * displayProduct method displays product names, upcs, and prices
     */
    public void displayProduct(){
        for (int i = 0; i < products.length; i++){
            System.out.print("UPC: ");
            System.out.print(products[i][0] + ",");
            System.out.print(" product: ");
            System.out.print(products[i][1] + ",");
            System.out.print(" Price: $");
            System.out.print(products[i][2] + "\n");
        }
    }
    
    /**
     * displayReceipt method displays purchased product info and total price
     */
    public void displayReceipt(){
        System.out.println("The following is the receipt for your purchase: ");
        displayProduct();
        System.out.println("$" + total);
    }
}
