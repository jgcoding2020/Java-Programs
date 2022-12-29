/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoppingcart.cop4331_shoppingcart;

/**
 * Product interface that helps create new product types
 *
 * @author Group 12
 */
public interface ProductBase {

    public void SetName(String val);
    
    public void SetDescription(String val);
    
    public void SetInventory(int val);

    public void SetPrice(double val);
    
    public void SetCost(double val);
    
    public String Getname();
     
    public String GetDescription();
    
    public int GetInventory();

    public double GetPrice();

    public double GetCost();

   
}