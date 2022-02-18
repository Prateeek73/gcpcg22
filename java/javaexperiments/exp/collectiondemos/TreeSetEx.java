package exp.collectiondemos;

import java.util.*;

 class TreeSetEx{

public static void main(String args[]){
Comparator<Student> ageComparator=new AgeComparator();
Set<Student> set=new TreeSet<>(ageComparator);
Student student2=new Student(2,"desh",22);
set.add(student2);
Student student1=new Student(1,"prakhar",21);
set.add(student1);
Student student3=new Student(3,"amit",23);
set.add(student3);

for(Student student:set){
System.out.println(student.getId()+"-"+student.getName()+"-"+student.getAge());

}


}
}

