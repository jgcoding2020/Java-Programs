/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cloneable;

import java.util.*;

/**
 * class ToolList implements ToolBox interface and stores Tools in an ArrayList
 * precondition none
 * post condition tools = ArrayList
 * @author jgard
 */
public class ToolList implements ToolBox {
    
    //Tool object ArrayList
    private ArrayList<Tool> tools = new ArrayList<>();
    
    /**
     * add method adds Tool object to tools  
     * precondition tools = ArrayList
     * post condition tools.size += tools.size + 1
     * @param tool
     */
    @Override
    public void add(Tool tool){
        tools.add(tool);
    }
    
    /**
     * get method returns tool if it exists in the tools ArrayList
     * precondition tools = ArrayList
     * post condition none
     * @param toolName
     * @return
     */
    @Override
    public Tool get(String toolName){
        
        for (int i = 0; i < tools.size(); i++){
            
            if (tools.get(i).getName() == toolName)
                return tools.get(i);
        }
        
        System.out.println("There no such element " + toolName);
        System.exit(0);
        return tools.get(0);
    }
}
