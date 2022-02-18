package exp.foreachdemo;

public class ForEachEx1{

public static void main(String args[]){
String strings[]={"hi","hello","bye"};

for(int i=0;i<strings.length;i++){
 String iterated=strings[i];
 System.out.println("iterated="+iterated);
}


System.out.println("foreach loop demo below");
for(String iterated:strings){
 System.out.println("iterated="+iterated);
}
}


} 
