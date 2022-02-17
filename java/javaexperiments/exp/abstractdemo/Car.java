package exp.abstractdemo;

public class Car extends Vehicle{

public Car(String vNumber){
super(vNumber);
}

@Override
public void move(){
 System.out.println( getVehicleNumber()+" moves like a car");
}

}
