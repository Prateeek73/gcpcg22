import java.util.List;
import java.util.ArrayList;

class Customer{
	long id = 0;
	String firstName;
	String lastName;
	double balance;
	Customer(String firstName, String lastName, double balance){
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		++this.id;
	}
	long getId(){
		return id;
	}
	String getFirstName(){
		return firstName;
	}
	void setFirstName(String firstName){
		this.firstName = firstName;
	}
	String getLastName(){
		return lastName;
	}
	void setLastName(String lastName){
		this.lastName = lastName;
	}
	double getBalance(){
		return balance;
	}
	void setBalance(double balance){
		this.balance = balance;
	}
}
class CustomerResponse{
	long id;
	double balance;
	long getId(){
		return id;
	}
	double getBalance(){
		return balance;
	}
	void setBalance(double balance){
		this.balance = balance;
	}
}
class ICustomerDao{
	List<Customer> list = new ArrayList<>();
	void addCustomer(Customer customer){
		list.add(customer);
	}
	Customer findById(long id) throws CustomerIdNotFoundException{
		for(Customer customer : this.list){
			if(customer.getId() == id){
				return customer;
			}
		}
		throw new CustomerIdNotFoundException("Id not found exception");
	}
	Customer updateCustomer(Customer customer) throws CustomerIdNotFoundException{
		for(Customer c: this.list){
			if(c.getId() == customer.getId()){
				c = customer;
				return c;
			}
		}
		throw new CustomerIdNotFoundException("Id not found to update");
	}
	List<Customer> findAll(){
		List<Customer> found_list = new ArrayList<>();
		found_list.addAll(list);
		return found_list;
	}
}
class ICustomerService{
	ICustomerDao dao = new ICustomerDao();
	void addCustomer(String firstName, String lastName, double balance){
		Customer customer = new Customer(firstName, lastName, balance);
		dao.addCustomer(customer);
	}
	Customer findById(long id) throws CustomerIdNotFoundException{
		return dao.findById(id);
	}
	List<Customer> findCustomerByFirstName(String firstName){
		List<Customer> listByFirstName = new ArrayList<>();
		for(Customer customer : dao.list){
			if(customer.getFirstName().equals(firstName)){
				listByFirstName.add(customer);
			}
		}
		return listByFirstName;
	}
	List<Customer> findCustomersWithBalanceLessThanValue(double value){
		List<Customer> listWithBalanceLessThanValue = new ArrayList<>();
		for(Customer customer : dao.list){
			if(customer.getBalance() < value){
				listWithBalanceLessThanValue.add(customer);
			}
		}
		return listWithBalanceLessThanValue;
	}
	Customer debit(long customerId, double value) throws CustomerIdNotFoundException{
		for(Customer customer : dao.list){
			if(customer.getId() == customerId){
				customer.balance -= value;
				return customer;
			}
		}
		throw new CustomerIdNotFoundException("Id not found to debit");
	}
}
class CustomerIdNotFoundException extends Exception{
	public CustomerIdNotFoundException(String msg){
		super(msg);
	}
}
class FrontEnd{
	private ICustomerService service = new ICustomerService();
	public void runUI(){
		try{
			System.out.println("***Adding students***");
			Customer customer1 = new Customer("Prateek", "Singh", 40000.45);
			Customer customer2 = new Customer("Pratik", "Sings", 90000.45);
			display(customer1);
			display(customer2);
			service.addCustomer("Prateek", "Singh", 40000.45);
			service.addCustomer("Pratik", "Sings", 90000.45);
			System.out.println("***Finding customer by id***");
			Customer customer = service.findById(1);
			display(customer);
			System.out.println("***Finding customer by first name***");
			List<Customer> list = service.findCustomerByFirstName("Prateek");
			displayList(list);
			System.out.println("***Finding customer with balance less than value***");
			list = service.findCustomersWithBalanceLessThanValue(100000);
			displayList(list);
			System.out.println("***Debiting value from customer***");
			customer = service.debit(0, 500);
			display(customer);
		} catch(CustomerIdNotFoundException ex){
			// ex.printStackTrace();
			System.out.println(ex.getMessage());
		} catch(Exception ex){
			// ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}
	void display(Customer customer){
		System.out.println(customer.getId() + " - " + customer.getFirstName() + "-" + customer.getLastName() + " - " + customer.getBalance());
	}
	void displayList(List<Customer> customers){
		for(Customer customer : customers){
			display(customer);
		}
	}
}
class CustomerMain{
	public static void main(String args[]){
        FrontEnd frontEnd=new FrontEnd();
        frontEnd.runUI();
    }
}