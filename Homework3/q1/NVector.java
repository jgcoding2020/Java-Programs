/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1;

import java.util.*;
/**
 * NVector class creates objects with a double array vector state 
 * @author jgard
 */
public class NVector 
{
    //variable double array object state
    private double[] v;
    
    /**
     * constructor with int input argument
     * @param n
     * @precondition none
     * @postcondition none
     */
    public NVector(int n)
    {
       v = new double[n];
       
       for (int i = 0; i < n; i++)
       {
           v[i] = 0;
       }
    }
    
    /**
     * constructor with NVector object instance input argument
     * @param other
     * @precondition none
     * @postcondition none
     */
    public NVector(NVector other)
    {
        this.v = other.v;
    }
    
    /**
     * constructor with variable double input argument
     * @param v
     * @precondition none
     * @postcondition none
     */
    public NVector(double... v)
    {
        this.v = v;
    }
    
    /**
     * NVector class method that returns number of indexes in object array state
     * @return
     * @precondition none
     * @postcondition none
     */
    public int length()
    {
        return v.length;
    }
    
    /**
     * NVector class method returns array index determined by int input argument
     * @param i
     * @return
     * @precondition this.length() > 0 && i < this.length() && i >= 0
     * @postcondition
     */
    public double get(int i)
    {
        try 
        {
          return v[i];   
        }
        catch (Exception e)
        {
            System.out.println("The array index you have chosen is out of bounds:");
        }
        return 0.0;
    }
    
    /**
     * NVector class method that compares equality of 2 NVector object instances, returns true/false
     * @param other
     * @return 
     * @precondition none
     * @postcondition none
     */
    public boolean equals(NVector other)
    {
        return (this == other);
    }
    
    /**
     * NVector class method that modifies index i of array with double x, returns modified array
     * @param i
     * @param x
     * @return
     * @precondition this.length() > 0 && i < this.length() && i >= 0
     * @postcondition none
     */
    public NVector set(int i, double x)
    {
        if (i > -1 && i < this.length())
        {
            v[i] = x;
            return this;
        }
        else 
        {
            throw new ArrayIndexOutOfBoundsException("The index you have chosen is out of bounds.");   
        }
    }
    
    /**
     * NVector class method adds the sum of 2 NVector object instances, returns the sum
     * @param other
     * @return
     * @precondition this.length() == other.length()
     * @postcondition none
     */
    public double add(NVector other)
    {
        double thisVectorSum = 0;
        double otherVectorSum = 0;
        
        int thisVectorLength = v.length;
        int otherVectorLength = other.v.length;
        int i = 0;
        
        if (thisVectorLength == otherVectorLength)
        {
            while (i < thisVectorLength)
            {
                thisVectorSum += v[i];
                i++;
            }
        
            i = 0;
        
            while (i < otherVectorLength)
            {
                otherVectorSum += other.v[i];
                i++;
            }
            return thisVectorSum + otherVectorSum;
        }
        else
        {
            System.out.println("The arrays can only be added if they have the same dimensions.");
            return 0;
        }
    }
    
    /**
     * NVector class method which returns the scalar product of 2 NVector object instances
     * @param other
     * @return
     * @precondition this.length() == other.length()
     * @postcondition none
     */
    public double sprod(NVector other)
    {
        if (this.v.length == other.v.length)
        {
            double sprod = 0;
            
            for (int i = 0; i < this.v.length; i++)
            {
                sprod += this.v[i] * other.v[i];
            }
            return sprod;
        }
        else
        {
            System.out.println("The scalar product can only be taken if the arrays have the same dimensions.");
            return 0;
        }
    }
    
    /**
     * NVector class method which returns the object instance array as type String
     * @return
     * @precondition none
     * @postcondition none
     */
    public String toString()
    {
        return Arrays.toString(v);
    }
    
    /**
     * main method tests class methods/ functionality
     * @param args
     * @precondition none
     * @postcondition none
     */
    public static void main(String[] args)
    {
        //testing overloading constructor with (int i) argument
        NVector array1Object = new NVector(4);
        //testing (int i) argument object with initialization to 0 utilizing toString() display
        System.out.println("array1Object vector state has been initialized to all 0's and displayed using toString() method:");
        System.out.println(array1Object.toString());
        
        //testing overloading constructor with (double... v)
        NVector array2Object = new NVector(2, 3, 5, 6);
        System.out.println("array2Object vector state has been initialized through (double... v ) argument:");
        System.out.println(array2Object.toString());
        
        //testing overloading constructor with argument (NVector other) copies other state to this state
        NVector array3Object = new NVector(array2Object);
        System.out.println("array3Object has copied the state of array2Object by means of constructor (NVector other):");
        System.out.println(array3Object);
        
        //testing class length() method
        System.out.println("array1Object vector state length is:");
        System.out.println(array1Object.length());
        
        //testing class get() method
        System.out.println("The 3rd element of array3Object is:");
        System.out.println(array3Object.get(2));
        
        //testing class equals() method
        System.out.println("Checking if array1Object == array2Object");
        System.out.println(array1Object.equals(array2Object));
        
        //tesing class set() method
        System.out.println("Setting value of index 1 of array1Object to 7.2:");
        array1Object.set(1, 7.2);
        System.out.println(array1Object.toString());
        
        //testing class add() method
        System.out.println("The array2Object vector has been added to array3Object vector:");
        System.out.println(array2Object.toString() + " + " + array3Object.toString() + " = ");
        System.out.println(array2Object.add(array3Object));
        
        //testing class sprod() method
        System.out.println("Calculating the scalar product of array1Object vector and array2Object vector:");
        System.out.println(array1Object.toString() + " * " + array2Object.toString() + " = ");
        System.out.println(array1Object.sprod(array2Object));
    }
}
