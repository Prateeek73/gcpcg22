package exp.arraydemo;

class Student{

private int id;
private String name;
private int age;

public Student(){
id=-1;
name="";
age=-1;
}

public Student(int id, String name, int age){
 this.id=id;
 this.name=name;
 this.age=age;
}

public int getId(){
return id;
}

public void setId(int id){
this.id=id;
}

public String getName(){
return name;
}

public void setName(String name){
this.name=name;
}

public void setAge(int age){
this.age=age;
}

public int getAge(){
return age;
}

}

