/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functor;

/**
 * class Summer implements Functor2 interface
 * @author jgard
 */
public class Summer implements Functor2<Integer, Integer, Integer> {
    
    /**
     * apply() method takes 2 integer parameters and returns their sum
     * precondition none
     * post condition none
     * @param x
     * @param y
     * @return
     */
    @Override
    public Integer apply(Integer x, Integer y){
        return x + y;
    }
}
