/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Functor;

/**
 * Functor2 interface
 * @author jgard
 * @param <R>
 * @param <T1>
 * @param <T2>
 */
public interface Functor2<R, T1, T2> {
    
    /**
     * apply() method
     * @param param1
     * @param param2
     * @return
     */
    public R apply(T1 param1, T2 param2);
}
