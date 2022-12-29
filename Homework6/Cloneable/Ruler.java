/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cloneable;

/**
 * Ruler class implements Tool
 * @author jgard
 */
public class Ruler implements Tool{
    
    private String name;
    
    /**
     * Ruler constructor
     * precondition name = "protractor"
     * post condition none
     */
    public Ruler(){
        name = "ruler";
    }
    
    /**
     * getName method returns Tool name
     * precondition name = "ruler"
     * post condition none
     * @return
     */
    @Override
    public String getName(){
        
        return name;
    }
    
    /**
     * use method displays Tool name
     * precondition name = "ruler"
     * post condition none
     */
    @Override
    public void use(){
        
        System.out.println("Using " + this.getName());
    }
    
    /**
     * clone method creates Ruler super clone
     * @return
     */
    @Override
    public Object clone(){
        
        Ruler rulerObject = null;
        
        try {
            rulerObject = (Ruler) super.clone();
        }
        
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        return rulerObject;
    }
}
