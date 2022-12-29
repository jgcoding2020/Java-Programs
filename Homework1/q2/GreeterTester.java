/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2;

/**
 * class holding main function with Greeter class function calls
 * @author jgard
 */
public class GreeterTester {

    /**
     * main function
     * @param args
     */
    public static void main(String[] args) {
        
        // creates 2 separate Greeter class objects and displays them
        Greeter greeting1 = new Greeter("Josh");
        Greeter greeting2 = new Greeter("Taryn");
        System.out.println("Saying Hello to object 1: ");
        greeting1.SayHello();
        System.out.println("Saying Hello to object 2: ");
        greeting2.SayHello(); 
        
        // swaps 2 greeter class object names and displays them
        greeting1.swapNames(greeting2);
        System.out.println("Saying Hello to object 1 swapped with 2: ");
        greeting1.SayHello();
        System.out.println("Saying Hello to object 2 swapped with 1: ");
        greeting2.SayHello();
        
        // concetenates 2 greeter class object names and displays them
        System.out.println("CreateQualifiedGreeter is: ");
        Greeter g = new Greeter("Fancy");
        Greeter g2 = g.createQualifiedGreeter("Pants!");
        System.out.println(g2.getName());
    }
}
