package exp.strdemo;

class StringDemo{

public static void main(String args[]){
String str1="hello";
String str1Uppercased=str1.toUpperCase();
String substr1=str1.substring(2);
String substr2=str1.substring(1,3);
System.out.println("uppercased="+str1Uppercased);
System.out.println("substring starting from index 2="+substr1);
System.out.println("substring between index 1 and 3="+substr2);


}

}
