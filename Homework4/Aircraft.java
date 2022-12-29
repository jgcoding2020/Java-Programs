/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aircraft;

import java.io.*;

/**
 * 
 * @author jgard
 */

/**
 * abstract superclass Aircraft has three methods 
 * precondition none
 * postcondition none
 */
public abstract class Aircraft {
    
    /**
     * class Aircraft method takeOff()
     * precondition none
     * postcondition none
     */
    public void takeOff(){};

    /**
     * class Aircraft method fly()
     * precondition none
     * postcondition none
     */
    public void fly(){};

    /**
     * class Aircraft method land()
     * precondition none
     * postcondition none
     */
    public void land(){};
    
    /**
     * class Airplane is subclass of Aircraft
     * Airplane methods override Aircraft method
     */
    public static class Airplane extends Aircraft {

        /**
         * class Airplane method  
         * precondition none
         * postcondition none
         */
        @Override
        public void takeOff(){
            System.out.println("The propeler excelerates the airplane until gaining enough speed to take off.");
        };

        /**
         * class Airplane method 
         * precondition none
         * postcondition none
         */
        @Override
        public void fly(){
            System.out.println("The airplane maintains altitude while flying to efficiently use its fuel while heading to its destination.");
        };

        /**
         * class Airplane method 
         * precondition none
         * postcondition none
         */
        @Override
        public void land(){
            System.out.println("The airplane lifts its front end to touch down on the ground and begins to decelerate.");
        };
    }
    
    /**
     * class Helicopter is subclass of Aircraft
     */
    public static class Helicopter extends Aircraft {

        /**
         * Helicopter method takeoff()
         * precondition none
         * postcondition none
         */
        @Override
        public void takeOff(){
            System.out.println("The helicopter's propeler spins rapidly until creating enough lift to go airborne.");
        };

        /**
         * helicopter method fly()
         * precondition none
         * postcondition none
         */
        @Override
        public void fly(){
            System.out.println("The helicopter tilts slightly forward to head towards its destination.");
        };

        /**
         * Helicopter method land()
         * precondition none
         * postcondition none
         */
        @Override
        public void land(){
            System.out.println("The helicopter stabalizes and begins its decent in a vertical line to the ground.");
        };
    }
    
    /**
     * FighterJet is subclass of Aircraft
     */
    public static class FighterJet extends Aircraft {

        /**
         * FighterJet method takeOff()
         * precondition none
         * postcondition none
         */
        @Override
        public void takeOff(){
            System.out.println("The jet engine creates enough thrust to lift the jet off the ground.");
        };

        /**
         * FighterJet method fly()
         * precondition none
         * postcondition none
         */
        @Override
        public void fly(){
            System.out.println("The jet engine continues to push the jet towards its destination.");
        };

        /**
         * FighterJet method land()
         * precondition none
         * postcondition none
         */
        @Override
        public void land(){
            System.out.println("The jet lifts its nose to make impact with the ground and decelerates.");
        };
    }
    
    /**
     * Aircraft method scenario displays this object's method implementations
     * precondition none
     * postcondition none
     */
    public void scenario(){
        this.takeOff();
        this.fly();
        this.land();
    }
    
    /**
     * main method creates objects and invokes method scenario
     * @param args
     */
    public static void main(String[] args) {
        Airplane sessna = new Airplane();
        sessna.scenario();
        Helicopter heli = new Helicopter();
        heli.scenario();
        FighterJet f_16 = new FighterJet();
        f_16.scenario();
        
    }
}


