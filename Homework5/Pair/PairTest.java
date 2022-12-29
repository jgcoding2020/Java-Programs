/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pair;

import java.io.*;

/**
 *
 * @author jgard
 */
public class PairTest {
    
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException{
        
        //creates object key value pair p
        Pair<Integer, String> p = new Pair<>( 1, "one");
        
        //displays key value pair values for k and v of p
        System.out.println("The following is the key value pair of p.");
        System.out.println("k = " + p.k() + " v = " + p.v());
        
        //displays equality of pair p key and value 
        System.out.println("Is the key value pair p equal?");
        System.out.println(p.equals());
        
        //display the equality of pair p key and value hash codes
        System.out.println("Are pair p key and value hash codes equal?  yes = 1, no = 0");
        System.out.println(p.hashCode());
        
        //display the pair p key and value in a string
        System.out.println(p.toString());
        
        //clone original to second pair object p2
        Pair<Integer, String> p2 = (Pair<Integer, String>)p.clone();
        
        //display p and p2 object comparison
        System.out.println("Are p and clone of p (p2) equal?");
        System.out.println(p.equals(p2));
        
        //serialize p object to file
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Pair.dat"));
        out.writeObject(p);
        out.close();
        
        //deserialize p object from file into object p3 to compare with p
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Pair.dat"));
        Pair<Integer, String> p3 = (Pair<Integer, String>) in.readObject();
        in.close();
        
        //display p and p3 object comparison
        System.out.println("The following is the key value pair of p and p3.");
        System.out.println(p.toString() + " for p.");
        System.out.println(p3.toString() + " for p3.");
        System.out.println("Are p and deserialized p (p3) equal based on the Pair class method equals()?");
        if (p.equals() == p3.equals())
            System.out.println("True");
        else
            System.out.println("false");
        
        System.out.println("Are p and deserialized p (p3) equal based on the Object class method equals()?");
        System.out.println(p.equals(p3));
    }
}
