Employee{
	int id;
	String firstName;
	String lastName;
	String dept;
	double sal;
}
class StringUtil{
	static boolean isVowel(char ch){
		return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'o' || ch == 'u' || ch == 'U';
	}
	int countVowels(String input) throw VowelNotFoundException{
		int count = 0;
		for(int i=0; i<input.length(); i++)}{
			char ch = input.charAt(i);
			if(isVowel(ch)){
				count++;	
			}
		}
		if(count == 0){
			throw new VowelNotFoundException();
		}
		return count;
	}
	String findUniqueVowels(String input){
		StringBuilder uniqueVowelsSb= new StringBuilder();
		for(int i=0; i<input.length(); i++)}{
			char ch = input.charAt(i);
			if(isVowel(ch) && uniqueVowels.indexOf(ch)!=-1){
				uniqueVowelsSb.append(ch);
			}
		}
		return uniqueVowelsSb.toString();		
	}
	String reverse(String input){
		StringBuilder sb = new StringBuilder(input);	
		sb.reverse();
		return sb.toString();
	
	}
	String orderedCharactersString(String input){
		
	}
	String subtract(String input1, String input2){
		int idx = input1.indexOf(input2);
		if(idx == -1){
			return "input2 not part of input1";
		}
		input1.replace(input2, "");
		return input1;
	}
	double changeToNumberString(String input){
		
	}
	Employee convertToEmployee(String input){
		Employee employee = new Employee();
		int idIdx = input.indexOf("ID");
		String name = input.substring(0, idIdx);
		int dotIndex = name.indexOf(".");
		employee.firstName = name.substring(0, dotIndex);
		employee.lastName = name.substring(dotIndex + 1);
		
		int idValueIndex = idIdx + 2;
		int idEndIndex = input.indexOf("DT");
		String idText = input.substring(idValueIndex, idEndIndex);
		int id = Integer.parseInt(idText);
		employee.id = id;

		int departmentValueIndex = idEndIndex + 2;
		int departmentEndIndex = 
		String departmentText = input.substring(departmentValueIndex , idEndIndex);
		
	}
	String[] partsLengthGreaterThan3(String input){
	
	}
}