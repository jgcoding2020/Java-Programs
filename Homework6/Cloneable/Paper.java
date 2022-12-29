/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cloneable;

/**
 * Paper class implements Tool
 * @author jgard
 */
public class Paper implements Tool{
    
    private String name;
    
    /**
     * Paper constructor
     * precondition none
     * post condition name = "Paper"
     */
    public Paper(){
        name = "paper";
    }
    
    /**
     * getName method returns Tool name
     * precondition name = "Paper"
     * post condition none
     * @return
     */
    @Override
    public String getName(){
        
        return name;
    }
    
    /**
     * use method displays Tool name
     * precondition name = "Paper"
     * post condition none
     */
    @Override
    public void use(){
        
        System.out.println("Using " + this.getName());
    }
    
    /**
     * clone method creates Paper super clone
     * precondition none
     * post condition none
     * @return
     */
    @Override
    public Object clone(){
        
        Paper paperObject = null;
        
        try {
            paperObject = (Paper) super.clone();
        }
        
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        return paperObject;
    }
}
