package exp.equalsdemo;

public class TraineeMain{

public static void main(String args[]){
Trainee trainee1=new Trainee(1,"animesh");
Trainee trainee2=trainee1;
Trainee trainee3=new Trainee(1,"animesh");

if(trainee1==trainee2){
System.out.println("trainee1 and trainee2 are same" );
}

boolean isEquals=trainee1.equals(trainee3);

if(isEquals){
System.out.println("trainee1 and trainee3 are equals" );
}

}

}
