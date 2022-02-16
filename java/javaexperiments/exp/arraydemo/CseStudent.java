package exp.arraydemo;

class CseStudent extends Student{

private String learnedLanguage;

public CseStudent(int id, String name, int age,String language){
super(id, name, age);
this.learnedLanguage=language;
}

public String getLearnedLanguage(){
return learnedLanguage;
}

public void setLearnedLanguage(String language){
this.learnedLanguage=language;
}

}

 
