package exp.arraydemo;

class StudentMain{

public static void main(String args[]){
Student st1=new Student(1,"aman", 21);

Student st2=new Student(2, "vibhor",22);

StudentService service=new StudentService();
service.addAgeByValue(st1,5);
service.addAgeByValue(st2,7);

Student students[]=new Student[2];
students[0]=st1;
students[1]=st2;

for(int i=0;i<students.length;i++){
Student iteratedStudent=students[i];
boolean ageEven=service.isAgeEven(iteratedStudent);
System.out.println("student  "+iteratedStudent.getId()+"-"+iteratedStudent.getName()+"-"+iteratedStudent.getAge()+" age even="+ageEven);

}

}



}
