package exp.collectiondemos;

import java.util.*;

public class LinkListEx{

public static void main(String args[]){
List<String> list=new LinkedList<>();
list.add("amit");
list.add("animesh");
list.add("atul");
list.add("prakhar");
list.add("arunesh");
list.add("kajal");
int size=list.size();
System.out.println("list size="+size);

String elAtIndex1 =list.get(1);
System.out.println("element at index 1 ="+elAtIndex1 );


for(int i=0;i<list.size();i++){
    String iterated=list.get(i);
System.out.println("iterated="+iterated);
}

System.out.println("using foreach loop");

for(String iterated:list){
System.out.println("iterated="+iterated);
}

list.add(0,"bad");
System.out.println("list after adding at start="+list);

list.remove("prakhar");
System.out.println("list after removing element prakhar="+list);

list.remove(2);
System.out.println("list after removing element at index 2="+list);

boolean exists=list.contains("amit");
System.out.println("amit exists="+exists);
}
}

