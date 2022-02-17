package exp.abstractdemo;

 public abstract class Vehicle{

  private String vehicleNumber;

  public Vehicle(String vNumber){
   this.vehicleNumber=vNumber;
  
  }

   abstract void move();

  public String getVehicleNumber(){
  return vehicleNumber;
  }

}



