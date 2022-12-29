/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functor;

import java.util.*;
/**
 * MRExample class has main() method
 * @author jgard
 */
public class MRExample {

    /**
     * main() method utilizes both map and reduce methods
     * @param args
     */
    public static void main(String[] args){
        //creates MyList object and adds String elements
        MyList<String>  ls = new MyList<>();
        ls.add("heavy");
        ls.add("hard");
        ls.add("deep");
        //creates LengthFun object
        LengthFun fun = new LengthFun();
        //creates MyList object to hold ls String length values
        MyList li = ls.map(fun);
        //displays MyList object elements
        System.out.println(li.toString());
        //creates Summer object
        Summer day = new Summer();
        //displays sum of li elements
        System.out.println(li.reduce(day, 0));
    }
}
