/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shop;

import java.util.*;
/**
 * ShopTester class has main function
 * @author jgard
 */
public class ShopTester {
    
    /**
     * main function scans user input and creates objects plus calls class methods on objects
     * @param args
     */
    public static void main(String[] args){
      // creates scanner object for user input
      Scanner productUPC = new Scanner(System.in);
      System.out.println("Enter number of UPCs you will enter: ");
      // variable determines upcArray length
      int length = productUPC.nextInt();
      // creates string array for upc user inputs
      String[] upcArray = new String[length];
      System.out.println("Enter one UPC at a time from the available inventory list: 101, 102, 103, 104: ");

      // loop for user upc inputs
      for(int i = 0; i < length; i++ ) {
         upcArray[i] = productUPC.next();
      }
      
      // creates UPScanner object populated with upcs
      UPCScanner productList = new UPCScanner(upcArray, length);
      // creates Product object from UPCScanner object
      Product scannedProducts = new Product(productList.upcList, productList.upcListLength);
      // creates CashRegister object from Product object
      CashRegister displayItems = new CashRegister(scannedProducts.selectedProducts(), scannedProducts.count);
      // call to CashRegister class method to display upc products
      displayItems.displayProduct();
      // creates Cashier object and passes total price argument from cash register 
      Cashier employee = new Cashier(displayItems.total);
      // call to CashRegister method pressPayButton initiates total display
      employee.pressPayButton();
      // creates Buyer Object
      Buyer customer = new Buyer();
      // call to Buyer class method pay with argument CashRegister object to display receipt
      customer.pay(displayItems);
    }
}
