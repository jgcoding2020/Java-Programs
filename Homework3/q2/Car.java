/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2;
import java.util.*;
import java.time.*;
import java.text.*;

/**
 * Car class has make, model, and whenBuilt states
 * @author jgard
 * @precondition none
 * @postcondition none
 */
public class Car {
    private String carMake;
    private String carModel;
    private Date built;
    
    /**
     * Car class constructor
     * @param make
     * @param model
     * @param whenBuilt
     * @precondtion none
     * @postcondition none
     */
    public Car(String make, String model, Date whenBuilt)
    {
        this.carMake = make;
        this.carModel = model;
        this.built = whenBuilt;
    }
    
    /**
     * Car class method getMake() returns this Car object's make
     * @return
     * @precondtion none
     * @postcondition none
     */
    public String getMake()
    {
        return this.carMake;
    }
    
    /**
     * Car class method getModel() returns this Car object's model
     * @return
     * @precondition none
     * @postcondition none
     */
    public String getModel()
    {
        return this.carModel;
    }
    
    /**
     * Car class method getBuilt() returns this Car object's whenBuilt
     * @return
     * @precondition none
     * @postcondition none
     */
    public Date getBuilt()
    {
        return (Date) this.built.clone();
    }
    
    /**
     * Car class method toString() returns (displays) this Car object's states 
     * @return
     * @precondition none
     * @postcondition none
     */
    public String toString()
    {
        return ("\nThis vehicle make: " + this.carMake + ", model: " + this.carModel + ", and date built: " + this.built);
    }
    
    /**
     * Car class method getCompByMakeModel() compares the Car objects by carMake and carModel states
     * @return
     * @precondition objects in array are not sorted
     * @postcondition objects in array are sorted by make and model
     */
    public static Comparator<Car> getCompByMakeModel()
    {
        return new Comparator<Car>()
        {
            public int compare(Car first, Car second)
            {
                return (first.getMake() + first.getModel()).compareTo(second.getMake() + second.getModel());
            }
        };
    }
    

    /**
     * Car class method getCompareByDate() compares Car objects by whenBuilt state
     * @return
     * @precondition Car objects are not sorted
     * @postcondition Car objects are sorted by whenBuilt state
     */
    public static Comparator<Car> getCompByDate()
    {
        return new Comparator<Car>()
        {
            public int compare(Car first, Car second)
            {
                return first.getBuilt().compareTo(second.getBuilt());
            }
        };
    }

    /**
     * main method creates Car class objects and utilizes its methods
     * @param args
     */
    public static void main(String[] args)
    {
        //creates array list of Car objects and their states 
        ArrayList<Car> cars = new ArrayList<Car>();
        Date toyotaDate = new Date(2009-01-01);
        Car toyota = new Car("Toyota", "Corolla", toyotaDate);
        Date chevyDate = new Date(2015-01-01);
        Car chevy = new Car("Chevy", "Impala", chevyDate);
        Date fordDate = new Date(2022-01-01);
        Car ford = new Car("Ford", "Ranger", fordDate);
        Date dodgeDate = new Date(2005-05-01);
        Car dodge = new Car("Dodge", "Viper", dodgeDate);
        cars.add(toyota);
        cars.add(chevy);
        cars.add(ford);
        cars.add(dodge);
        
        //sorts car objects by make and model
        System.out.println("\nVehicles sorted by make and model: \n");
        Collections.sort(cars, Car.getCompByMakeModel());
        System.out.println(cars);
        
        //sorts car objects by date built
        System.out.println("\nVehicles sorted by date built: \n");
        Collections.sort(cars, Car.getCompByDate());
        System.out.println(cars);
    }
}

//    //compact method for reference
//    public static Comparator<Car> getCompByMakeModel()
//    {
//        Comparator<Car> comp = (first, second) ->
//        (first.getMake() + first.getModel()).compareTo(second.getMake() + second.getModel());
//        return comp;
//    }

//cars.sort(getCompByMakeModel()); // compact method
    
//    // compact method for reference
//    public static Comparator<Car> getCompByDate()
//    {
//        Comparator<Car> comp = (first, second) ->
//        first.getBuilt().compareTo(second.getBuilt());
//        return comp;
//    }
    
//cars.sort(getCompByDate()); //compact method