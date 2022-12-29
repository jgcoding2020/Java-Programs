/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cloneable;

/**
 * ToolTest class has main method
 * precondition none
 * post condition none
 * @author jgard
 */
public class ToolTest {
    
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) { 
        //creates tool objects
        Eraser eraser = new Eraser();
        Pencil pencil = new Pencil();
        Protractor protractor = new Protractor();
        Paper paper = new Paper();
        Ruler ruler = new Ruler();
        //creates toolbox object to store tools
        ToolList toolBox = new ToolList();
        //adds tools to toolbox object
        toolBox.add(eraser);
        toolBox.add(pencil);
        toolBox.add(protractor);
        toolBox.add(ruler);
        toolBox.add(paper);
        //gets tools from toolbox and uses tools
        System.out.println(toolBox.get("eraser"));
        eraser.use();
        System.out.println(toolBox.get("pencil"));
        pencil.use();
        System.out.println(toolBox.get("protractor"));
        protractor.use();
        System.out.println(toolBox.get("ruler"));
        ruler.use();
        System.out.println(toolBox.get("paper"));
        paper.use();
    }
}
