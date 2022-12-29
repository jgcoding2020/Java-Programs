/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cloneable;

/**
 * class Eraser implements tool
 * precondition none
 * post condition none
 * @author jgard
 */
public class Eraser implements Tool {
    
    // variable holds name of tool type
    private String name;
    
    /**
     * Eraser constructor sets name of tool object
     * precondition none
     * post condition name = "eraser"
     */
    public Eraser(){
        name = "eraser";
    }
    
    /**
     * method getName returns tool object name
     * precondition name =  "eraser"
     * post condition = none
     * @return
     */
    @Override
    public String getName(){
        
        return name;
    }
    
    /**
     * use method displays tool being used
     * precondition name = "eraser"
     * post condition none
     */
    @Override
    public void use(){
        
        System.out.println("Using " + this.getName());
    }
    
    /**
     * clone method creates Eraser super clone
     * precondition none
     * post condition none
     * @return
     */
    @Override
    public Object clone(){
        
        Eraser eraserObject = null;
        
        try {
            eraserObject = (Eraser) super.clone();
        }
        
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        return eraserObject;
    }
}
