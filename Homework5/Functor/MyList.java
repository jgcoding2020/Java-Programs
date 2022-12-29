/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functor;

import java.util.*;
/**
 * MyList class extends LinkedList and adds map() method
 * @author jgard
 * @param <T>
 */
public class MyList<T> extends LinkedList<T>{
    
    /**
     * MyList constructor
     * precondition none
     * post condition MyList = LinkedList + map()
     */
    public MyList(){
        
    }
    
    /**
     * map() method applies TwoTimesFun method to populate new MyList with elements * 2
     * precondition Mylist = LinkedList
     * post condition new MyList = 2 * MyList
     * @param <R>
     * @param fo
     * @return
     */
    public <R> MyList<R> map(Functor<R,T> fo) {
        // write here the code for the map() function.
        MyList<R> myList = new MyList<>();
        
        for (Object value: this){
            myList.add(fo.apply((T) value));
        }
        
        return myList; 
    }
    
    public T reduce(Functor2<T,T,T> fo2, T initialValue) {
        // write code here
        for (T i: this){
            initialValue = fo2.apply(initialValue, i);
        }
        
        return initialValue;
     }
    
    /**
     * MyList main() method demonstrates use of classes MyList and TwoTimesFun
     * @param args
     */
    public static void main(String[] args){
        //creates TwoTimesFun object
        TimesTwoFun tt = new TimesTwoFun();
        //creates MyList object and adds integers to list
        MyList<Integer> lst = new MyList<>();
        lst.add(-2);
        lst.add(1);
        lst.add(0);
        lst.add(4);
        //displays MyList object elements
        System.out.println("lst = " + lst);
        //displays MyList object elements after applying TwoTimesFun
        System.out.println("lst.map(tt) = " + lst.map(tt));
        //instantiates functor with TwoTimesFun apply() method body
        Functor<Integer, Integer> tt2 = (param) -> {
            return 2 * param;
        };
        //displays MyList object elements after applying TwoTimesFun instantiated
        System.out.println("lst.map(tt2) = " + lst.map(tt2));
    }
}
