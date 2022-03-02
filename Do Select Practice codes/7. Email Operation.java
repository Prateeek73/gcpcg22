import java.util.Scanner;

class Email{
	Header header;
	String body;
	String greetings;
	Email(Header header, String body, String greetings){
		this.header = header;
		this.body = body;
		this.greetings = greetings;
	}
}
class Header{
	String from;
	String to;
	Header(String from, String to){
		this.from = from;
		this.to = to;
	}
}
class EmailOperations{
	public int emailVerify(Email e){
		Header header = e.header;
		String from = header.from;
		String to = header.to;
		int count = 0;
		if(isValid(from))
			count++;
		if(isValid(to))
			count++;
		return count;
	}
	public static boolean isValid(String str){
		char first_character = str.charAt(0);
		boolean isAlphabetAndUnderscore = (first_character>='a' && first_character<='z') 
										|| (first_character>='A' && first_character<='Z') 
										|| first_character=='_';
		if(!isAlphabetAndUnderscore)
			return false;
		
		int idxStartAtTheRate = str.indexOf("@");
		int idxEndAtTheRate = str.lastIndexOf('@');
		boolean singleAtTheRate = idxStartAtTheRate!=-1 && idxStartAtTheRate==idxEndAtTheRate;
		if(!singleAtTheRate)
			return false;

		int idxStartDot = str.indexOf(".");
		int idxEndDot = str.lastIndexOf(".");
		boolean singleDot = idxStartDot!=-1 && idxStartDot>idxStartAtTheRate && idxStartDot==idxEndDot;
		if(!singleDot)
			return false;	
		
		return true;
	}
	public String bodyEncryption(Email e){
		String body = e.body;
		String encrypted_body = "";
		for(int i=0; i<body.length(); i++){
			char ch = body.charAt(i);
			boolean isAlphabet = (ch>='a' && ch<='z') || (ch>='A' && ch<='Z') ;
			if(isAlphabet){
				switch(ch){
					case 'z' : ch = 'c';
								break;
					case 'y' : ch = 'b';
								break;
					case 'x' : ch = 'a';
								break;	
					case 'Z' : ch = 'C';
								break;
					case 'Y' : ch = 'B';
								break;
					case 'X' : ch = 'A';
								break;	
					default : ch += 3;			
				}
			}
			encrypted_body +=ch;
		}
		return encrypted_body;
	}
	public String greetingMessage(Email e){
		Header header = e.header;
		String greetings = e.greetings;
		String to = header.to;
		int atTheRate_idx = to.indexOf("@");
		String name = to.substring(0, atTheRate_idx);
		return greetings + " " + name; 
	}
}
public class Source{
	public static void main(String args[]){
		// Scanner sc = new Scanner(System.in);
		Header header = new Header("kawasaki@randomDomain.net", "yakuza@gang.com");
		Email e = new Email(header, "This is the body A bit chubby but ok", "Konichiwa");
		EmailOperations util = new EmailOperations();
		System.out.println(util.emailVerify(e));
		System.out.println(util.bodyEncryption(e));
		System.out.println(util.greetingMessage(e));
		// sc.close();
	}
}