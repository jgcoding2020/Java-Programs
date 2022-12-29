/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoppingcart.cop4331_shoppingcart;

import java.util.Collection;

/**
 * Interface to create a LinkedList adaptation
 * Adapter pattern
 * @author Group 12
 * @param <E>
 */
public interface ProductListBase<E> {

    void add(E e);

    void remove(E e);

    E getItem(int i);

    int size();

    boolean isEmpty();

    void removeAll();

    void addAll(Collection<? extends E> c);
}