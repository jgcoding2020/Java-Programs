/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

import java.util.*;

/**
 *
 * @author jgard
 */
public class QueueTest {
    
    public static void main(String[] args){
        
        //Creates LQueue object with linked list
        LQueue <Integer> numbers = new LQueue<>();
        //enqueues 3 elements to list indeces [0, 1, 2]
        numbers.enqueue(1);
        numbers.enqueue(2);
        numbers.enqueue(3);
        
        //displays LQueue object linked list size
        System.out.println("The length of the list is " + numbers.size());
        
        //displays entire number list as array
        System.out.println("The entire number list array is ");
        System.out.println(Arrays.deepToString(numbers.list.toArray()));
        
        //displays head of linked list
        System.out.println("The head of the list is " + numbers.head());
        
        //dequeues list from head to tail and displays new head after each dequeue
        numbers.dequeue();
        System.out.println("The head of the list after dequeue " + numbers.head());
        numbers.dequeue();
        System.out.println("The head of the list after dequeue " + numbers.head());
        numbers.dequeue();
        
        // demonstrates isEmpty() called in head() method
        System.out.println("The head of the list after dequeue " + numbers.head());
        
        //creates second linked list and re enqueues first linked list
        LinkedList <Integer> numbers2 = new LinkedList<>();
        numbers2.add(4);
        numbers2.add(5);
        numbers2.add(6);
        numbers.enqueue(1);
        numbers.enqueue(2);
        numbers.enqueue(3);
        
        //demonstrates LQueue addAll method adding linked lists together 
        numbers.addAll(numbers2);
        System.out.println("The 2 number lists added together are ");
        System.out.println(Arrays.deepToString(numbers.list.toArray()));
        
    }
}
