package exp.arraydemo;

class StudentService{


boolean isAgeEven(Student student){
 int age=student.getAge();
 boolean result=age%2==0;
  return result;
}

void addAgeByValue(Student student,int value){
int age=student.getAge();
age=age+value;
}


}


