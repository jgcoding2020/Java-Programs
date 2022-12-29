/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pair;

import java .io.*;

/**
 * key pair value class
 * @author jgard
 * @param <K>
 * @param <V>
 */
public class Pair<K,V> implements Cloneable, Serializable {
    
    private final K k;
    private final V v;
    
    /**
     * Pair class constructor
     * @param k
     * @param v
     */
    public Pair(K k, V v){
        this.k = k;
        this.v = v;
    }
    
    /**
     * returns k value
     * precondition k = Integer
     * post condition none
     * @return
     */
    public K k(){
        return k;
    }
    
    /**
     * returns v value
     * precondition k = String
     * post condition none
     * @return
     */
    public V v(){
        return v;
    }
    
    /**
     * returns equality of k and v
     * precondition k = Integer && v = String
     * post condition none
     * @return
     */
    public boolean equals(){
       return k.equals(v);
    }
    
    /**
     * compares the hash codes of k and v and returns the result
     * precondition k = Integer && v = String
     * post condition none
     * @return
     */
    @Override
    public int hashCode(){
        Integer hash1 = k.hashCode();
        Integer hash2 = v.hashCode();
        if (hash1.equals(hash2))
            return 1;
        else 
            return 0;
    }
    
    /**
     * returns k and v values in String form
     * precondition k = Integer && v = String
     * post condition none
     * @return
     */
    @Override
    public String toString(){
        return ("The key value pair is: k = " + k + " v = " + v);
    }
    
    /**
     * clones this object
     * precondition p = Pair && p2 = Pair
     * post condition p2 is clone of p
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}