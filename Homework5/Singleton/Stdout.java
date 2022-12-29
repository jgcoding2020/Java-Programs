/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

/**
 * Stdout singleton class 
 * @author jgard
 */
public class Stdout {
    
    //single object instance variable set to null
    private static Stdout instance = null;
    
    //Stdout private constructor
    private Stdout(){
    }
   
    /**
     * if Stdout variable instance equals null creates new Stdout else returns instance variable
     * precondition instance == null || instance = new Stdout
     * post condition instance == new Stdout
     * @return
     */
    public static Stdout getInstance(){
        if (instance == null){
            instance = new Stdout();
        }
        return instance;
    }
    
    /**
     * displays string s input argument
     * precondition instance == Stdout
     * post condition none
     * @param s
     */
    public void printline(String s){
        System.out.println(s);
    }
}
