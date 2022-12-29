/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingcart.cop4331_shoppingcart;

/**
 * Interface that helps create new user types, Customer or Seller
 * @author Group 12
 */
public interface User {
    
    void SetName(String val);

    void SetPassword(String val);

    void SetUsername(String val);
    
    String GetName();

    String GetPassword();

    String GetUsername();
    
    ProductCollect<Product> ProdList();

    void Add(Product val);

    void Remove(Product val);

    int num();
}