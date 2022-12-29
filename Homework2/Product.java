/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shop;

import java.util.*;
/**
 * Product Class acts as product inventory
 * @author jgard
 */
public class Product {

    // object array variables 
    public String[] item1;
    public String[] item2;
    public String[] item3;
    public String[] item4;
    String[] upcList;
    // object int variables
    int upcListLength;
    int count;
    
    /**
     * Product Class constructor initiates variables
     * @param upcListInput
     * @param upcListLengthInput
     */
    public Product(String[] upcListInput, int upcListLengthInput){
        item1 = new String[]{"101", "snicker's bar", "1.00"};
        item2 = new String[]{"102", "milk gallon", "3.99"};
        item3 = new String[]{"103", "wheat bread", "3.49"};
        item4 = new String[]{"104", "peanut butter", "4.99"};
        upcList = upcListInput;
        upcListLength = upcListLengthInput;
        count = 0;
    }
    
    /**
     * selectedProducts method creates multidimensional array of products selected
     * @return
     */
    public String[][] selectedProducts(){
        // multidimensional array for item transfer
        String[][] matchUPCArray = new String[upcListLength][3];
        // loop finds matching upc to populate multidimensional array
        for (int i = 0; i < upcListLength; i++){
            if (item1[0].equals(upcList[i])){
                for (int n = 0; n < 3; n++){
                    matchUPCArray[count][n] = item1[n];
                }
                count++;
            } else if (item2[0].equals(upcList[i])){
                for (int n = 0; n < 3; n++){
                    matchUPCArray[count][n] = item2[n];
                }
                count++;
            } 
            else if (item3[0].equals(upcList[i])){
                for (int n = 0; n < 3; n++){
                    matchUPCArray[count][n] = item3[n];
                }
                count++;
            }
            else if (item4[0].equals(upcList[i])){
                for (int n = 0; n < 3; n++){
                    matchUPCArray[count][n] = item4[n];
                }
                count++;
            }
        }
        // return array with selected upc products
        return matchUPCArray;
    }
}
