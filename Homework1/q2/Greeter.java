/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2;

/**
 * Greeter Class
 * @author jgard
 */
public class Greeter {
    
    private String name;
    
    /**
     * Greeter class constructor
     * @param aName
     */
    public Greeter(String aName) {
        name = aName;
    }
    
    /**
     * member function
     * displays Hello + the object instance name!
     */
    public void SayHello() {
        System.out.println("Hello " + name + "!");
    }
    
    /**
     * member function that swaps names of 2 objects
     * @param other
     */
    public void swapNames(Greeter other) {
        String temp = other.name;
        other.name = this.name;
        this.name = temp;
    }
    
    /**
     * member function that accesses class private variable
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * member function that concatenates this object and input argument object
     * @param qualifier
     * @return
     */
    public Greeter createQualifiedGreeter(String qualifier) {
        return new Greeter(this.name + " " + qualifier);
    }
};
