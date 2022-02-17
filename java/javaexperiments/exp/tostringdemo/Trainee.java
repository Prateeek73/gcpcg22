package exp.tostringdemo;

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

@Override
public String toString(){
String str=id+"-"+name;
return str;
}

}
