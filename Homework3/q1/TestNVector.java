/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1;

import java.util.Arrays;

/**
 *
 * @author jgard
 */
public class TestNVector {
    //variable double array object state
    private double v[];
    
    public TestNVector(double... v)
    {
        this.v = v;
    }
    
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
    
    public boolean equals(TestNVector other)
    {
        return (this == other);
    }
    
    public double add(TestNVector other)
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
    
    public double sprod(TestNVector other)
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
    
     public String toString()
    {
        return Arrays.toString(v);
    }
}
