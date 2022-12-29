/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingcart.cop4331_shoppingcart;

import java.util.*;
import java.io.Serializable;


/**
 * Collection Type object that adapts a LinkedList, implements ProdList
 * Adapter pattern, Iterator pattern
 * @author Group 12
 * @param <E>
 */
public class ProductCollect<E> implements ProductListBase<E>, Iterable<E>, Serializable {

    private final LinkedList<E> list;

    /**
     * Class constructor
     * precondition none
     * post condition list = LinkedList<E>;
     */
    public ProductCollect(){
        list = new LinkedList();
    }
    
    /**
     * Removes element from list
     * precondition list = LinkedList<E>;
     * post condition list.size() -= 1;
     * @param e
     */
    @Override
    public void remove(E e) {
        list.remove(e);
    }

    /**
     * Returns list element i 
     * precondition list = LinkedList<E>;
     * post condition none
     * @param i
     * @return
     */
    @Override
    public E getItem( int i) {
       return  list.get(i);
    }

    /**
     * Returns list int number of elements
     * precondition list = LinkedList<E>;
     * post condition none
     * @return
     */
    @Override
    public int size() {
        return list.size();
     }

    /**
     * Returns true if list is empty false otherwise
     * precondition list = LinkedList<E>;
     * post condition none
     * @return
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Adds e to list LinkedList<E>
     * precondition list = LinkedList<E>;
     * post condition none
     * @param e
     */
    @Override
    public void add(E e) {
        list.add(e);
    }

    /**
     * Returns list iterator
     * Iterator pattern
     * precondition list = LinkedList<E>;
     * post condition none
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }    
    
    /**
     * Adds entire LinkedList argument to list
     * precondition list = LinkedList<E>;
     * post condition list = c;
     * @param c
     */
    @Override
    public void addAll(Collection<? extends E> c) {
        for (E temp : c){
            list.add(temp);
        }
    }

    /**
     * Removes all elements from list
     * precondition list = LinkedList<E>
     * post condition list.IsEmpty();
     */
    @Override
    public void removeAll() {
        list.clear();
    }
}