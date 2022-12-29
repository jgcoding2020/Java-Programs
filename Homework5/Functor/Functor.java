/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Functor;

/**
 * Functor interface encapsulates apply method
 * @author jgard
 * @param <R>
 * @param <T>
 */
public interface Functor<R, T> {

    /**
     * apply method 
     * @param param
     * @return
     */
    public R apply(T param);
}

