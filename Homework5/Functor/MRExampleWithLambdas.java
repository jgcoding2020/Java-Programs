/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functor;

/**
 * MRExampleWithLambdas class has main()
 * @author jgard
 */
public class MRExampleWithLambdas {
    
    /**
     * main() method creates chained lambda expression calls for map() and reduce() 
     * @param args
     */
    public static void main(String[] args){
        //creates MyList object and adds elements
        MyList<String> ls = new MyList<>();
        ls.add("heavy");
        ls.add("hard");
        ls.add("deep");
        //creates variable type functor instantiated
        Functor<Integer, String> func = (s) ->{
            return s.length();
        };
        //creates variable type functor2 instantiated
        Functor2<Integer, Integer, Integer> func2 = (x,y) ->{
            return x+y;
        };
        //displays map() and reduce() calls in one expression
        System.out.println(ls.map(func) + " and " + ls.map(func).reduce(func2,0));
    }
}