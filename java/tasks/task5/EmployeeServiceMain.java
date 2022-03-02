import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;  
import java.util.Comparator;

class Employee{
	int id;
	String name;
	Employee(int id, String name){
		this.id = id;
		this.name = name;
	}
}
enum Sort{
	BYID,
	BYNAME;
}
class EmployeeService{
	List<Employee> sortEmployees(List<Employee> list, Sort sort){
		Comparator<Employee> idComparator = (o1, o2) -> Integer.compare(o1.id, o2.id);
		Comparator<Employee> nameComparator = (o1, o2) -> (o1.name).compareTo(o2.name);
		//List<Employee> sorted_list = new ArrayList<>();
		if(sort == Sort.BYID){
			return list.stream()
						.sorted(idComparator)
						.collect(Collectors.toList());	
		}
		if(sort == Sort.BYNAME){
			return list.stream()
						.sorted(nameComparator)
						.collect(Collectors.toList());
		}
		return new ArrayList<>();
	}
}
class EmployeeServiceMain{
	public static void main(String[] args){
		List<Employee> list  = new ArrayList<Employee>();
		list.add(new Employee(48,"Tommy Cruise"));
		list.add(new Employee(34,"Rosamuun Pike"));
		list.add(new Employee(36,"Richard Jenkins"));
		list.add(new Employee(42,"Zach Oyelowo"));
		list.add(new Employee(69,"Werner Herzorg"));

		EmployeeService service = new EmployeeService();
		//List<Employee> sorted_list = service.sortEmployees(list, Sort.BYID);
		System.out.print("[");
		for(Employee employee : service.sortEmployees(list, Sort.BYID)){
			System.out.println("{ id : " + employee.id + ", name : "+ employee.name + " }");
		} 
		System.out.println("]");
		
		//sorted_list = service.sortEmployees(list, Sort.BYNAME);
		System.out.print("[");
		for(Employee employee : service.sortEmployees(list, Sort.BYNAME)){
			System.out.println("{ id : " + employee.id + ", name : "+ employee.name + " }");
		}
		System.out.print("]");
	}
}