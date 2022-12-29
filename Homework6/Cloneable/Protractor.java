/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cloneable;

/**
 * Protractor class implements Tool
 * @author jgard
 */
public class Protractor implements Tool{
    
    private String name;
    
    /**
     * Protractor constructor
     * precondition none
     * post condition none
     */
    public Protractor(){
        name = "protractor";
    }
    
    /**
     * getName method returns name
     * precondition name = "protractor"
     * post condition none
     * @return
     */
    @Override
    public String getName(){
        
        return name;
    }
    
    /**
     * use method displays tool name
     * precondition name = "protractor"
     * post condition none
     */
    @Override
    public void use(){
        
        System.out.println("Using " + this.getName());
    }
    
    /**
     * clone method creates Protractor super clone 
     * @return
     */
    @Override
    public Object clone(){
        
        Protractor protractorObject = null;
        
        try {
            protractorObject = (Protractor) super.clone();
        }
        
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        return protractorObject;
    }
}
