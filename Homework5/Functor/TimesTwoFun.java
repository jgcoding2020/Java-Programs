/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functor;

/**
 * class TimesTwoFun implements Functor interface
 * @author jgard
 */
public class TimesTwoFun implements Functor<Integer, Integer>{
    
    /**
     * TwoTimesFun constructor
     */
    public TimesTwoFun(){
        
    }
    
    /**
     * apply() method multiples parameter by 2
     * @param param
     * @return
     */
    @Override
    public Integer apply(Integer param){
        return 2 * param;
    }
}
