/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

import java.util.*;

/**
 * LQueue class linked list adapter implements MyQueue
 * @author jgard
 * @param <E>
 */
public class LQueue <E> implements MyQueue <E>{
    
    LinkedList <E> list;
    
    /**
     * LQueue constructor creates new linked list when object is created
     * precondition none
     * post condition none
     */
    public LQueue(){
        list = new LinkedList();
    }
    
    /**
     * return the top of the queue element or throw NoSuchElementException if empty
     * precondition list == null || list == LinkedList
     * post condition none
     * @return
     */
    @Override
    public E head() {
        
        if (list.peekFirst() == null){
            System.out.println("There is no such element ");
            return list.peekFirst();
        }
        else
            return list.peekFirst();
    };

    /**
     * remove and return the top of the queue element or throw NoSuchElementException if empty
     * precondition list == null || list == LinkedList
     * post condition list.size() = list.size() - 1 
     * @return
     */
    @Override
    public E dequeue(){
        
        if (list.peekFirst() == null){
            System.out.println("There is no such element ");
            return list.peekFirst();
        }
        else
            return list.removeFirst();
    };

    /**
     * add an element to the queue
     * precondition list == null || list == LinkedList
     * post condition list.size() == list.size() + 1
     * @param e
     */
    @Override
    public void enqueue(E e){
        this.list.add(e);
    };

    /**
     * returns the size of the queue
     * precondition list == null || list == LinkedList
     * post condition none
     * @return
     */
    @Override
    public int size(){
        return list.size();
    };

    /**
     * returns true if the queue is empty
     * precondition list == null || list == LinkedList
     * post condition none
     * @return
     */
    @Override
    public boolean isEmpty(){
        
        if (this.list == null)
            return true;
        else
            return false;
    };

    /**
     * add elements to this queue from a collection c of E references:
     * precondition list == LinkedList && c == Collection
     * post condition list == list + Collection
     * @param c
     */
    @Override
    public void addAll(Collection <? extends E> c){
        list.addAll(c);
    };
}
