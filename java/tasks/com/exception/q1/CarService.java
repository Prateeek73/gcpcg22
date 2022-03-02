package com.exception.q1;

public class CarService {

    public CarService(){
        
    }
    
    public String assignCarSpeed(Car car, int speed) throws InvalidSpeedException{
        if(speed>=20 && speed<=90){
            String str_speed = Integer.toString(speed);
            car.speed = str_speed;
            return str_speed;
        }
        throw new InvalidSpeedException("Invalid Speed");
    }
}
