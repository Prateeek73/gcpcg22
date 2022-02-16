package exp.arraydemo;

class StudentMain{

public static void main(String args[]){
ElectronicsStudent eceStudent1=new ElectronicsStudent(1,"aman", 21,"millimeter");

CseStudent cseStudent1=new CseStudent(2, "vibhor",22,"java");

StudentService service=new StudentService();
service.addAgeByValue(eceStudent1,5);
service.addAgeByValue(cseStudent1,7);

Student students[]=new Student[2];
students[0]=eceStudent1;
students[1]=cseStudent1;

for(int i=0;i<students.length;i++){
Student iteratedStudent=students[i];
boolean isEce=iteratedStudent instanceof ElectronicsStudent;
if(isEce){
ElectronicsStudent iteratedEce=(ElectronicsStudent)iteratedStudent;
String device=iteratedEce.getDevice();
System.out.println("device="+device);
}

boolean isCse=iteratedStudent instanceof CseStudent;
if(isCse){
CseStudent iteratedCse=(CseStudent)iteratedStudent;
String language=iteratedCse.getLearnedLanguage();
System.out.println("learned language="+language);
}

boolean ageEven=service.isAgeEven(iteratedStudent);
System.out.println("student  "+iteratedStudent.getId()+"-"+iteratedStudent.getName()+"-"+iteratedStudent.getAge()+" age even="+ageEven);



}

}



}
