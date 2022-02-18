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


Comparator<Student> comparator=new AgeComparator();
list.sort(comparator);
System.out.println("after sorting");
for(Student student:list){
System.out.println(student.getId()+"-"+student.getName()+"-"+student.getAge());

}

}
}

