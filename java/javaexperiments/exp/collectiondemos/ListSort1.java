 package exp.collectiondemos;

import java.util.*;

 class ListSort1{

public static void main(String args[]){
List<Student> list=new ArrayList<>();
Student student2=new Student(2,"desh",22);
list.add(student2);
Student student1=new Student(1,"prakhar",21);
list.add(student1);
Student student3=new Student(3,"amit",23);
list.add(student3);



for(Student student:list){
System.out.println(student.getId()+"-"+student.getName()+"-"+student.getAge());

}


Comparator<Student> ageComparator=new AgeComparator();
list.sort(ageComparator);
System.out.println("after sorting by age");
for(Student student:list){
System.out.println(student.getId()+"-"+student.getName()+"-"+student.getAge());
}

Comparator<Student> nameComparator=new NameComparator();
list.sort(nameComparator);
System.out.println("after sorting by name");
for(Student student:list){
System.out.println(student.getId()+"-"+student.getName()+"-"+student.getAge());
}


}
}

