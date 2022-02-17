package exp.tostringdemo;

public class TraineeMain{

public static void main(String args[]){
Trainee trainee=new Trainee(1,"animesh");
String text=trainee.toString();
System.out.println("text representation="+text);
System.out.println("presentating details id is="+trainee.getId()+" name is "+trainee.getName());
}

}
