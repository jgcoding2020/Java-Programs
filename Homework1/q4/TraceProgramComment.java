/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q4;

/**
 * Trace program to determine value of x
 * @author jgard
 */
public class TraceProgramComment {
    
    public int x;

    /**
     * answer to program x value trace
     */
    public TraceProgramComment(){
        
        // answer since it's a runtime exception x = 4 then finally x++ increments to 5
        x = 5; 
    }
}
    /*int x = 0;
    try {
	Greeter g1 = new Greeter("Alice");
	Greeter g2 = new Greeter("Alice");
		
	if (g1.sayHello() != g2.sayHello()) {
		g2 = null;
	}
	x = 1;
	System.out.println(g2.sayHello());
	x = 2;
    } catch (NullPointerException ex) {
	x = 10;
    } catch (RuntimeException ex) {
	x = 4;
    } finally {
    	x++;
    }*/
