import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

class Employee {
    String name;
    int salary;
    Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getSalary(){
        return salary;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append("name: ");
        sb.append(name);
        sb.append(" salary: ");
        sb.append("" + salary+">");
        return sb.toString();

    }
}
class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.name.compareTo(o2.name);
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.salary, o2.salary);
    }
}
class EmployeeInfo{
    enum SortMethod {
		BYNAME,
		BYSALARY;
    };
    public List<Employee> sort(List<Employee> emps, final SortMethod method){
		if(method == SortMethod.BYNAME){
        	emps.sort(new NameComparator());
		}
		if(method == SortMethod.BYNAME){
			emps.sort(new SalaryComparator());
		}
		return emps;
    }
    public boolean isCharacterPresentInAllNames(Collectio<Employee> entities, String character){
        List<Employee> list = entities;
        int count = list.stream()
                        .filter(emp->emp.getName().indexOf(character)!=-1)
                        .count();
        return count!=0;
    }
}