package exp.enumdemos;



public enum Department {

    IT("it","information technology"),
    ECE("ece","electronics engineering"),
    Mechanical("mc","mechanical engineering")
    ;

    private String code,fullname;

    public  String getCode(){
        return code;
    }

    public String getFullname(){
        return fullname;
    }

    Department(String code, String fullName){
      this.code = code;
      this.fullname=fullName;
    }





}
