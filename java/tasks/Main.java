class StringUtil{
	static boolean isVowel(char ch){
		return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'o' || ch == 'u' || ch == 'U';
	}
	StringBuilder convertVowelsToB(String input){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<input.length(); i++){
			char ch = input.charAt(i);
			if(isVowel(ch)){
				sb.append('b');
			} else{
				sb.append(ch);
			}
		}
		return sb;
	}
	boolean isPangram(String input){
		int[] count = new int[26];
		for(int i=0; i<input.length(); i++){
			char ch = input.charAt(i);
			if(Character.isUpperCase(ch)){
				count[ch - 'A'] = 1;
			}
		}
		if(Character.isLowerCase(ch)){
				count[ch - 'a'] = 1;
			}
		}
		for(int flag : count){
			if(flag == 0){
				return false;
			}
		}
		return true;
	}
	int uniqueConsonants(String input){
		Set<Character> uniqueConsonants = new HashSet<>();
		for(int i=0; i<input.length(); i++){
			char ch = input.charAt(i);
			if(!isVowel(ch)){
				uniqueConsonants.add(ch);
			}
		}
		return uniqueConsonants.size();
	}
	public boolean validateCreditCard(String input){
		//Condition 1
		if(input.length()!=13 || input.length()!=16){
			return false;
		}
		//Condition 2
		for(int i=0; i<input.length(); i++){
			char ch = input.charAt(i);
			if(Character.isAlphabetic(ch)){
				return false;
			}
		}
		//Condition 3
		if(input.charAt(0)!='4'){
			return false;
		}
		
		//Condition 4+5 (first 13 character should always be b/w (1,9)
		if(input.length()==13){
			return first13valid(input);
		}
		boolean is13Valid = firs13Valid(input);
		if(is13Valid){
			return true;
		}
		//Condition 5 for 16 digit card
		for(int i=13; i<input.length(); i++){
			char ch = input.charAt(i);
			if(ch < '2' || ch > '6'){
				return false;
			}
		}
		return true;
	}
	public boolean firs13Valid(String input){
		for(int i=0; i<13; i++){
			char ch = input.charAt(i);
			if(ch == '0'){
				return false;
			}
		}
		return true;
	}
}
class Main{
	public static void main(String[] args){
		StringUtil util = new StringUtil();
		String input = "";
		System.out.println(util.
	}	
}