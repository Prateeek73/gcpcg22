package exp.enumdemos;

public class DepartmentMain {
    public static void main(String args[]){
        Department mech=Department.Mechanical;
        String code=mech.getCode();
        String fullname=mech.getFullname();
        System.out.println("code="+code+" fullname="+fullname);
        Department departments[]=Department.values();
        for (Department department:departments){
            System.out.println("code="+department.getCode()+" fullname="+department.getFullname());
        }
    }
}
