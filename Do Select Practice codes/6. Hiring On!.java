import java.util.*;
import java.util.stream.Collectors;  

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
    Set<String> gendersList = list.stream()
								.map(Candidate::getGender)
								.sorted(String::compareTo)
								.collect(Collectors.toSet());
    for(String gender : gendersList){
      long genderCount = list.stream()
							.filter(o -> o.getGender().equals(gender))
							.count();
      if(genderCount != 0){
        genderMap.put(gender, genderCount);
      }
    }
    return genderMap;
  }
  public static Map<String, Double> getAverageAge(List<Candidate> list){
    Map<String, Double> genderMap = new HashMap<>();
    Set<String> gendersList = list.stream()
								.map(Candidate::getGender)
								.sorted(String::compareTo)
								.collect(Collectors.toSet());
    for(String gender : gendersList){
      long genderCount = list.stream()
							.filter(o -> o.getGender().equals(gender))
							.count();
      Optional<Integer> genderAgeSum = list.stream()
										.filter(o -> o.getGender().equals(gender))
										.map(o -> o.getAge())
                    					.reduce(Integer::sum);
      if(genderAgeSum.isPresent() && genderAgeSum.get() != 0){
        genderMap.put(gender, (double) genderAgeSum.get() / genderCount);
      }
    }
    return genderMap;
  }
  public static Map<String, Long> countCandidatesDepartmentWise(List<Candidate> list){
    Map<String, Long> departmentMap = new HashMap<>();
    Set<String> departmentList = list.stream()
									.map(Candidate::getDepartment)
									.sorted(String::compareTo)
									.collect(Collectors.toSet());
    for(String department : departmentList){
      long departmentCount = list.stream()
								.filter(o -> o.getDepartment()
								.equals(department))
								.count();
      if(departmentCount != 0){
        departmentMap.put(department, departmentCount);
      }
    }
    return departmentMap;
  }
  public static Optional<Candidate> getYoungestCandidateDetails(List<Candidate> list){
      return list.stream().max((o1, o2) -> o1.getAge() - o2.getAge());
  }
}

public class Source {
	public static void main(String args[] ) throws Exception {
    
	}
}