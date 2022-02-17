package exp.exceptiondemos;


public class StringUtilMain{

public static void main(String args[]){
StringUtil util=new StringUtil();
String str=null;
int index=1;
try{
char foundChar=util.getCharAt(str,index);
System.out.println("found char="+foundChar);
}
catch(StringIndexOutOfBoundsException e){
System.out.println("index bigger than string length");
}
catch(NullPointerException e){
System.out.println("string passed is null");
}
catch(Exception e){
System.out.println("something went wrong");
}

System.out.println("bye");
}


}

