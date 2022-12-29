/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cloneable;

/**
 * Class pencil implements Tool
 * @author jgard
 */
public class Pencil implements Tool {
    
    private String name;
    
    /**
     * Pencil constructor
     * precondition none
     * post condition name = "pencil"
     */
    public Pencil(){
        name = "pencil";
    }
    
    /**
     * getName method returns name
     * precondition name = "pencil"
     * post condition none
     * @return
     */
    @Override
    public String getName(){
        
        return name;
    }
    
    /**
     * use method displays tool being used
     * precondition name = "pencil"
     * post condition none
     */
    @Override
    public void use(){
        
        System.out.println("Using " + this.getName());
    }
    
    /**
     * clone method creates Pencil super clone
     * precondition none
     * post condition none
     * @return
     */
    @Override
    public Object clone(){
        
        Pencil pencilObject = null;
        
        try {
            pencilObject = (Pencil) super.clone();
        }
        
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        return pencilObject;
    }
}
