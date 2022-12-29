/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Cloneable;

/**
 * interface Tool
 * @author jgard
 */
public interface Tool extends Cloneable{
    
    String getName();
    void use();
    Object clone();
}
