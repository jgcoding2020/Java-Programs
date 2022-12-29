/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingcart.cop4331_shoppingcart;

import java.io.Serializable;

/**
 * A User object type that implements User interface and is responsible for
 * Customer account
 *
 * @author Group 12
 */
public class Customer implements User, Serializable {

    private String name;
    private String username;
    private String password;
    private int arrayNum;
    private final ProductCollect<Product> prod;
    
    /**
     * Constructor class, initialize all values to zero
     * precondition none
     * post condition arrayNum = 0; prod = ProductCollect<Product>;
     */
    public Customer() {
        this.arrayNum = 0;
        this.prod = new ProductCollect();
    }
    
    /**
     * Sets name
     * precondition name = "";
     * post condition name = val;
     * @param val String to set name too
     */
    @Override
    public void SetName(String val) {
        this.name = val;
    }

    /**
     * Sets password
     * precondition password = "";
     * post condition password = val;
     * @param val String to set password to
     */
    @Override
    public void SetPassword(String val) {
        this.password = val;
    }

    /**
     * Sets Username
     * precondition username = "";
     * post condition username = val;
     * @param val String to set username too
     */
    @Override
    public void SetUsername(String val) {
        this.username = val;
    }

    /**
     * Gets name of product
     * precondition name = val;
     * post condition none
     * @return String of name
     */
    @Override
    public String GetName() {

        return this.name;
    }

    /**
     * Gets password of user
     * precondition password = val;
     * post condition none
     * @return String of password
     */
    @Override
    public String GetPassword() {
        return this.password;
    }

    /**
     * Gets Username of user
     * precondition username = val;
     * post condition none
     * @return String of username
     */
    @Override
    public String GetUsername() {
        return this.username;
    }
    
    /**
     * returns the list of of products
     * precondition prod = ProductCollect<Product>;
     * post condition none
     * @return PDList of products
     */
    @Override
    public ProductCollect<Product> ProdList() {
        return (ProductCollect<Product>) this.prod;
    }

    /**
     * Add product to product
     * precondition prod = ProductCollect<Product>;
     * post condition arrayNum += 1;
     * @param val product you want to add
     */
    @Override
    public void Add(Product val) {
        this.prod.add(val);
        this.arrayNum++;
    }

    /**
     * Remove Product
     * precondition prod = ProductCollect<Product>;
     * post condition arrayNum -= 1;
     * @param val Product you wish to remove
     */
    @Override
    public void Remove(Product val) {
        this.prod.remove(val);
        this.arrayNum--;
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