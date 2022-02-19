package exp.collectiondemos;

import java.util.*;

public class LinkedHashSetEx{

public static void main(String args[]){
Set<String> list=new LinkedHashSet<>();
list.add("amit");
list.add("animesh");
list.add("atul");
list.add("prakhar");
list.add("arunesh");
list.add("kajal");
list.add("arunesh");
int size=list.size();
System.out.println("list size="+size);


System.out.println("using foreach loop");

for(String iterated:list){
System.out.println("iterated="+iterated);
}



list.remove("prakhar");
System.out.println("list after removing element prakhar="+list);

boolean exists=list.contains("amit");
System.out.println("amit exists="+exists);
}
}

