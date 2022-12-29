/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q3;


import java.util.*;

/**
 * DataAnalyzer class creates number list, saves to txt, calculates min, max, and avg
 * @author jgard
 */
class DataAnalyzer {

  private LinkedList<Integer> numbers;

  /**
   * constructor stores number list
   * @param numList
   */
  public DataAnalyzer(LinkedList<Integer> numList) {
      //Storing numList to numbers
      numbers = numList;
  }

  
  
  /**
   * min method returns minimum number
   * @return 
   */
  public int min() {
      
      // considers min number as first number
      int minNum = numbers.get(0);

      // iterates list of numbers
      for(int j=0; j < numbers.size(); j++) {
          // minNum comparison
          if( numbers.get(j) < minNum )
              // updates minNum
              minNum = numbers.get(j);
      }

      // returns minimum number
      return minNum;
  }

  /**
   * max method returns maximum number
   * @return 
   */
  public int max() {
      // considers first number as max number
      int maxNum = numbers.get(0);

      // iterates the numbers in the list
      for(int j = 0; j < numbers.size(); j++) {
          
          // compares numbers with maxNum
          if( numbers.get(j) > maxNum )
              // update maximum number
              maxNum = numbers.get(j);
      }
     
      // returns maximum number
      return maxNum;
  }
 
  /**
   * average() method returns average number
   * @return 
   */
  public double average() {
       // declares sum as integer and assigns value to zero
      int sum = 0;
      // declares avg as double type
      double avg;
      
      // iterate number list
      for(int j=0; j < numbers.size(); j++) {
          // add sum of numbers
          sum = sum + numbers.get(j);
      }

      avg = sum / (double)(numbers.size());
      // return average value
      return avg;
  }
}