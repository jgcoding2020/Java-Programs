/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingcart.cop4331_shoppingcart;

import java.io.Serializable;

/**
 * A User object type that implements User interface and is responsible for Seller account
 * @author Group 12
 */
public class Seller implements User, Serializable {

    private String name;
    private String username;
    private String password;
    private int arrayNum;
    private double revenue;
    private double profit;
    private final ProductCollect<Product> prod;
    
    /**
     * Class constructor
     * precondition none
     * post condition arrayNum = 0; revenue = 0; profit = 0; 
     */
    public Seller() {
        arrayNum = 0;
        revenue = 0;
        profit = 0;
        prod = new ProductCollect();
    }
    
    /**
     * Sets name
     * precondition name = "";
     * post condition name = val;
     * @param val String to set name too
     */
    @Override
    public void SetName(String val) {
        name = val;
    }

    /**
     * Sets password
     * precondition password = "";
     * post condition password = val;
     * @param val String to set password to
     */
    @Override
    public void SetPassword(String val) {
        password = val;

    }

    /**
     * Sets Username
     * precondition username = "";
     * post condition username = val;
     * @param val String to set username too
     */
    @Override
    public void SetUsername(String val) {
        username = val;
    }
    
    /**
     * precondition revenue = 0.00;
     * post condition revenue = val;
     * @param val
     */
    public void SetRevenue (double val) {
        revenue = val;
    }
    
    /**
     * precondition profit = 0.00;
     * post condition profit = val;
     * @param val
     */
    public void SetProfit (double val) {
        profit = val;
    }
    
    /**
     * Gets name
     * precondition name = val;
     * post condition none
     * @return String of name
     */
    @Override
    public String GetName() {

        return name;
    }

    /**
     * Gets password
     * precondition password = val;
     * post condition none
     * @return String of password
     */
    @Override
    public String GetPassword() {
        return password;
    }

    /**
     * Gets Username
     * precondition username = val;
     * post condition none
     * @return String of username
     */
    @Override
    public String GetUsername() {
        return username;
    }
    
    /**
     * Gets revenue
     * precondition revenue = val;
     * postcondition none
     * @return
     */
    public double GetRevenue() {
        return revenue;
    }
    
    /**
     * Gets profit
     * precondition profit = val;
     * post condition none
     * @return
     */
    public double GetProfit() {
        return profit;
    }
    
    /**
     * returns the list of of products
     * precondition prod = ProductCollect<Product>
     * post condition none
     * @return PDList of products
     */
    @Override
    public ProductCollect<Product> ProdList() {
        return (ProductCollect<Product>) prod;
    }

    /**
     * Add product to product list
     * precondition prod = ProductCollect<Product>; arrayNum >= 0;
     * post condition arrayNum += 1;
     * @param val product you want to add
     */
    @Override
    public void Add(Product val) {
        prod.add(val);
        arrayNum++;
    }

    /**
     * Remove Product
     * precondition prod = ProductCollect<Product>; arrayNum >= 0;
     * post condition arrayNum -= 1;
     * @param val Product you wish to remove
     */
    @Override
    public void Remove(Product val) {
        prod.remove(val);
        arrayNum--;
    }

    /**
     * returns the number of total products
     * precondition arrayNum >= 0;
     * post condition none
     * @return int of total products
     */
    @Override
    public int num() {
        return arrayNum;
    }
}
