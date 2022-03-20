import java.util.*;
import java.util.stream.Collectors;
import java.util.Collection;
import java.util.Optional;

class Candidate{
    private int id; 
    private int age;
    private int yearOfJoining;
    private double salary;
    private String name;
    private String gender;
    private String department;
    public Candidate(int id, String name, int age, String gender, String department, int yearOfJoining, double salary){
      this.id = id;
      this.age = age;
      this.yearOfJoining = yearOfJoining;
      this.salary = salary;
      this.name = name;
      this.gender = gender;
      this.department = department;
    }
    public void setId(int id){
      this.id = id;
    }
    public int getId(){
      return id;
    }
    public void setAge(int age){
      this.age = age;
    }
    public int getAge(){
      return age;
    }
    public void setYearOfJoining(int yearOfJoining){
      this.yearOfJoining = yearOfJoining;
    }
    public int getYearOfJoining(){
      return yearOfJoining;
    }
    public void setSalary(double salary){
      this.salary = salary;
    }
    public double getSalary(){
      return salary;
    }
    public void setName(String name){
      this.name = name;
    }
    public String getName(){
      return name;
    }
    public void setGender(String gender){
      this.gender = gender;
    }
    public String getGender(){
      return gender;
    }
    public void setDepartment(String department){
      this.department = department;
    }
    public String getDepartment(){
      return department;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
                + department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
    }
}

class Implementation{
  public static Map<String, Long> getCount(List<Candidate> list){
	Map<String, Long> genderMap = new HashMap<>();
    for(Candidate candidate : list){
		String gender = candidate.getGender();
		int previousCount = genderMap.getOrDefault(gender, 0);
		genderMap.put(gender, previousCount + 1);	
	}
    return genderMap;
  }
  public static Map<String, Double> getAverageAge(List<Candidate> list){
    Map<String, Long> genderMapCount = new HashMap<>();
	Map<String, Long> genderMapSum = new HashMap<>();
    for(Candidate candidate : list){
		String gender = candidate.getGender();
		int previousCount = genderMapCount.getOrDefault(gender, 0);
		int previousAgeSum = genderMapSum.getOrDefault(gender, 0);
		int age = candidate.getAge();
		genderMapCount.put(gender, previousCount + 1);
		genderMapSum.put(gender, previousAgeSum + age);
	}
	
	Map<String, Double> genderMapAverage = new HashMap<>();
	for(String gender : genderMapSum.keySet()){
		double average = genderMapSum.get(gender) / genderMapCount.get(gender);
		genderMapAverage.put(gender, average);
	}
	return genderMapAverage;
	
  }
  public static Map<String, Long> countCandidatesDepartmentWise(List<Candidate> list){
    	Map<String, Long> departmentCandidateCountMap = new HashMap<>();
    	for(Candidate candidate : list){
		String department = candidate.getDepartment();
		int previousCount = departmentCandidateCountMap .getOrDefault(department , 0);
		departmentCandidateCountMap .put(gender, previousCount + 1);	
	}
    return departmentCandidateCountMap ;
  }
  public static Optional<Candidate> getYoungestCandidateDetails(List<Candidate> list){
		int minAge = Integer.MAX_VALUE;
		Customer found = null;
		for(Customer customer : list){
			if(customer.getAge() < minAge){
				found = customer;
			}
		}
		Optional<Customer> optional;
		if(found == null){
			optional = Optional.empty();
			return optional;
		}
		optional = Optional.of(found);
		return optional;	
  }
}

public class Source {
	public static void main(String args[] ) throws Exception {
    
	}
}