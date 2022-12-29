/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Queue;

import java.util.*;

/**
 *
 * @author jgard
 */
public interface MyQueue <E> {
    E head();
    E dequeue();
    void enqueue(E e);
    int size();
    boolean isEmpty();
    void addAll(Collection <? extends E> c);
}

