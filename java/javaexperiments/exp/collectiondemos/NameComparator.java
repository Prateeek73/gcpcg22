package exp.collectiondemos;

import java.util.*;

public class NameComparator implements Comparator<Student>{

@Override
public int compare(Student st1, Student st2){
String name1=st1.getName();
String name2=st2.getName();
int comp=name1.compareTo(name2);
return comp;
}

}
