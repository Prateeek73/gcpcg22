package exp.equalsdemo;

public class Trainee{

private int id;
private String name;

public Trainee(int id, String name){
this.id=id;
this.name=name;
}

public int getId(){
return id;
}

public String getName(){
return name;
}

/*

Trainee trainee1=new Trainee(1,"animesh");
Object trainee2=new Trainee(2,"animesh");
boolean isEquals=trainee1.equals(trainee2);


*/
@Override
public boolean equals(Object arg){
if(this==arg){
 return true;
}
if(arg==null || !(arg instanceof Trainee)){
return false;
}
Trainee that=(Trainee)arg;
boolean isEqual=this.id==that.id;
return isEqual;
}

}
