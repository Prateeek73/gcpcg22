package exp.exceptiondemos;

public class StringUtil{



 public char getCharAt(String input, int index){
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
