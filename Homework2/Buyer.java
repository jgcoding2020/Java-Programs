/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shop;

import java.util.*;
/**
 * Buyer class
 * @author jgard
 */
public class Buyer {
    
    /**
     * pay method() initiates receipt from CashRegister
     * @param receipt
     */
    public void pay(CashRegister receipt){
        receipt.displayReceipt();
    }
}
