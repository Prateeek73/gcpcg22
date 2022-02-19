package exp.collectiondemos;

class Student {

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

/*
if two objects are equal then their hashcode should be equal

if two objects have equal hashcode, objects may or may not be equal
*/
@Override
public boolean equals(Object arg){
if(this==arg){
return true;
}
if(arg==null || !(arg instanceof Student)){
return false;
}
Student that=(Student)arg;
return this.id==that.id;

}

@Override
public int hashCode(){
return id;
}


}
