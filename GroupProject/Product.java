/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingcart.cop4331_shoppingcart;

import java.io.Serializable;

/**
 * Default product type that, implements ProductBase
 * @author Group 12
 */
public class Product implements ProductBase, Serializable {

    private String name;
    private String description;
    private int inventory;
    private double price;
    private double cost;

    /**
     * Class constructor
     * precondition none
     * post condition name = null; description = null; inventory = 0; price = 0; cost = 0;
     */
    public Product() {
        name = null;
        description = null;
        inventory = 0;
        price = 0;
        cost = 0;
    }

    /**
     * Sets the name
     * precondition name = null;
     * post condition name = val;
     * @param val String that becomes the name
     */
    @Override
    public void SetName(String val) {
        name = val;
    }

    /**
     * Sets the Description
     * precondition description = null;
     * post condition description = val;
     * @param val String the becomes the description
     */
    @Override
    public void SetDescription(String val) {
        description = val;
    }
    
    /**
     * Sets the inventory
     * precondition inventory = 0;
     * post condition inventory = val;
     * @param val Int that becomes the inventory
     */
    @Override
    public void SetInventory(int val) {
        inventory = val;
    }
    
    /**
     * Sets the price
     * precondition price = 0;
     * post condition price = val;
     * @param val double that becomes the price
     */
    @Override
    public void SetPrice(double val) {
        price = val;
    }
    
    /**
     * Sets cost
     * precondition cost = 0;
     * post condition cost = val;
     * @param val
     */
    @Override
    public void SetCost(double val) {
        cost = val;
    }

    /**
     * Gets the name
     * precondition name = val;
     * post condition none
     * @return String of items name
     */
    @Override
    public String Getname() {
        return name;
    }
    
    /**
     * Gets the description
     * precondition description = val;
     * post condition none
     * @return String of the items description
     */
    @Override
    public String GetDescription() {
        return description;
    }
    
    /**
     * Gets inventory
     * precondition inventory = val;
     * post condition none
     * @return int of the item inventory
     */
    @Override
    public int GetInventory() {
        return inventory;
    }
    
    /**
     * Gets the price
     * precondition price = val;
     * post condition none
     * @return double of the items price price
     */
    @Override
    public double GetPrice() {
        return price;
    }
    
    /**
     * Gets cost
     * precondition cost = val;
     * post condition none
     * @return
     */
    @Override
    public double GetCost() {
        return cost;
    }
    
    /**
     * returns copy of the product
     * precondition name = val; description = val; inventory = val; price = val; cost = val;
     * @return Product type that is a copy of itself
     */
    public Product Getcopy() {
        Product n = new Product();
        n.SetPrice(price);
        n.SetDescription(description);
        n.SetName(name);
        n.SetInventory(inventory);
        n.SetCost(cost);

        return n;
    }
}