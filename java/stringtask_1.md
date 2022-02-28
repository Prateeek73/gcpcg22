**string task**

StringUtil{

//if no vowel found
int countVowels(String input) throws VowelNotFoundException

//find string containing unique vowels found in input
// input  "eyenose" output "eo"

String foundUniqueVowels(String input)

String reverse(String input)

//input ear, output aer

String orderedCharactersString(String input)

//input1 hello , input2 el , output -hlo
//if input not found in input1 then output "input2 not part of input1"

String subtract(String input1, String input2)

// input 28-89 , output 28.89

double changeToNumberString(String input)

// input example- 12-id_madhvan-name_80000$
Employee convertToEmployee(String input)

//Arpit.MehtaID123456DTIT80L

//output has list with elements hello , world , good , more

List<String> partsLengthGreaterThan3(String input)

}

Employee{

int id

String firstName

String lastName

String dept

double sal

}

