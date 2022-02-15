class Student{

int id;
String name;
int age;

Student(){
id=-1;
name="";
age=-1;
}

Student(int id, String name, int age){
 this.id=id;
 this.name=name;
 this.age=age;
}

boolean isAgeEven(){
 boolean result=age%2==0;
  return result;
}

}

