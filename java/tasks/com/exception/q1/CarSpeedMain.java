package com.exception.q1;

public class CarSpeedMain {

    public static void main(String[] args){
        Car car = new Car("UP32 F868", "60");
        CarService service = new CarService();
        try{
            service.assignCarSpeed(car, 80);
        }
        catch(InvalidSpeedException ex){
            //ex.getStackTrace();
            System.err.println(ex.getMessage());
        }
        catch(Exception ex){
            //ex.getStackTrace();
            System.err.println(ex.getMessage());    
        }
        System.out.println("Car: {vehicleNumber:" + car.vehicleNumber + ", speed:" + car.speed + "}");
    }
    
}
