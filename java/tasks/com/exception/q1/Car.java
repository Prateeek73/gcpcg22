package com.exception.q1;

public class Car {
    public String vehicleNumber;
    public String speed;

    public Car(){
        this.vehicleNumber = "";
        this.speed = "";
    }

    public Car(String vehicleNumber, String speed){
        this.vehicleNumber = vehicleNumber;
        this.speed = speed;
    }

    public String getVehicleNumber(){
        return this.vehicleNumber;
    }

    public String speed(){
        return this.speed;
    }

    public void setVehicleNumber(String vehicleNumber){
        this.vehicleNumber = vehicleNumber;
    }

    public void setSpeed(String speed){
        this.speed = speed;
    }
}
