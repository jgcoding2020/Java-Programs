/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functor;

/**
 * SummerTest class has main() method
 * @author jgard
 */
public class SummerTest {
    
    /**
     * main() method demonstrates use of Functor2 interface and Summer class
     * @param args
     */
    public static void main(String[] args){
        //creates Summer Object
        Summer day = new Summer();
        //creates MyList object and adds elements
        MyList<Integer> lst = new MyList<>();
        lst.add(3);
        lst.add(-1);
        lst.add(1);
        lst.add(4);
        //displays lst elements added through reduce() method
        System.out.println("Summer Functor2 = " + lst.reduce(day, 0));
        
        //instantiates functor2 with Summer apply() method body
        Functor2<Integer, Integer, Integer> day2 = (param1, param2) -> {
            return param1 + param2;
        };
        //displays MyList object elements cumulative sum after applying Summer instantiated
        System.out.println("instantiated lst.reduce(day2) = " + lst.reduce(day2, 0));
    }
}
