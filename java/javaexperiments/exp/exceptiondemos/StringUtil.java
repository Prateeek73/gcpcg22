package exp.exceptiondemos;

public class StringUtil{



 public char getCharAt(String input, int index) throws InvalidIndexException{
    if(index<0 || index>= input.length()){
    InvalidIndexException e= new InvalidIndexException("invalid index");
    throw e;
    }  
    char ch=input.charAt(index);
    return ch;  
 } 



  public int countCharAInString(String str){
    int count=0;
    for(int i=0;i<str.length();i++){
     char itChar=str.charAt(i);
     if(itChar=='a')
     count++;
      
    }
    
    return count;
  
  }


}
