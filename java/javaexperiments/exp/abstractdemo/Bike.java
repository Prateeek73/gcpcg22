package exp.abstractdemo;

public class Bike extends Vehicle{

public Bike(String vNumber){
super(vNumber);
}

@Override
public void move(){
 System.out.println( getVehicleNumber()+" moves like a bike");
}

}
