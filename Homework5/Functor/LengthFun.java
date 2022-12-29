/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functor;

/**
 * class LengthFun implements Functor interface
 * @author jgard
 */
public class LengthFun implements Functor<Integer, String>{
    
    /**
     * apply method takes String argument and returns its length
     * precondition none
     * post condition none
     * @param param
     * @return
     */
    @Override
    public Integer apply(String param){
        return param.length();
    }
    
    /**
     * main method demonstrates use of LengthFun class and Functor interface
     * @param args
     */
    public static void main(String[] args){
        LengthFun fun = new LengthFun();
        System.out.println("The length of the String is " + fun.apply("hello"));
        //Functor<R, T> base = (T)-> {return T.length();}
        
        Functor<Integer, String> moreFun = (str) -> {
            System.out.println("The length of the String is " + str.length());
            return str.length();
        };
        
        moreFun.apply("hello");
    }
}
