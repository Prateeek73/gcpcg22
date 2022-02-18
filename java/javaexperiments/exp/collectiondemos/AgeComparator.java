package exp.collectiondemos;

import java.util.*;

public class AgeComparator implements Comparator<Student>{

@Override
public int compare(Student st1, Student st2){
int age1=st1.getAge();
int age2=st2.getAge();
int comp=age1-age2;
return comp;
}

}
