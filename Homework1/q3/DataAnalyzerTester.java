/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q3;


import java.util.*;

import java.io.*;

/**
 * DataAnalyzerTester has main method 
 * @author jgard
 */
class DataAnalyzerTester {
    
  /**
  * Main method
  * @return 
  */
  public static void main(String args[]) {
      
      try {

        // declare numList as variable
        // linked list that stores user inputs
          LinkedList<Integer> numList = new LinkedList<Integer>();

          int num;
          
          // declares Scanner class object
          Scanner input = new Scanner(System.in);
          String fileName;

          // displays statement
          System.out.print("\n Enter file name for storing numbers: ");
          fileName = input.nextLine();

          // creates file variable
          File createfile = new File(fileName);

          // creates file
          createfile.createNewFile();

          // creates a FileWriter Object
          FileWriter writer = new FileWriter(createfile);

          System.out.println("\n Start entering numbers (0 to stop): \n");

          // reads number
          num = input.nextInt();

          // iterates loop until user enters 0
          while(num != 0) {

              // writes numbers to the file
              writer.write(num + " \n ");

              // add numbers to list
              numList.add(num);

              // get another number from user
              num = input.nextInt();
          }

          // creates DataAnalyzer object
          DataAnalyzer analyzerObject = new DataAnalyzer(numList);

          // displays statement for min, max and average values
          System.out.println("\n Minimum Number: " + analyzerObject.min());

          writer.write("\n Minimum Number: " + analyzerObject.min());
          System.out.println("\n Maximum Number: " + analyzerObject.max());

          writer.write("\n Maximum Number: " + analyzerObject.max());
          System.out.println("\n Average: " + analyzerObject.average() + " \n");

          writer.write("\n Average: " + analyzerObject.average() + " \n");
          writer.flush();

          // close the file object
          writer.close();
      }
      
      catch(Exception ex) {

        // display statement
        System.out.println(ex);
      }
  }
}

