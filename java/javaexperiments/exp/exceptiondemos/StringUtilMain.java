package exp.exceptiondemos;


public class StringUtilMain{

public static void main(String args[]){
StringUtil util=new StringUtil();
String str="hello";
int index=10;
try{
char foundChar=util.getCharAt(str,index);
System.out.println("found char="+foundChar);
}
catch(NullPointerException e){
System.out.println("string passed is null");
}


catch(InvalidIndexException e){
System.out.println("index is either negative or bigger than string");

}
/*
catch(Exception e){
e.printStackTrace();
System.out.println("something went wrong");
}*/

System.out.println("bye");
}


}

