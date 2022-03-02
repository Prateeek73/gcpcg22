import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Activity{
	public String string1;
  	public String string2;
  	public String operator;
  	public Activity(String string1, String string2, String operator){
    		this.string1 = string1;
    		this.string2 = string2;
    		this.operator = operator;
  	}
  	public void setString1(String string1){
    		this.string1 = string1;
  	}
  	public String getString1(){
    		return string1;
  	}
  	public void setString2(String string2){
    		this.string2 = string2;	
	}
  	public String getString2(){
    		return string2;
  	}
  	public void setOperator(String operator){
    		this.operator = operator;
  	}
  	public String getOperator(){
    		return operator;
  	}
}

public class Solution{
	public String handleException(Activity a){
		try{
			if(a.getString1() == null || a.getString2() == null){
				throw new NullPointerException("Null values found");
			}
			boolean isValidOperator = a.getOperator().equals("+") || a.getOperator().equals("-");
			if(!isValidOperator){
				throw new Exception(a.getOperator());
			}
		} catch(NullPointerException ex){
      		//ex.printStackTrace();
      		System.out.println(ex.getMessage());
    		} catch(Exception ex){
      		//ex.printStackTrace();
      		System.out.println(ex.getMessage());
    		}
    		return "No Exception Found";
  	}
	public String doOperation(Activity a){
    		String result = "";
    		switch(a.getOperator()){
      		case "+" : result = a.getString1() + a.getString2();
                 	   		break;
      		case "-" : result = a.getString1().replaceAll(a.getString2(), "");
    		}
    		return result;
  	}
	public static void main(String args[] ) {
    		//Scanner sc = new Scanner(System.in);
    		String string1 = "hello";
    		String string2 = "world";
    		String operator = "+";
    		Activity a = new Activity(string1, string2, operator);
    		Solution src = new Solution();
			System.out.println(src.handleException(a));
    		System.out.println(src.doOperation(a));
    		//sc.close();
	}
}