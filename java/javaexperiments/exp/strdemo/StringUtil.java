package exp.stringdemos;


class StringUtil {

    public  static void main(String args[]){
        StringUtil util=new StringUtil();
        String input="Arpit.MehtaID123456DTIT80L";
        Employee employee= util.convertToEmployee(input);
        System.out.println("id="+employee.id+" first="+ employee.firstName+" last="+employee.lastName+"sal="+employee.salary);
    }


    // input example- Arpit.MehtaID123456DTIT80L
    public Employee convertToEmployee(String input){
        Employee  employee=new Employee();
        int idIndex=input.indexOf("ID");
        String name=input.substring(0,idIndex);
        System.out.println("name="+name);
        int dotIndex=name.indexOf(".");
        employee.firstName=name.substring(0,dotIndex);
        employee.lastName=name.substring(dotIndex+1);
        int idValueIndex=idIndex+2;
        int idEndIndex=input.indexOf("DT");
        String idText=input.substring(idValueIndex,idEndIndex);
        int id=Integer.parseInt(idText);
        employee.id=id;
        int deptTextIndex=idEndIndex;
        int deptValueStartIndex=deptTextIndex+2;
        int deptValueEndIndex=deptValueStartIndex+2;
        String deptValue=input.substring(deptValueStartIndex,deptValueEndIndex);
        employee.dept=deptValue;
        int salStartIndex=deptValueEndIndex;
        String salText=input.substring(salStartIndex);
        String salTextValue=salText.substring(0,salText.length()-1);
        double sal=Double.parseDouble(salTextValue);
        sal=sal*100000;
        employee.salary=sal;
        return employee;
    }
}
