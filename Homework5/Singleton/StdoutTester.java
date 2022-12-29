/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

/**
 *
 * @author jgard
 */
public class StdoutTester {
    
    public static void main(String[] args){
        //creates Stdout object instance twice with two separate variables to test
        Stdout str = Stdout.getInstance();
        str.printline("Hello");
        Stdout str2 = Stdout.getInstance();
        str2.printline("World!!!");
        
        //testing 2 object variable references to varify they are the same
        System.out.println("Are str and str2 referencing the same object?");
        if (str == str2)
            System.out.println("Yes");
        else
            System.out.println("No");
        
        //testing 2 variable hash codes to see if they are the same
        System.out.println("Are str and str2 hash codes the same?");
        if(System.identityHashCode(str) == System.identityHashCode(str2)){
            System.out.println("Hash code is same.");
        }
        else
            System.out.println("Hash code is not the same.");
    } 
}
