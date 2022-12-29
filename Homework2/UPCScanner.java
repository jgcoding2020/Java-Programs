/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shop;

import java.util.*;
/**
 * UPCScanner class holds scanned item UPCs
 * @author jgard
 */
public class UPCScanner {
    // object variables
    public String[] upcList;
    public int upcListLength;
    // UPCScanner class constructor
    public UPCScanner(String[] upcArray, int length){
        upcList = upcArray;
        upcListLength = length;
    }
}
