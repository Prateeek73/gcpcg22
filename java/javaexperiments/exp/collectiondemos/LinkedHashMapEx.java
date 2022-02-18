package exp.collectiondemos;

import java.util.*;

 class LinkedHashMapEx{

public static void main(String args[]){
Map<Integer,Student> map=new LinkedHashMap<>();
Student student2=new Student(2,"desh",22);
map.put(2, student2);
Student student1=new Student(1,"prakhar",21);
map.put(1,student1);
Student student3=new Student(3,"amit",23);
map.put(3,student3);

Student found=map.get(1);
System.out.println("student fetched for key 1");
System.out.println(found.getId()+"-"+found.getName()+"-"+found.getAge());

Set<Integer>keys =map.keySet();
System.out.println("iterating on the keys and fetching values");
for(Integer key: keys){
Student iteratedVal=map.get(key);
System.out.println(iteratedVal.getId()+"-"+iteratedVal.getName()+"-"+ iteratedVal.getAge());

}

System.out.println("iterating on the values");
Collection<Student>values= map.values();
for(Student iteratedVal: values){
System.out.println(iteratedVal.getId()+"-"+iteratedVal.getName()+"-"+ iteratedVal.getAge());

}


map.remove(2);
keys =map.keySet();
System.out.println("removed entry with key2  ");
for(Integer key: keys){
Student iteratedVal=map.get(key);
System.out.println(iteratedVal.getId()+"-"+iteratedVal.getName()+"-"+ iteratedVal.getAge());

}



}
}

